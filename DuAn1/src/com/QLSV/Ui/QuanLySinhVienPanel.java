/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.QLSV.Ui;

import com.QLSV.DAO.NganhDAO;
import com.QLSV.DAO.SinhVienDAO;
import com.QLSV.Model.Nganh;
import com.QLSV.Model.SinhVien;
import com.QLSV.Utility.MsgBox;
import com.QLSV.Utility.Other;
import com.QLSV.Utility.XImage;
import com.QLSV.Utility.utilityHelper;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import static java.awt.Color.pink;
import static java.awt.Color.white;
import java.awt.HeadlessException;
import java.io.File;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import sun.security.x509.RDN;

/**
 *
 * @author tontr
 */
public class QuanLySinhVienPanel extends javax.swing.JPanel {

    /**
     * Creates new form QuanLySinhVienPanel
     */
    public QuanLySinhVienPanel() {
        initComponents();
        Other.setTable(tblSinhVien);
        load();
        fillComboBox();
        txtNgayVao.setDateFormatString("dd-MM-yyyy");
        txtNgayVao1.setDateFormatString("dd-MM-yyyy");
        txtNgayVao2.setDateFormatString("dd-MM-yyyy");


    }
    int index= 0;
    SinhVienDAO svdao= new SinhVienDAO();
    NganhDAO ngdao = new NganhDAO();
    JFileChooser fileChooser = new JFileChooser();
    String maNganh= "";
    void load() {
        DefaultTableModel model = (DefaultTableModel) tblSinhVien.getModel();
        model.setRowCount(0);   //đưa số dòng về 0 (xóa bảng)
        try {
            List<SinhVien> list = svdao.selectAll();
            for (SinhVien sv : list) {
                Object[] row = {
                    sv.getMaSinhVien(),
                    sv.getTenSinhVien(),
                    sv.getSoDienThoai(),
                    sv.getCmnd(),
                    sv.isGioiTinh() ? "Nữ" : "Nam",
                    sv.getTenNganh(),
                    sv.isTinhTrang() ? "Đang Học" : "Bảo Lưu",
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    List<Nganh> list ;
    void fillComboBox() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbNghanhHoc.getModel(); 
        model.removeAllElements();  
        
        try {
            list = ngdao.selectAll();
            for (Nganh cd : list) {
                model.addElement(cd.getTenNganh());
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    void insert() {
        SinhVien model = getModel();
        try {
            svdao.insert(model);   
            this.load();                  
            JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
        } catch (Exception e) {
            
        }
    }
    void insertDiem() {
        SinhVien model = getModel(); 
        String manganh= "";
        for (Nganh nganh : list) {
            if(cbbNghanhHoc.getSelectedItem().toString().equals(nganh.getTenNganh())){
                manganh= nganh.getMaNganh();
            }
        }
        try {
            svdao.InsertDiem(model.getMaSinhVien(),manganh);   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void update() {
        SinhVien model = getModel();
        try {
            svdao.update(model);   
            this.load();         
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
            e.printStackTrace();
        }
    }
    void delete() {
            String masv = txtMaSinhVien.getText();
            try {
                svdao.delete(masv);
                this.load();
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!");
            }
    }

    public void setTrang() {
        txtMaSinhVien.setBackground(white);
        txtTenSinhVien.setBackground(white);
        txtCMND.setBackground(white);
        txtEmail.setBackground(white);
        txtNgayVao.setBackground(white);
        txtNgayVao1.setBackground(white);
        txtNgayVao2.setBackground(white);
        txtSoDienThoai.setBackground(white);
        txtMaSinhVien.setText("");
        txtTenSinhVien.setText("");
        txtCMND.setText("");
        txtEmail.setText("");
        txtNgayVao.setCalendar(null);
        txtNgayVao1.setCalendar(null);
        txtNgayVao2.setCalendar(null);
        txtSoDienThoai.setText("");
    }


    void edit() {
        setTrang();
        try {
            String manh = (String) tblSinhVien.getValueAt(this.index, 0);
            SinhVien model = svdao.selectByID(manh);  
            if (model != null) {
                this.setModel(model);  
            }
        } catch (Exception e) {
        }
    }
    void setModel(SinhVien model) {
        txtMaSinhVien.setText(model.getMaSinhVien().toString().substring(2));
        txtTenSinhVien.setText(model.getTenSinhVien());
        txtSoDienThoai.setText(model.getSoDienThoai());
        txtCMND.setText(model.getCmnd());
        txtEmail.setText(model.getEmail());
        bttNam.setSelected(!model.isGioiTinh());
        bttNu.setSelected(model.isGioiTinh());
        txtNgayVao.setDate(model.getNgayNhapHoc());
        txtNgayVao1.setDate(model.getNgaySinh());
        txtNgayVao2.setDate(model.getNgayTotNgiep());
        bttBaoLuu.setSelected(!model.isTinhTrang());
        bttDangHoc.setSelected(model.isTinhTrang());
        lblHinh.setToolTipText(model.getAnhDaiDien());
        lblHinh.setIcon(XImage.readLogo(model.getAnhDaiDien()));
        cbbNghanhHoc.setSelectedItem(model.getTenNganh());
//        cbbNghanhHoc.setToolTipText(model.getTenNganh());
//        cbbNghanhHoc.getModel().setSelectedItem(model.getTenNganh());
    }

    SinhVien getModel() {
        SinhVien model = new SinhVien();
        model.setMaSinhVien("SV"+txtMaSinhVien.getText());
        System.out.println(model.getMaSinhVien());
        model.setTenSinhVien(txtTenSinhVien.getText());
        model.setGioiTinh(bttNam.isSelected());
        model.setTinhTrang(bttDangHoc.isSelected());
        model.setSoDienThoai(txtSoDienThoai.getText());
        model.setCmnd(txtCMND.getText());
        model.setNgayNhapHoc( new java.sql.Date(txtNgayVao.getDate().getTime()));
        model.setNgaySinh(new java.sql.Date(txtNgayVao1.getDate().getTime()));
        model.setNgayTotNgiep(new java.sql.Date(txtNgayVao2.getDate().getTime()));
        model.setEmail(txtEmail.getText());  
        model.setAnhDaiDien(lblHinh.getToolTipText());
        Object a = (Object) cbbNghanhHoc.getSelectedItem();
        String b = String.valueOf(a);
        model.setTenNganh(b);
//        model.setTenNganh(String.valueOf(cbbNghanhHoc.getToolTipText()));
        return model;
    }
    void selectImage() {
        fileChooser.setCurrentDirectory(new java.io.File("."));
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (XImage.saveLogo(file)) { 
                lblHinh.setIcon(XImage.readLogo(file.getName())); 
                lblHinh.setToolTipText(file.getName());
            }
        }
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtMaSinhVien = new javax.swing.JTextField();
        txtTenSinhVien = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtCMND = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTimKiem = new javax.swing.JTextField();
        cbbNghanhHoc = new javax.swing.JComboBox<>();
        txtNgayVao = new com.toedter.calendar.JDateChooser();
        txtNgayVao1 = new com.toedter.calendar.JDateChooser();
        txtNgayVao2 = new com.toedter.calendar.JDateChooser();
        bttNam = new javax.swing.JRadioButton();
        bttNu = new javax.swing.JRadioButton();
        bttDangHoc = new javax.swing.JRadioButton();
        bttBaoLuu = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        btnNew = new javax.swing.JLabel();
        btnSave = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSinhVien = new javax.swing.JTable();
        lblHinh = new javax.swing.JLabel();
        btnXoaAnh = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1180, 780));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/DangXuat.png"))); // NOI18N
        jLabel15.setText("Xem lịch sử ");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 50, -1, 40));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 31, 151));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ SINH VIÊN");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1168, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Mã sinh viên :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 107, 98, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Tên sinh viên :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 152, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Số điện thoại :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 197, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("CMND/CCCD :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 242, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Email :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 293, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Giới tính :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 338, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Nghành học :");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 107, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("Ngày nhập học :");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 152, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setText("Ngày tốt nghiệp :");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 197, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setText("Ngày sinh :");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 293, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel13.setText("Tình trạng :");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 242, -1, -1));

        txtMaSinhVien.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtMaSinhVien.setName("Mã Sinh Viên"); // NOI18N
        add(txtMaSinhVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 105, 174, -1));

        txtTenSinhVien.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtTenSinhVien.setName("Tên sinh viên"); // NOI18N
        add(txtTenSinhVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 150, 200, -1));

        txtSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtSoDienThoai.setName("Số Điện Thoại"); // NOI18N
        add(txtSoDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 195, 200, -1));

        txtCMND.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtCMND.setName("CMND/CCCD"); // NOI18N
        add(txtCMND, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 240, 200, -1));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtEmail.setName("Email"); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 291, 200, -1));

        txtTimKiem.setBorder(null);
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });
        add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 402, 340, 30));

        cbbNghanhHoc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cbbNghanhHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cbbNghanhHoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 105, 200, -1));

        txtNgayVao.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNgayVao.setName("Ngày Nhập Học"); // NOI18N
        add(txtNgayVao, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 150, 200, 27));

        txtNgayVao1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNgayVao1.setName("Ngày Sinh"); // NOI18N
        add(txtNgayVao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 292, 200, 26));

        txtNgayVao2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNgayVao2.setName("Ngày Tốt Nghiệp"); // NOI18N
        add(txtNgayVao2, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 195, 200, 26));

        bttNam.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(bttNam);
        bttNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bttNam.setSelected(true);
        bttNam.setText("Nam");
        bttNam.setName("Giới Tính"); // NOI18N
        add(bttNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 336, -1, -1));

        bttNu.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(bttNu);
        bttNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bttNu.setText("Nữ");
        bttNu.setName("Giới Tính"); // NOI18N
        bttNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttNuActionPerformed(evt);
            }
        });
        add(bttNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 336, -1, -1));

        bttDangHoc.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(bttDangHoc);
        bttDangHoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bttDangHoc.setSelected(true);
        bttDangHoc.setText("Đang học");
        bttDangHoc.setName("Tình Trạng Học"); // NOI18N
        add(bttDangHoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 240, -1, -1));

        bttBaoLuu.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(bttBaoLuu);
        bttBaoLuu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bttBaoLuu.setText("Bảo lưu");
        bttBaoLuu.setName("Tình Trạng Học"); // NOI18N
        add(bttBaoLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 240, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel14.setText("Ảnh đại diện");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(824, 105, -1, -1));

        btnNew.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNew.setForeground(new java.awt.Color(255, 255, 255));
        btnNew.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/nutTuGiacTB.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNewMouseExited(evt);
            }
        });
        add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 390, 120, -1));

        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/nutTuGiacTB.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveMouseExited(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 390, 120, -1));

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/nutTuGiacTB.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateMouseExited(evt);
            }
        });
        add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 390, 120, -1));

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/nutTuGiacTB.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteMouseExited(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 390, 120, -1));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/barSearch.png"))); // NOI18N
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 395, 469, -1));

        tblSinhVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sinh viên", "Tên sinh viên", "Số điện thoại", "CMND/CCCD", "Giới tính", "Nghành học", "Tình trạng"
            }
        ));
        tblSinhVien.setGridColor(new java.awt.Color(255, 255, 255));
        tblSinhVien.setRowHeight(20);
        tblSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSinhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSinhVien);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 447, 1020, 327));

        lblHinh.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblHinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMouseClicked(evt);
            }
        });
        add(lblHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(824, 150, 149, 134));

        btnXoaAnh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnXoaAnh.setText("Xóa ảnh");
        btnXoaAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaAnhMouseClicked(evt);
            }
        });
        btnXoaAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaAnhActionPerformed(evt);
            }
        });
        add(btnXoaAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(824, 293, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setText("SV");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 109, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    public void setColor(JLabel p) {
        p.setForeground(new Color(255, 250, 101));
    }

    public void resetColor(JLabel p1) {
        p1.setForeground(new Color(255, 255, 255));
    }
    public static boolean CheckDate(JDateChooser txt, JDateChooser txt1) {
        txt.setBackground(white);
        if (txt.getDate().before(txt1.getDate())){
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(),txt.getName()+" Không Được Lớn Hơn"+txt1.getName());
            return false;
        }
    }
    public static boolean CheckTrung(JTextField txt, JTable tbl ){
        int tong = tbl.getRowCount();
        txt.setBackground(white);
        for(int i=0;i<tong;i++){
            if(txt.getText().equalsIgnoreCase(tbl.getValueAt(i, 0).toString())){
                txt.setBackground(pink);
                MsgBox.alert(txt.getRootPane(),txt.getName()+" Đã Tồn Tại");
                return false;
            } else {
            }
        }
        return true;  
   }
    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed

    }//GEN-LAST:event_txtEmailActionPerformed

    private void bttNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttNuActionPerformed

    }//GEN-LAST:event_bttNuActionPerformed

    private void btnNewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewMouseEntered
        setColor(btnNew);
    }//GEN-LAST:event_btnNewMouseEntered

    private void btnNewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewMouseExited
        resetColor(btnNew);
    }//GEN-LAST:event_btnNewMouseExited

    private void btnSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseEntered
        setColor(btnSave);
    }//GEN-LAST:event_btnSaveMouseEntered

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        resetColor(btnSave);
    }//GEN-LAST:event_btnSaveMouseExited

    private void btnUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseEntered
        setColor(btnUpdate);
    }//GEN-LAST:event_btnUpdateMouseEntered

    private void btnUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseExited
        resetColor(btnUpdate);
    }//GEN-LAST:event_btnUpdateMouseExited

    private void btnDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseEntered
        setColor(btnDelete);
    }//GEN-LAST:event_btnDeleteMouseEntered

    private void btnDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseExited
        resetColor(btnDelete);
    }//GEN-LAST:event_btnDeleteMouseExited

    private void tblSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSinhVienMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            this.index = tblSinhVien.rowAtPoint(evt.getPoint());//lấy vị trí dòng được chọn
            if (this.index >= 0) {
                this.edit();
            }
        }
    }//GEN-LAST:event_tblSinhVienMouseClicked

    private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
        // TODO add your handling code here:
        this.selectImage();
    }//GEN-LAST:event_lblHinhMouseClicked

    private void btnNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewMouseClicked
        // TODO add your handling code here:
        setTrang();
        this.setModel(new SinhVien()); 
    }//GEN-LAST:event_btnNewMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        // TODO add your handling code here:'
        if(utilityHelper.checkNullText(txtMaSinhVien) && utilityHelper.checkNullText(txtTenSinhVien) && utilityHelper.checkNullText(txtSoDienThoai)
        && utilityHelper.checkNullText(txtEmail) && utilityHelper.checkNullText(txtCMND)){
            if(utilityHelper.CheckNullDate(txtNgayVao) && utilityHelper.CheckNullDate(txtNgayVao1) && utilityHelper.CheckNullDate(txtNgayVao2)){
                if(utilityHelper.checkEmail(txtEmail) && utilityHelper.checkName(txtTenSinhVien) && utilityHelper.checkSDT(txtSoDienThoai) && utilityHelper.checkCMND(txtCMND)){
                    if(utilityHelper.CheckDate(txtNgayVao, txtNgayVao2)){
                        if(utilityHelper.CheckTrung(txtMaSinhVien, tblSinhVien)){
                            insert();
                            insertDiem();
                            load();
                        }
                    }
                }
            }     
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        // TODO add your handling code here:
        if(utilityHelper.checkNullText(txtMaSinhVien) && utilityHelper.checkNullText(txtTenSinhVien) && utilityHelper.checkNullText(txtSoDienThoai)
        && utilityHelper.checkNullText(txtEmail) && utilityHelper.checkNullText(txtCMND)){
            if(utilityHelper.CheckNullDate(txtNgayVao) && utilityHelper.CheckNullDate(txtNgayVao1) && utilityHelper.CheckNullDate(txtNgayVao2)){
                if(utilityHelper.checkEmail(txtEmail) && utilityHelper.checkName(txtTenSinhVien) && utilityHelper.checkSDT(txtSoDienThoai) && utilityHelper.checkCMND(txtCMND)){
                    if(utilityHelper.CheckDate(txtNgayVao, txtNgayVao2)){                       
                        update();
                        load();
                    }
                }
            }     
        } 
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // TODO add your handling code here:
        if(utilityHelper.checkNullText(txtMaSinhVien) && utilityHelper.checkNullText(txtTenSinhVien) && utilityHelper.checkNullText(txtSoDienThoai)
        && utilityHelper.checkNullText(txtEmail) && utilityHelper.checkNullText(txtCMND)){
            delete();
            load();
            setTrang();
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnXoaAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaAnhMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaAnhMouseClicked

    private void btnXoaAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaAnhActionPerformed
        // TODO add your handling code here:
        lblHinh.setToolTipText(null);
        lblHinh.setIcon(null);
    }//GEN-LAST:event_btnXoaAnhActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tblSinhVien.getModel();
        try {
            TableRowSorter<DefaultTableModel> ts = new TableRowSorter<>(model);
            tblSinhVien.setRowSorter(ts);
            ts.setRowFilter(RowFilter.regexFilter(txtTimKiem.getText()));
//            tblGridView.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        XemLichSuTruyCapFrame  xem=new XemLichSuTruyCapFrame();
        xem.setVisible(true); 
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDelete;
    private javax.swing.JLabel btnNew;
    private javax.swing.JLabel btnSave;
    private javax.swing.JLabel btnUpdate;
    private javax.swing.JButton btnXoaAnh;
    private javax.swing.JRadioButton bttBaoLuu;
    private javax.swing.JRadioButton bttDangHoc;
    private javax.swing.JRadioButton bttNam;
    private javax.swing.JRadioButton bttNu;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbNghanhHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JTable tblSinhVien;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaSinhVien;
    private com.toedter.calendar.JDateChooser txtNgayVao;
    private com.toedter.calendar.JDateChooser txtNgayVao1;
    private com.toedter.calendar.JDateChooser txtNgayVao2;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenSinhVien;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

}
