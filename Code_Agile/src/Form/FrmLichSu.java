/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Class.Lich_su;
import Class.Lich_su1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class FrmLichSu extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmLichSu
     */
    protected ArrayList<Lich_su> listLS;
    protected ArrayList<Lich_su1> listLS1;
    protected DefaultTableModel model;
    protected String url, dbUsername, dbPassword, getAll;
    protected int index;

    public FrmLichSu() {
        initComponents();
        this.listLS = new ArrayList<Lich_su>();
        this.listLS1 = new ArrayList<Lich_su1>();
        this.url = "jdbc:sqlserver://localhost:1433;databaseName=QLBH";
        this.dbUsername = "sa";
        this.dbPassword = "111111";
        this.getAll = "select hd.maHD,sp.maSP,maNV,maKH,sp.tenSP,hdct.SoLuong,hdct.GiaSP,GiamGia,hd.NgayMuaHang,GhiChu\n"
                + "from HoaDonChiTiet hdct inner join HOADON hd on hdct.maHD=hd.maHD\n"
                + "		inner join SANPHAM sp on sp.maSP=hdct.maSP";
        // in lên bảng
        this.listLS = this.festchList();
        this.listLS1 = this.festchListTop();
        this.fillTable();
        this.fillTableTop();

        //tinh doanh thu
        txtDoanhThu.disable();
        float doanh_thu = 0;
        for (Lich_su ls : listLS) {
            doanh_thu = (ls.thanh_tien(ls.getSo_luong(), ls.getGia(), ls.getGiam_gia()) + doanh_thu);
        }
        txtDoanhThu.setText(doanh_thu + " triệu đồng");

        //tính so sp ban
        txtSoSpBan.disable();
        int soSPban = 0;
        for (Lich_su ls : listLS) {
            soSPban += ls.getSo_luong();
        }
        txtSoSpBan.setText(soSPban + " sản phẩm");

        //tính so sp con lai
        txtSoSPCon.disable();
        int tongSP = 0;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(this.url, this.dbUsername, this.dbPassword);
            Statement st = conn.createStatement();
            String query = "select sum(soLuong) as tongSP from SANPHAM";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                tongSP = rs.getInt("tongSP");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmLichSu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmLichSu.class.getName()).log(Level.SEVERE, null, ex);
        }
        int SPcon = tongSP - soSPban;
        txtSoSPCon.setText(SPcon + " sản phẩm");

    }

    protected void fillTable() {

        model = (DefaultTableModel) tblLichSuGD.getModel();
        model.setRowCount(0);
        for (Lich_su ls : listLS) {
            model.addRow(new Object[]{ls.getMa_hd(), ls.getMa_sp(), ls.getMa_nv(), ls.getMa_kh(),
                ls.getTen_sp(), ls.getSo_luong(), ls.getGia(), ls.getGiam_gia(),
                ls.thanh_tien(ls.getSo_luong(), ls.getGia(), ls.getGiam_gia()), ls.getNgay_ban(), ls.getGhi_chu()});
        }
    }

    protected ArrayList<Lich_su> festchList() {
        ArrayList<Lich_su> result = new ArrayList<Lich_su>();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(this.url, this.dbUsername, this.dbPassword);
            Statement st = conn.createStatement();

            String query = this.getAll;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String maHD = rs.getString("maHD");
                String maSP = rs.getString("maSP");
                String maNV = rs.getString("maNV");
                String maKH = rs.getString("maKH");
                String tenSP = rs.getString("tenSP");
                int so_luong = rs.getInt("SoLuong");
                float gia = rs.getFloat("GiaSP");
                float giam_gia = rs.getFloat("GiamGia");
                String ngayban = rs.getString("NgayMuaHang");
                String ghichu = rs.getString("GhiChu");
                result.add(new Lich_su(maHD, maSP, maNV, maKH, tenSP, so_luong, gia, giam_gia, ngayban, ghichu));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmLichSu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmLichSu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    protected void fillTableTop() {
        model = (DefaultTableModel) tblTopBanChay.getModel();
        model.setRowCount(0);
        for (Lich_su1 ls : listLS1) {
            model.addRow(new Object[]{ls.getMa_sp(), ls.getTen_sp(), ls.getSo_luong()});
        }
    }

    protected ArrayList<Lich_su1> festchListTop() {
        ArrayList<Lich_su1> result = new ArrayList<Lich_su1>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(this.url, this.dbUsername, this.dbPassword);
            Statement st = conn.createStatement();

            String query = "select top 3 sp.maSP,sp.tenSP,sum(hdct.SoLuong) as Tong\n"
                    + "from HoaDonChiTiet hdct inner join HOADON hd on hdct.maHD=hd.maHD\n"
                    + "		inner join SANPHAM sp on sp.maSP=hdct.maSP\n"
                    + "group by sp.maSP,sp.tenSP";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String maSP = rs.getString("maSP");
                String tenSP = rs.getString("tenSP");
                int Tong = rs.getInt("Tong");
                result.add(new Lich_su1(maSP, tenSP, Tong));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmLichSu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmLichSu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLichSuGD = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDoanhThu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSoSpBan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSoSPCon = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTopBanChay = new javax.swing.JTable();
        txtTimkiem = new javax.swing.JTextField();
        btnTimkiem = new javax.swing.JButton();

        setClosable(true);
        setTitle("Lịch Sử Giao Dịch");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("LỊCH SỬ GIAO DỊCH");

        tblLichSuGD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐ", "Mã SP", "Mã NV", "Mã KH", "Tên SP", "Số Lượng", "Giá(1sp)", "Giảm giá(%)", "Thành tiền(triệu)", "Ngày Bán", "Ghi Chú"
            }
        ));
        jScrollPane1.setViewportView(tblLichSuGD);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("THỐNG KÊ");

        jLabel3.setText("DOANG THU");

        txtDoanhThu.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDoanhThuActionPerformed(evt);
            }
        });

        jLabel4.setText("SỐ SP ĐÃ BÁN");

        txtSoSpBan.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jLabel5.setText("SỐ SP CÒN LẠI");

        txtSoSPCon.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtSoSPCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoSPConActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("TOP SP BÁN CHẠY");

        tblTopBanChay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Số Lượng"
            }
        ));
        jScrollPane2.setViewportView(tblTopBanChay);

        txtTimkiem.setText("Search name..");
        txtTimkiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimkiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimkiemFocusLost(evt);
            }
        });
        txtTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimkiemActionPerformed(evt);
            }
        });

        btnTimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icon_timkiem.png"))); // NOI18N
        btnTimkiem.setText("Tìm kiếm");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(345, 345, 345))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTimkiem))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGap(21, 21, 21))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoSPCon, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoSpBan, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimkiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSoSpBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoSPCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSoSPConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoSPConActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoSPConActionPerformed

    private void txtDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDoanhThuActionPerformed

    }//GEN-LAST:event_txtDoanhThuActionPerformed

    private void txtTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimkiemActionPerformed

    private void txtTimkiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimkiemFocusGained
        if (txtTimkiem.getText().trim().equals("Search name..")) {
            txtTimkiem.setText("");
        }
    }//GEN-LAST:event_txtTimkiemFocusGained

    private void txtTimkiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimkiemFocusLost
        if (txtTimkiem.getText().trim().equals("")) {
            txtTimkiem.setText("Search name..");
        }
    }//GEN-LAST:event_txtTimkiemFocusLost

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        this.getAll = "select hd.maHD,sp.maSP,maNV,maKH,sp.tenSP,hdct.SoLuong,hdct.GiaSP,GiamGia,hd.NgayMuaHang,GhiChu\n"
                + "from HoaDonChiTiet hdct inner join HOADON hd on hdct.maHD=hd.maHD\n"
                + "		inner join SANPHAM sp on sp.maSP=hdct.maSP";
        this.listLS = this.festchList();
        this.fillTable();

        int ck = 0;
        for (Lich_su ls : listLS) {
            if (ls.getTen_sp().toUpperCase().contains(txtTimkiem.getText().toUpperCase())) {
                this.getAll = "select hd.maHD,sp.maSP,maNV,maKH,sp.tenSP,hdct.SoLuong,hdct.GiaSP,GiamGia,hd.NgayMuaHang,GhiChu\n"
                        + "from HoaDonChiTiet hdct inner join HOADON hd on hdct.maHD=hd.maHD\n"
                        + "		inner join SANPHAM sp on sp.maSP=hdct.maSP\n"
                        + "where tenSP like'%"+txtTimkiem.getText().trim()+"%'";
                this.listLS = this.festchList();
                this.fillTable();
                ck=1;
            }
        }
        if(ck==0){
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm này ở hóa đơn");
            return;
        }
    }//GEN-LAST:event_btnTimkiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblLichSuGD;
    private javax.swing.JTable tblTopBanChay;
    private javax.swing.JTextField txtDoanhThu;
    private javax.swing.JTextField txtSoSPCon;
    private javax.swing.JTextField txtSoSpBan;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
