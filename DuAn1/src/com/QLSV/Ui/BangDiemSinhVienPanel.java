/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.QLSV.Ui;

import com.QLSV.DAO.DiemDAO;
import com.QLSV.DAO.NganhDAO;
import com.QLSV.DAO.SinhVienDAO;
import com.QLSV.Model.Diem;
import com.QLSV.Model.Nganh;
import com.QLSV.Model.SinhVien;
import com.QLSV.Utility.Auth;
import com.QLSV.Utility.MsgBox;
import com.QLSV.Utility.Other;
import com.QLSV.Utility.XImage;
import java.awt.Color;
import static java.awt.Color.white;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.QLSV.Utility.NhacNen;
import com.QLSV.Utility.utilityHelper;
import java.io.FileOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author tontr
 */
public class BangDiemSinhVienPanel extends javax.swing.JPanel {

    /**
     * Creates new form BangDiemSinhVienPanel
     */
    public BangDiemSinhVienPanel() {
        initComponents();
        Other.setTable(tblBangDiem);
        load();
        txtNgayVao.setDateFormatString("dd-MM-yyyy");
        txtNgayVao1.setDateFormatString("dd-MM-yyyy");
        txtNgayVao2.setDateFormatString("dd-MM-yyyy");
        fillComboBox();
        setStatus(true);edit();
    }
    XSSFWorkbook workbook;
    JFileChooser fileChooser = new JFileChooser();
    int index= 0;
    DiemDAO ddao= new DiemDAO();
    NganhDAO ngdao = new NganhDAO();
    SinhVienDAO svdao = new SinhVienDAO();
    void load() {
        DefaultTableModel model = (DefaultTableModel) tblBangDiem.getModel();
        model.setRowCount(0);   //đưa số dòng về 0 (xóa bảng)
        try {
            List<Diem> list = ddao.selectByID0(Auth.USERSV.getMaSinhVien());
            for (Diem sv : list) {
                Object[] row = {
                    sv.getMaSinhVien(),
                    sv.getMaMon(),
                    sv.getDiemChuyenCan(),
                    sv.getDiemGiuaKi(),
                    sv.getDiemCuoiKi(),
                    sv.getDiemChuyenCan()+sv.getDiemGiuaKi()+sv.getDiemCuoiKi(),
                    sv.getTrangThai().contains("(") ? sv.getTrangThai().substring(0,sv.getTrangThai().length()-3): sv.getTrangThai()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    void fillComboBox() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbNghanhHoc.getModel(); 
        model.removeAllElements();   
        try {
            List<Nganh> list = ngdao.selectAll();
            for (Nganh cd : list) {
                model.addElement(cd.getTenNganh());
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void updatemk() {
        SinhVien model = getModel();
        try {
            svdao.updateMK(model);   
            this.load();         
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
            e.printStackTrace();
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
    }


    void edit() {
        setTrang();
        try {
//            String manh = (String) tblBangDiem.getValueAt(this.index, 0);
            SinhVien model = svdao.selectByID(Auth.USERSV.getMaSinhVien());  
            if (model != null) {
                this.setModel(model);  
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    void setModel(SinhVien model) {
        txtMaSinhVien.setText(model.getMaSinhVien());
        txtTenSinhVien.setText(model.getTenSinhVien());
        txtSoDienThoai.setText(model.getSoDienThoai());
        txtCMND.setText(model.getCmnd());
        txtEmail.setText(model.getEmail());
        bttNam.setSelected(!model.isGioiTinh());
        bttNu.setSelected(model.isGioiTinh());
        txtNgayVao.setDate(model.getNgayNhapHoc());
        txtNgayVao1.setDate(model.getNgaySinh());
        txtNgayVao2.setDate(model.getNgayTotNgiep());
        bttBaoLuu.setSelected(model.isTinhTrang());
        bttDangHoc.setSelected(!model.isTinhTrang());
        lblHinh.setToolTipText(model.getAnhDaiDien());
        lblHinh.setIcon(XImage.readLogo(model.getAnhDaiDien()));
        cbbNghanhHoc.setSelectedItem(model.getTenNganh());
        txtMK.setText(model.getMatKhau());
//        cbbNghanhHoc.setToolTipText(model.getTenNganh());
//        cbbNghanhHoc.getModel().setSelectedItem(model.getTenNganh());
    }

    SinhVien getModel() {
        SinhVien model = new SinhVien();
        model.setMaSinhVien(txtMaSinhVien.getText());
        model.setTenSinhVien(txtTenSinhVien.getText());
        model.setGioiTinh(bttNam.isSelected());
        model.setTinhTrang(bttDangHoc.isSelected());
        model.setSoDienThoai(txtSoDienThoai.getText());
        model.setCmnd(txtCMND.getText());
        model.setNgayNhapHoc( new java.sql.Date(txtNgayVao.getDate().getTime()));
        model.setNgaySinh(new java.sql.Date(txtNgayVao1.getDate().getTime()));
        model.setNgayTotNgiep(new java.sql.Date(txtNgayVao2.getDate().getTime()));
        model.setEmail(txtEmail.getText());  
        model.setMatKhau(txtMK.getText());
        model.setAnhDaiDien(lblHinh.getToolTipText());
        Object a = (Object) cbbNghanhHoc.getSelectedItem();
        String b = String.valueOf(a);
        model.setTenNganh(b);
        
//        model.setTenNganh(String.valueOf(cbbNghanhHoc.getToolTipText()));
        return model;
    }
    void setStatus(boolean insertable) {
        txtMaSinhVien.setEditable(!insertable);
        txtCMND.setEditable(!insertable);
        txtEmail.setEditable(!insertable);
        txtSoDienThoai.setEditable(!insertable);
        txtTenSinhVien.setEditable(!insertable);
        bttNu.setEnabled(!insertable);
        bttNam.setEnabled(!insertable);
        bttDangHoc.setEnabled(!insertable);
        bttBaoLuu.setEnabled(!insertable);
        txtNgayVao.setEnabled(!insertable);
        txtNgayVao1.setEnabled(!insertable);
        txtNgayVao2.setEnabled(!insertable);
        cbbNghanhHoc.setEnabled(!insertable);
    }
    void setStatus0(boolean insertable) {
        txtMaSinhVien.setEditable(!insertable);
        txtEmail.setEditable(!insertable);
        bttDangHoc.setEnabled(!insertable);
        bttBaoLuu.setEnabled(!insertable);
        txtNgayVao.setEnabled(!insertable);
        txtNgayVao2.setEnabled(!insertable);
        cbbNghanhHoc.setEnabled(!insertable);
    }
    
    public void mail(){
        
        String mail= txtEmail.getText();
            try {
            Properties p = new Properties();
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.port", 587);
            String accountName = mail;
            String accountPassword;
            accountPassword = JOptionPane.showInputDialog("Nhập mật khẩu Email");
            if(accountPassword==null){
                MsgBox.alert(this, "Vui Lòng Nhập Password Email Của Bạn");
            }
            String gioitinh ="";
            if(bttNam.isSelected()){
                gioitinh="Nam";
            }else{
                gioitinh="Nữ";
            }
                System.out.println(accountPassword);
            Session s = Session.getInstance(p,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(accountName, accountPassword);
                    }});
                    String from = mail;
                    String to = "hieupmps18605@fpt.edu.vn";
                    String subject = "Yêu Cầu Thay Đổi Thông Tin Của Sinh Viên"+txtMaSinhVien.getText()+" Mã Sinh Viên"+txtMaSinhVien.getText();
                    
                    String body = "Thông Tin Thay Đổi \n"+"Tên Sinh Viên: "+txtTenSinhVien.getText()+"\n"+"Số Điện Thoai: "+txtSoDienThoai.getText()+"\n"+ "CMND/CCCD "+txtCMND.getText()+"\n"
                            +"Giới Tính: "+gioitinh+"\n"+"Ngày Sinh :"+txtNgayVao1.getDate()+"\n";
                    Message msg = new MimeMessage(s);
                    msg.setFrom(new InternetAddress(from));
                    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                    msg.setSubject(subject);
                    msg.setText(body);
                    Transport.send(msg);
                    JOptionPane.showMessageDialog(null, "Mail was sent successfully.", "Message",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);
                } catch (MessagingException ex) {
                    Logger.getLogger(BangDiemSinhVienPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    private CellStyle headerCellStyle() {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
        cellStyle.setBorderBottom(BorderStyle.THICK);
        cellStyle.setBorderLeft(BorderStyle.THICK);
        cellStyle.setBorderRight(BorderStyle.THICK);
        cellStyle.setBorderTop(BorderStyle.THICK);

        org.apache.poi.ss.usermodel.Font font = workbook.createFont();
        font.setBold(true);
        font.setFontName("Times New Roman");
        font.setFontHeight((short) 350);
        cellStyle.setFont(font);
        return cellStyle;
    }

    private CellStyle coCellStyle() {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THICK);
        cellStyle.setBorderRight(BorderStyle.THICK);
        cellStyle.setBorderTop(BorderStyle.THIN);

        org.apache.poi.ss.usermodel.Font font = workbook.createFont();
        font.setFontName("Times New Roman");
        font.setFontHeight((short) 250);
        cellStyle.setFont(font);
        return cellStyle;
    }
    void excel(){
        fileChooser.setDialogTitle ("Save as");
        FileNameExtensionFilter f = new FileNameExtensionFilter("xls", "xlsx");
        FileOutputStream out = null;

        fileChooser.setFileFilter (f);
        int excel = fileChooser.showSaveDialog(null);
        if (excel == JFileChooser.APPROVE_OPTION) {
            try {
                workbook = new XSSFWorkbook();
                XSSFSheet spreadsheet1 = workbook.createSheet("Điểm sinh viên");
                XSSFRow rows1 = null;
                Cell cells1 = null;
                CellStyle cs = headerCellStyle();
                CellStyle csc = coCellStyle();
                rows1 = spreadsheet1.createRow((short) 1);
                rows1.setHeight((short) 500);
                cells1 = rows1.createCell(0, CellType.STRING);
                cells1.setCellValue("Điểm sinh viên");
                rows1 = spreadsheet1.createRow((short) 2);
                rows1.setHeight((short) 500);
                cells1 = rows1.createCell(0, CellType.STRING);
                cells1.setCellValue("Mã sinh viên");
                cells1.setCellStyle(cs);
                cells1 = rows1.createCell(1, CellType.STRING);
                cells1.setCellValue("Tên sinh viên");
                cells1.setCellStyle(cs);
                cells1 = rows1.createCell(2, CellType.STRING);
                cells1.setCellValue("Điểm chuyên cần");
                cells1.setCellStyle(cs);
                cells1 = rows1.createCell(3, CellType.STRING);
                cells1.setCellValue("Điểm giữa kỳ");
                cells1.setCellStyle(cs);
                cells1 = rows1.createCell(4, CellType.STRING);
                cells1.setCellValue("Điểm cuối kỳ");
                cells1.setCellStyle(cs);
                cells1 = rows1.createCell(5, CellType.STRING);
                cells1.setCellValue("Điểm trung bình");
                cells1.setCellStyle(cs);
                cells1 = rows1.createCell(6, CellType.STRING);
                cells1.setCellValue("Trạng thái");
                cells1.setCellStyle(cs);
                int rowtong = tblBangDiem.getRowCount();
                int tongrow = tblBangDiem.getRowCount();
                for (int i = 0; i < tongrow; i++) {
                    rows1 = spreadsheet1.createRow((short) 3 + i);
                    rows1.setHeight((short) 500);
                    cells1 = rows1.createCell(0,CellType.STRING);
                    cells1.setCellValue(tblBangDiem.getValueAt(i, 0).toString());
                    cells1.setCellStyle(csc);
                    cells1 = rows1.createCell(1,CellType.STRING);
                    cells1.setCellValue(tblBangDiem.getValueAt(i, 1).toString());
                    cells1.setCellStyle(csc);
                    cells1 = rows1.createCell(2,CellType.STRING);
                    cells1.setCellValue(tblBangDiem.getValueAt(i, 2).toString());
                    cells1.setCellStyle(csc);
                    cells1 = rows1.createCell(3,CellType.STRING);
                    cells1.setCellValue(tblBangDiem.getValueAt(i, 3).toString());
                    cells1.setCellStyle(csc);
                    cells1 = rows1.createCell(4,CellType.STRING);
                    cells1.setCellValue(tblBangDiem.getValueAt(i, 4).toString());
                    cells1.setCellStyle(csc);
                    cells1 = rows1.createCell(5,CellType.STRING);
                    cells1.setCellValue(tblBangDiem.getValueAt(i, 5).toString());
                    cells1.setCellStyle(csc);
                    cells1 = rows1.createCell(6,CellType.STRING);
                    cells1.setCellValue(tblBangDiem.getValueAt(i, 6).toString());
                    cells1.setCellStyle(csc);
                }
                for (int i = 0; i < 7; i++) {
                    spreadsheet1.autoSizeColumn(i);
                }
                out = new FileOutputStream(fileChooser.getSelectedFile() + ".xlsx");
                workbook.write(out);
                out.close();
                JOptionPane.showMessageDialog(this, "Xuất file thành công");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        else {
//            JOptionPane.showMessageDialog(this, "Vui lòng chọn ổ đĩa");
//        }
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBangDiem = new javax.swing.JTable();
        txtNgayVao = new com.toedter.calendar.JDateChooser();
        txtNgayVao1 = new com.toedter.calendar.JDateChooser();
        txtNgayVao2 = new com.toedter.calendar.JDateChooser();
        bttNam = new javax.swing.JRadioButton();
        bttNu = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        bttDangHoc = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bttBaoLuu = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
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
        jLabel9 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        txtCMND = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        cbbNghanhHoc = new javax.swing.JComboBox<>();
        btnSuaThongTin = new javax.swing.JLabel();
        btnGuiMail = new javax.swing.JLabel();
        lblHinh = new javax.swing.JLabel();
        btnDoiMK = new javax.swing.JLabel();
        lblSound = new javax.swing.JLabel();
        txtMK = new javax.swing.JPasswordField();
        cboExcel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1180, 780));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 31, 151));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BẢNG ĐIỂM SINH VIÊN");

        tblBangDiem.setAutoCreateRowSorter(true);
        tblBangDiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblBangDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sinh Viên", "Mã môn", "Điểm chuyên cần", "Điểm giữa kỳ", "Điểm cuối kỳ", "Điểm trung bình", "Trạng thái"
            }
        ));
        tblBangDiem.setGridColor(new java.awt.Color(255, 255, 255));
        tblBangDiem.setRowHeight(20);
        tblBangDiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangDiemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBangDiem);

        txtNgayVao.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtNgayVao1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNgayVao1.setName("Ngày Sinh"); // NOI18N

        txtNgayVao2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        bttNam.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(bttNam);
        bttNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bttNam.setSelected(true);
        bttNam.setText("Nam");

        bttNu.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(bttNu);
        bttNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bttNu.setText("Nữ");
        bttNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttNuActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Mã sinh viên :");

        bttDangHoc.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(bttDangHoc);
        bttDangHoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bttDangHoc.setSelected(true);
        bttDangHoc.setText("Đang học");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Tên sinh viên :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Số điện thoại :");

        bttBaoLuu.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(bttBaoLuu);
        bttBaoLuu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bttBaoLuu.setText("Bảo lưu");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel14.setText("Ảnh đại diện");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("CMND/CCCD :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Email :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Giới tính :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Nghành học :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("Ngày nhập học :");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setText("Ngày tốt nghiệp :");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setText("Ngày sinh :");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel13.setText("Tình trạng :");

        txtMaSinhVien.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        txtTenSinhVien.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtTenSinhVien.setName("Tên Sinh Viên"); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setText("Mật Khẩu");

        txtSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtSoDienThoai.setName("Số Điện Thoại"); // NOI18N

        txtCMND.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtCMND.setName("CMND/CCCD"); // NOI18N

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        txtEmail.setName("Email"); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        cbbNghanhHoc.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cbbNghanhHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSuaThongTin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSuaThongTin.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaThongTin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSuaThongTin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/nutTuGiacDai.png"))); // NOI18N
        btnSuaThongTin.setText("Sửa thông tin");
        btnSuaThongTin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuaThongTin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSuaThongTin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaThongTinMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSuaThongTinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSuaThongTinMouseExited(evt);
            }
        });

        btnGuiMail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGuiMail.setForeground(new java.awt.Color(255, 255, 255));
        btnGuiMail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuiMail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/nutTuGiacDai.png"))); // NOI18N
        btnGuiMail.setText("Gửi Mail");
        btnGuiMail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuiMail.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuiMail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuiMailMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuiMailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuiMailMouseExited(evt);
            }
        });

        lblHinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnDoiMK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDoiMK.setForeground(new java.awt.Color(255, 255, 255));
        btnDoiMK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDoiMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/nutTuGiacDai.png"))); // NOI18N
        btnDoiMK.setText("Đổi Mật Khẩu");
        btnDoiMK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDoiMK.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDoiMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDoiMKMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDoiMKMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDoiMKMouseExited(evt);
            }
        });

        lblSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/sound_130px.png"))); // NOI18N
        lblSound.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSoundMouseClicked(evt);
            }
        });

        txtMK.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMK.setName("Mật Khẩu"); // NOI18N

        cboExcel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboExcel.setForeground(new java.awt.Color(255, 255, 255));
        cboExcel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cboExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/nutTuGiacTB.png"))); // NOI18N
        cboExcel.setText("Xuất Excel");
        cboExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboExcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cboExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboExcelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel7)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)))
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(bttNam)
                                                .addGap(18, 18, 18)
                                                .addComponent(bttNu))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtMaSinhVien)
                                                .addComponent(txtTenSinhVien)
                                                .addComponent(txtSoDienThoai)
                                                .addComponent(txtCMND)
                                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNgayVao, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(cbbNghanhHoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNgayVao2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bttDangHoc)
                                        .addGap(18, 18, 18)
                                        .addComponent(bttBaoLuu))
                                    .addComponent(txtNgayVao1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(txtMK))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(129, 129, 129)
                                    .addComponent(btnDoiMK)
                                    .addGap(82, 82, 82)
                                    .addComponent(btnSuaThongTin)
                                    .addGap(69, 69, 69)
                                    .addComponent(btnGuiMail)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblSound, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblSound)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbbNghanhHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtTenSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addComponent(txtNgayVao, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayVao2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(bttDangHoc)
                            .addComponent(bttBaoLuu))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNgayVao1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(bttNam)
                        .addComponent(bttNu)
                        .addComponent(jLabel9))
                    .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaThongTin)
                    .addComponent(btnGuiMail)
                    .addComponent(btnDoiMK)
                    .addComponent(cboExcel))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setColor(JLabel p) {
        p.setForeground(new Color(255, 250, 101));
    }

    public void resetColor(JLabel p1) {
        p1.setForeground(new Color(255, 255, 255));
    }
    private void bttNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttNuActionPerformed

    }//GEN-LAST:event_bttNuActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed

    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnSuaThongTinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaThongTinMouseEntered
        setColor(btnSuaThongTin);
    }//GEN-LAST:event_btnSuaThongTinMouseEntered

    private void btnSuaThongTinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaThongTinMouseExited
        resetColor(btnSuaThongTin);
    }//GEN-LAST:event_btnSuaThongTinMouseExited

    private void btnGuiMailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuiMailMouseEntered
        setColor(btnGuiMail);
    }//GEN-LAST:event_btnGuiMailMouseEntered

    private void btnGuiMailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuiMailMouseExited
        resetColor(btnGuiMail);
    }//GEN-LAST:event_btnGuiMailMouseExited

    private void tblBangDiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangDiemMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            this.index = tblBangDiem.rowAtPoint(evt.getPoint());//lấy vị trí dòng được chọn
            if (this.index >= 0) {
                this.edit();
            }
        }
    }//GEN-LAST:event_tblBangDiemMouseClicked

    private void btnSuaThongTinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaThongTinMouseClicked
        // TODO add your handling code here:
        setStatus(false);
        setStatus0(true);
        
    }//GEN-LAST:event_btnSuaThongTinMouseClicked

    private void btnDoiMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoiMKMouseClicked
        // TODO add your handling code here:
        if(utilityHelper.checkNullPass((JPasswordField) (txtMK))){
            updatemk();
            load();
        }
        
    }//GEN-LAST:event_btnDoiMKMouseClicked

    private void btnDoiMKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoiMKMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDoiMKMouseEntered

    private void btnDoiMKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoiMKMouseExited
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnDoiMKMouseExited

    private void btnGuiMailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuiMailMouseClicked
        // TODO add your handling code here:
        if(utilityHelper.checkNullText(txtMaSinhVien) && utilityHelper.checkNullText(txtTenSinhVien) && utilityHelper.checkNullText(txtSoDienThoai)
        && utilityHelper.checkNullText(txtEmail) && utilityHelper.checkNullText(txtCMND)){
            if(utilityHelper.CheckNullDate(txtNgayVao) && utilityHelper.CheckNullDate(txtNgayVao1) && utilityHelper.CheckNullDate(txtNgayVao2)){
                if(utilityHelper.checkEmail(txtEmail) && utilityHelper.checkName(txtTenSinhVien) && utilityHelper.checkSDT(txtSoDienThoai) && utilityHelper.checkCMND(txtCMND)){
                        mail();
                }
            }     
        }
    }//GEN-LAST:event_btnGuiMailMouseClicked

    private void lblSoundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSoundMouseClicked
        NhacNen.stop();
        if (NhacNen.nhac == 0) {
            lblSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/mute_50px.png")));
        } else {
            lblSound.setIcon(new ImageIcon(getClass().getResource("/com/QLSV/Icon/sound_130px.png")));
        }
    }//GEN-LAST:event_lblSoundMouseClicked

    private void cboExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboExcelMouseClicked
        // TODO add your handling code here:
        excel();
    }//GEN-LAST:event_cboExcelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDoiMK;
    private javax.swing.JLabel btnGuiMail;
    private javax.swing.JLabel btnSuaThongTin;
    private javax.swing.JRadioButton bttBaoLuu;
    private javax.swing.JRadioButton bttDangHoc;
    private javax.swing.JRadioButton bttNam;
    private javax.swing.JRadioButton bttNu;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbNghanhHoc;
    private javax.swing.JLabel cboExcel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JLabel lblSound;
    private javax.swing.JTable tblBangDiem;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtMK;
    private javax.swing.JTextField txtMaSinhVien;
    private com.toedter.calendar.JDateChooser txtNgayVao;
    private com.toedter.calendar.JDateChooser txtNgayVao1;
    private com.toedter.calendar.JDateChooser txtNgayVao2;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenSinhVien;
    // End of variables declaration//GEN-END:variables
}
