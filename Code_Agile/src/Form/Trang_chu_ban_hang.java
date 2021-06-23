/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Class.TC_add_hoadon;
import Class.TC_hoadonchitiet;
import Class.TC_new;
import Class.TC_new_KH;
import Class.TC_new_table2;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hello Kiên
 */
public class Trang_chu_ban_hang extends javax.swing.JInternalFrame {

    /**
     * Creates new form lamLai_Trang_chu
     */
    ArrayList<TC_new> listTC1;
    ArrayList<TC_new_table2> listTC2;
    ArrayList<TC_new_KH> listKH;
    ArrayList<TC_hoadonchitiet> listHDCT;
    ArrayList<TC_add_hoadon> listHD;
    DefaultTableModel model;
    String url, dbUsername, dbPassword, sanphamAll, getKhachhang;
    int index;
    public static String nhanvien = "";

    public Trang_chu_ban_hang() {
        initComponents();
        this.listTC1 = new ArrayList<TC_new>();
        this.listTC2 = new ArrayList<TC_new_table2>();
        this.listKH = new ArrayList<TC_new_KH>();
        this.listHDCT = new ArrayList<TC_hoadonchitiet>();
        this.listHD = new ArrayList<TC_add_hoadon>();
        //
        this.url = "jdbc:sqlserver://localhost:1433;databaseName=QLBH";
        this.dbUsername = "sa";
        this.dbPassword = "111111";
        this.sanphamAll = "select*from  SANPHAM";
        this.getKhachhang = "select*from KHACHHANG";
        //
        this.listTC1 = this.festchList();
        this.listKH = this.do_dl_len_cbKH();
        this.fillTable();
        this.do_dl_len_cbKH();

        //mã hóa đơn
        Random rd = new Random();
        int a = rd.nextInt(1000000);
        txtMaHD.setText("HD" + a);
        txtMaHD.disable();
        //lấy ngày
        txtDate.setText(java.time.LocalDate.now() + "");
        txtDate.disable();
        //nhân viên
        txtNhanvien.setText(nhanvien);
        txtNhanvien.disable();
    }

    protected void fillTable() {
        model = (DefaultTableModel) tblThongtinsp.getModel();
        model.setRowCount(0);
        for (TC_new tc : listTC1) {
            model.addRow(new Object[]{tc.getMaSp(), tc.getTenSP(), tc.getGia(), tc.getSo_luong()});
        }
    }

