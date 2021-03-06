/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Class.KhachHang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hello Kiên
 */
public class khach_hang extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    int index;
    String url, user, pass;
    ArrayList<KhachHang> listKH;
    String queryAll;

    public khach_hang() {
        initComponents();
        this.url = "jdbc:sqlserver://localhost:1433;databaseName=QLBH";
        this.user = "sa";
        this.pass = "111111";
        this.listKH = new ArrayList<>();
        this.queryAll = "select * from KhachHang";
        this.listKH = fetchList();
        filltoTable(listKH);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMakhachhang = new javax.swing.JTextField();
        txtTenkhachhang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSodienthoai = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiachi = new javax.swing.JTextArea();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhachhang = new javax.swing.JTable();
        txtTimkiem = new javax.swing.JTextField();
        btnTimkiem = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        rboNam = new javax.swing.JRadioButton();
        rboNu = new javax.swing.JRadioButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("KHÁCH HÀNG");

        jLabel2.setText("Mã khách hàng:");

        jLabel3.setText("Tên khách hàng:");

        jLabel4.setText("Số điện thoại:");

        jLabel5.setText("Email:");

        jLabel6.setText("Địa chỉ:");

        txtDiachi.setColumns(20);
        txtDiachi.setRows(5);
        jScrollPane1.setViewportView(txtDiachi);

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icon_Them_dangky.png"))); // NOI18N
        btnThem.setText("Thêm khách hàng");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icon_xoa.png"))); // NOI18N
        btnXoa.setText("Xóa khách hàng");

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icon_suachua.png"))); // NOI18N
        btnSua.setText("Sửa thông tin");

        tblKhachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Giới tính", "Email", "Địa chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachhangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKhachhang);

        txtTimkiem.setText("Search name..");
        txtTimkiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimkiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimkiemFocusLost(evt);
            }
        });

        btnTimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icon_timkiem.png"))); // NOI18N
        btnTimkiem.setText("Tìm kiếm");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        jLabel7.setText("Giới tính:");

        buttonGroup1.add(rboNam);
        rboNam.setSelected(true);
        rboNam.setText("Nam");

        buttonGroup1.add(rboNu);
        rboNu.setText("Nữ");
        rboNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rboNuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(425, 425, 425)
                                .addComponent(jLabel5)
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addComponent(btnTimkiem))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(23, 23, 23)
                                            .addComponent(txtMakhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addComponent(jLabel3))
                                            .addGap(23, 23, 23)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(txtTenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(141, 141, 141)
                                                    .addComponent(jLabel6))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(rboNam)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(rboNu))
                                                .addComponent(txtSodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(btnThem)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(btnXoa)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(btnSua)))))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(370, 370, 370)
                        .addComponent(jLabel1)))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSua, btnThem, btnXoa});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtEmail, txtMakhachhang, txtSodienthoai, txtTenkhachhang});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel7});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtMakhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtTenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtSodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(rboNam)
                                    .addComponent(rboNu))
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnThem)
                                    .addComponent(btnXoa)
                                    .addComponent(btnSua))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimkiem))
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSua, btnThem, btnXoa});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rboNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rboNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rboNuActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            if (txtMakhachhang.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Nhập mã khách hàng");
                txtMakhachhang.requestFocus();
                return;
            } else if (txtTenkhachhang.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Nhập tên khách hàng");
                txtTenkhachhang.requestFocus();
                return;
            } else if (txtSodienthoai.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Nhập số điện thoại");
                txtSodienthoai.requestFocus();
                return;
            }
            int so;
            try {
                so = Integer.parseInt(txtSodienthoai.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Nhập số điện thoại là số");
                txtSodienthoai.requestFocus();
                return;
            }
            if (txtSodienthoai.getText().length() < 10 || txtSodienthoai.getText().length() > 10) {
                JOptionPane.showMessageDialog(this, "Nhập số điện thoại đủ 10 số");
                txtSodienthoai.requestFocus();
                return;
            }

            if (txtEmail.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Nhập email");
                txtEmail.requestFocus();
                return;
            }
            String email = "\\w+@\\w+(\\.\\w+){1,2}";
            if (!txtEmail.getText().matches(email)) {
                JOptionPane.showMessageDialog(this, "Nhập đúng định dạng email");
                txtEmail.requestFocus();
                return;
            }

            if (txtDiachi.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Nhập địa chỉ");
                txtDiachi.requestFocus();
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi");
            return;
        }

        JOptionPane.showMessageDialog(this, "OK");
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        this.queryAll = "select * from KhachHang";
        this.listKH = fetchList();
        filltoTable(listKH);
       
        int flag = 0;
        for (KhachHang kh : listKH) {
            if (kh.getTenKH().toUpperCase().contains(txtTimkiem.getText().toUpperCase())) {
                flag = 1;
                queryAll = "select * from KhachHang where tenKH like N'%"
                        + txtTimkiem.getText() + "%'";
                this.listKH = fetchList();
                filltoTable(listKH);
            }
        }
        if (flag == 0) {
            JOptionPane.showMessageDialog(this, "Không có khách hàng cần tìm !");
            return;
        }
    }//GEN-LAST:event_btnTimkiemActionPerformed

    private void tblKhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachhangMouseClicked
        index = tblKhachhang.getSelectedRow();
        try {
            if (index >= 0) {
                showDetail();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblKhachhangMouseClicked

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rboNam;
    private javax.swing.JRadioButton rboNu;
    private javax.swing.JTable tblKhachhang;
    private javax.swing.JTextArea txtDiachi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMakhachhang;
    private javax.swing.JTextField txtSodienthoai;
    private javax.swing.JTextField txtTenkhachhang;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables

    private ArrayList<KhachHang> fetchList() {
        ArrayList<KhachHang> result = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement st = conn.createStatement();
            String query = this.queryAll;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String makh = rs.getString("maKH");
                String tenkh = rs.getString("tenkh");
                String sdt = rs.getString("sodt");
                String gt = rs.getString("gioiTinh");
                String email = rs.getString("email");
                String diachi = rs.getString("diachi");
                result.add(new KhachHang(makh, tenkh, sdt, gt, email, diachi));
            }
        } catch (SQLException ex) {
            Logger.getLogger(khach_hang.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(khach_hang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    private void filltoTable(ArrayList<KhachHang> listKH) {
        model = (DefaultTableModel) tblKhachhang.getModel();
        model.setRowCount(0);
        for (KhachHang kh : listKH) {
            model.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(),
                kh.getSdt(), kh.getGioiTinh(), kh.getEmail(), kh.getDiaChi()});
        }

    }

    private void showDetail() {
        KhachHang kh = listKH.get(index);
        txtMakhachhang.setText(kh.getMaKH());
        txtTenkhachhang.setText(kh.getTenKH());
        txtSodienthoai.setText(kh.getSdt());
        txtEmail.setText(kh.getEmail());
        txtDiachi.setText(kh.getDiaChi());
        if (kh.getGioiTinh().equals("Nam")) {
            rboNam.setSelected(true);
        } else {
            rboNu.setSelected(true);
        }
        tblKhachhang.setRowSelectionInterval(index, index);
    }
}