    //lấy dl bảng sp
    protected ArrayList<TC_new> festchList() {
        ArrayList<TC_new> result = new ArrayList<TC_new>();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(this.url, this.dbUsername, this.dbPassword);
            Statement st = conn.createStatement();

            String query = this.sanphamAll;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String maSP = rs.getString("maSP");
                String tenSP = rs.getString("tenSP");
                float gia = rs.getFloat("giaSP");
                int so_luong = rs.getInt("soLuong");
                result.add(new TC_new(maSP, tenSP, gia, so_luong));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_chu_ban_hang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_chu_ban_hang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    //lấy dl khách hàng
    protected ArrayList<TC_new_KH> do_dl_len_cbKH() {
        ArrayList<TC_new_KH> result = new ArrayList<TC_new_KH>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(this.url, this.dbUsername, this.dbPassword);
            Statement st = conn.createStatement();

            String query = this.getKhachhang;
            ResultSet rs = st.executeQuery(query);
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbKhachhang.getModel();
            cbbModel.removeAllElements();
            while (rs.next()) {
                String maKH = rs.getString("maKH");
                String tenKH = rs.getString("tenKH");
                result.add(new TC_new_KH(maKH, tenKH));
                //add model
                cbbModel.addElement(rs.getString("tenKH"));
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Trang_chu_ban_hang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Trang_chu_ban_hang.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongtinsp = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTimSP = new javax.swing.JTextField();
        btnTimSP = new javax.swing.JButton();
        cbGia = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblhoadon = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNhanvien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTimKH = new javax.swing.JTextField();
        btnTimKH = new javax.swing.JButton();
        cbKhachhang = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtTongtien = new javax.swing.JTextField();
        btnHuy = new javax.swing.JButton();
        btnThanhtoan = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtGhichu = new javax.swing.JTextArea();

        jLabel5.setText("jLabel5");

        jTextField5.setText("jTextField5");

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LAPTOP ASUS");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblThongtinsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Giá", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThongtinsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThongtinspMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblThongtinsp);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Thông tin sản phẩm");

        txtTimSP.setText("Tìm theo tên ...");
        txtTimSP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimSPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimSPFocusLost(evt);
            }
        });

        btnTimSP.setText("Tìm kiếm");
        btnTimSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimSPActionPerformed(evt);
            }
        });

        cbGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Dưới 10 triệu", "Từ 10 đến 20 triệu", "Trên 20 triệu" }));
        cbGia.setToolTipText("");
        cbGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGiaActionPerformed(evt);
            }
        });

        jLabel3.setText("Giá :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTimSP))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(36, 36, 36)
                                .addComponent(cbGia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel2))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimSP))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Bán hàng"));

        tblhoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Số lượng", "Giá(Triêu đồng)", "Giảm giá (%)", "Thành tiền (Triệu đồng)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblhoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhoadonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblhoadon);

        jLabel4.setText("Mã hóa đơn :");

        txtMaHD.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        jLabel6.setText("Nhân viên bán:");

        txtNhanvien.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtNhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhanvienActionPerformed(evt);
            }
        });

        jLabel7.setText("Khách hàng :");

        txtTimKH.setText("Nhập tên ..");
        txtTimKH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKHFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKHFocusLost(evt);
            }
        });

        btnTimKH.setText("Tìm kiếm");
        btnTimKH.setToolTipText("");
        btnTimKH.setActionCommand("");
        btnTimKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKHActionPerformed(evt);
            }
        });

        cbKhachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKhachhangActionPerformed(evt);
            }
        });

        jLabel9.setText("Tổng tiền :");

        btnHuy.setText("Hủy đơn");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnThanhtoan.setText("Thanh toán");
        btnThanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhtoanActionPerformed(evt);
            }
        });

        jLabel8.setText("Ngày bán :");

        txtDate.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtDate.setForeground(new java.awt.Color(51, 0, 51));

        jLabel10.setText("Ghi chú :");

        txtGhichu.setColumns(20);
        txtGhichu.setRows(5);
        jScrollPane3.setViewportView(txtGhichu);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(cbKhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtTimKH, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTimKH)))
                        .addGap(44, 44, 44)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDate))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHuy)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThanhtoan)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, jLabel6});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKH)
                    .addComponent(jLabel8)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbKhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHuy)
                            .addComponent(btnThanhtoan)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(373, 373, 373)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//    public static String soluong, giamGia ,ghiChu;

    private void tblThongtinspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongtinspMouseClicked
        String soluong = JOptionPane.showInputDialog(this, "nhập số lượng sản phẩm cần mua");
        int b = 0;
        try {
            b = Integer.parseInt(soluong);
            if (b <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số");
            return;
        }
        String giamGia = JOptionPane.showInputDialog(this, "Giảm giá(%)");
        float c = 0;

        try {
            c = Float.parseFloat(giamGia);
            if (c < 0 || c > 100) {
                JOptionPane.showMessageDialog(this, "Giảm từ 0 -- > 100 %");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Giảm giá phải là số");
            return;
        }
        //add vao list
        index = tblThongtinsp.getSelectedRow();
        TC_new tc = listTC1.get(index);
        String maSP = tc.getMaSp();
        String tenSP = tc.getTenSP();
        int so_luong = Integer.parseInt(soluong);
        float gia = tc.getGia();
        float giam_gia = 0;
        if (giamGia.length() == 0) {
            giam_gia = 0;
        } else {
            giam_gia = Float.parseFloat(giamGia);
        }
        float thanh_tien = gia * so_luong - ((giam_gia * gia) / 100) * so_luong;
        listTC2.add(new TC_new_table2(maSP, tenSP, so_luong, gia, giam_gia, thanh_tien));
        this.fillTable2();
        this.tong_tien();

    }//GEN-LAST:event_tblThongtinspMouseClicked
    public void tong_tien() {
        float tong_tien = 0;
        for (TC_new_table2 tc : listTC2) {
            tong_tien += tc.getThanh_tien();
        }
        txtTongtien.setText(tong_tien + " Triệu đồng");
    }

    protected void fillTable2() {
        model = (DefaultTableModel) tblhoadon.getModel();
        model.setRowCount(0);
        for (TC_new_table2 tc : listTC2) {
            model.addRow(new Object[]{tc.getMaSP(), tc.getTenSP(), tc.getSoluong(), tc.getGia(), tc.getGiamgia(), tc.getThanh_tien()});
        }
    }
    private void tblhoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhoadonMouseClicked
        if (evt.getClickCount() >= 2) {
            int ck = JOptionPane.showConfirmDialog(this, "Bạn muốn hủy bán sản phẩm này ?");
            if (ck != JOptionPane.YES_OPTION) {
                return;
            }
            index = tblhoadon.getSelectedRow();
            listTC2.remove(index);
            this.fillTable2();
            this.tong_tien();
        }
    }//GEN-LAST:event_tblhoadonMouseClicked

    private void txtTimSPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimSPFocusGained
        if (txtTimSP.getText().trim().equals("Tìm theo tên ...")) {
            txtTimSP.setText("");
        }
    }//GEN-LAST:event_txtTimSPFocusGained

    private void txtTimSPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimSPFocusLost
        if (txtTimSP.getText().trim().equals("")) {
            txtTimSP.setText("Tìm theo tên ...");
        }
    }//GEN-LAST:event_txtTimSPFocusLost

    private void btnTimSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimSPActionPerformed
        this.sanphamAll = "select*from  SANPHAM";
        this.listTC1 = this.festchList();
        this.fillTable();

        int a = 0;
        for (TC_new tc : listTC1) {
            if (tc.getTenSP().toUpperCase().contains(txtTimSP.getText().toUpperCase())) {
                this.sanphamAll = "select*from SANPHAM where tenSP like '%" + txtTimSP.getText() + "%'";
                this.listTC1 = this.festchList();
                this.fillTable();
                a = 1;
            }
        }

        if (a == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm này ");
            txtTimSP.requestFocus();
            return;
        }

    }//GEN-LAST:event_btnTimSPActionPerformed

    private void cbGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGiaActionPerformed
        if (cbGia.getSelectedIndex() == 1) {
            this.sanphamAll = "select*from SANPHAM where giaSP < 10 ";
            this.listTC1 = this.festchList();
            this.fillTable();
        }
        if (cbGia.getSelectedIndex() == 2) {
            this.sanphamAll = "select*from SANPHAM where giaSP > 10 and  giaSP < 20";
            this.listTC1 = this.festchList();
            this.fillTable();
        }
        if (cbGia.getSelectedIndex() == 3) {
            this.sanphamAll = "select*from SANPHAM where giaSP > 20 ";
            this.listTC1 = this.festchList();
            this.fillTable();
        }
        if (cbGia.getSelectedIndex() == 0) {
            this.sanphamAll = "select*from SANPHAM";
            this.listTC1 = this.festchList();
            this.fillTable();
        }
    }//GEN-LAST:event_cbGiaActionPerformed

    private void cbKhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKhachhangActionPerformed

    }//GEN-LAST:event_cbKhachhangActionPerformed
    //tìm khách hàng
    private void btnTimKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKHActionPerformed
        this.getKhachhang = "select*from KHACHHANG";
        this.do_dl_len_cbKH();
        int ck = 0;

        for (TC_new_KH kh : listKH) {
            if (kh.getTenKH().toUpperCase().contains(txtTimKH.getText().toUpperCase())) {
                this.getKhachhang = "select*from KHACHHANG where tenKH like N'%" + txtTimKH.getText().trim() + "%'";
                this.do_dl_len_cbKH();
                ck = 1;
            }
        }

        if (ck == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng");
            return;
        }
    }//GEN-LAST:event_btnTimKHActionPerformed

    private void txtTimKHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKHFocusGained
        if (txtTimKH.getText().equals("Nhập tên ..")) {
            txtTimKH.setText("");
        }
    }//GEN-LAST:event_txtTimKHFocusGained

    private void txtTimKHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKHFocusLost
        if (txtTimKH.getText().equals("")) {
            txtTimKH.setText("Nhập tên ..");
        }
    }//GEN-LAST:event_txtTimKHFocusLost

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        model = (DefaultTableModel) tblhoadon.getModel();
        model.setRowCount(0);
        txtTongtien.setText("0 VND");
        cbKhachhang.setSelectedIndex(0);
        listTC2.clear();
    }//GEN-LAST:event_btnHuyActionPerformed
    //thêm dữ liệu vào database hoadon , hoadonchitiet
    private void btnThanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhtoanActionPerformed
        //nhân viên
        txtNhanvien.setText(nhanvien);
        txtNhanvien.disable();
        //check nv
        if (txtNhanvien.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn phải đăng nhập để có thể bán hàng\n Menu chọn: Tài khoản --> Đăng nhập");
            return;
        }
        if(listTC2.size()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm nào");
            return;
        }
        try {
            this.add_hd();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi hd");
            return;
        }
        try {
            this.add_hdct();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi hdct");
            return;
        }
        JOptionPane.showMessageDialog(this, "Đã bán thành công");
        
    }//GEN-LAST:event_btnThanhtoanActionPerformed
    //random ma hdct
    protected String mahdct() {
        Random rd = new Random();
        int a = rd.nextInt(1000000);
        return "CT" + a;
    }
    //lấy dl bảng đổ vào list

    protected void themvaolist_HDCT() {
        listHDCT.clear();
        String MaHD = txtMaHD.getText();
        for (TC_new_table2 tc : listTC2) {
            listHDCT.add(new TC_hoadonchitiet(mahdct(), MaHD, tc.getSoluong(), tc.getMaSP(), tc.getGia(), tc.getGiamgia()));
        }
    }
    //đổ dl vào listHD
    public static String MaNV;
    protected void themvaolist_HD() {
        
        String MaHD = txtMaHD.getText();
        String maNV = this.MaNV;
        String maKH = "";
        for (TC_new_KH kh : listKH) {
            if (kh.getTenKH().equals(cbKhachhang.getSelectedItem())) {
                maKH = kh.getMaKH();
            }
        }
        listHD.clear();
        listHD.add(new TC_add_hoadon(MaHD, maNV, maKH, txtDate.getText(), txtGhichu.getText()));

    }

    //add hodonct
    protected void add_hdct() {
        this.themvaolist_HDCT();
        for (TC_hoadonchitiet hd : listHDCT) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection(this.url, this.dbUsername, this.dbPassword);

                String query = "insert into HoaDonChiTiet values(?,?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(query);

                ps.setString(1, hd.getMaHoaDonChiTiet());
                ps.setString(2, hd.getMaHD());
                ps.setFloat(3, hd.getSoLuong());
                ps.setString(4, hd.getMaSP());
                ps.setFloat(5, hd.getGiaSP());
                ps.setFloat(6, hd.getGiamGia());
                ps.execute();

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Trang_chu_ban_hang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Trang_chu_ban_hang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //add vào hóa dơn
    protected void add_hd() {
        this.themvaolist_HD();
        for (TC_add_hoadon hd : listHD) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection conn = DriverManager.getConnection(this.url, this.dbUsername, this.dbPassword);

                String query = "insert into HoaDon values(?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, hd.getMaHD());
                ps.setString(2, hd.getMaNV());
                ps.setString(3, hd.getMaKH());
                ps.setDate(4, Date.valueOf(hd.getNgayMuaHang()));
                ps.setString(5, hd.getGhiChu());
                ps.execute();

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Trang_chu_ban_hang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Trang_chu_ban_hang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void txtNhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNhanvienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNhanvienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnThanhtoan;
    private javax.swing.JButton btnTimKH;
    private javax.swing.JButton btnTimSP;
    private javax.swing.JComboBox<String> cbGia;
    private javax.swing.JComboBox<String> cbKhachhang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTable tblThongtinsp;
    private javax.swing.JTable tblhoadon;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextArea txtGhichu;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNhanvien;
    private javax.swing.JTextField txtTimKH;
    private javax.swing.JTextField txtTimSP;
    private javax.swing.JTextField txtTongtien;
    // End of variables declaration//GEN-END:variables

}
