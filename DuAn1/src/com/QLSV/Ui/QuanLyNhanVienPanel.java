/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.Ui;

import com.QLSV.DAO.NhanVienDAO;
import com.QLSV.Model.NhanVien;
import com.QLSV.Utility.Auth;
import com.QLSV.Utility.MsgBox;
import com.QLSV.Utility.Other;
import static com.mindfusion.charting.TextRenderer.collectModeData.init;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Tho
 */
public class QuanLyNhanVienPanel extends javax.swing.JPanel {

  

    /**
     * Creates new form QuanLyNhanVienPanel
     */
    public QuanLyNhanVienPanel() {
        initComponents();
        Other.setTable(tblNhanVien);
        init();
        cboVaiTroActionPerformed(null);
       
    }

    

    

    void init() {
        this.fillTable();
        this.row = -1;
        tblNhanVien.getTableHeader().setBackground(Color.BLACK);
    }
    DefaultTableModel model;
    NhanVienDAO nvdao = new NhanVienDAO();
    int row = -1;

    void fillTable() {
        model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        try {
            List<NhanVien> list = null;
            list = nvdao.selectAll();
            for (NhanVien nv : list) {
                String mk="";
                for (int i = 0; i < nv.getMatKhau().length(); i++) {
                    mk+="*";
                }
                Object[] row = {nv.getMaNV(), nv.getTenNhanVien(), nv.getGmail(), nv.isVaitro()==true?"Quản Lý":"Nhân Viên",mk};
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    void setForm(NhanVien nv) {
        txtMaNhanVien.setText(nv.getMaNV().substring(2,nv.getMaNV().length()));
        txtTenNhanVien.setText(nv.getTenNhanVien());
        txtEmail.setText(nv.getGmail());
        txtMatKhau.setText((String) tblNhanVien.getValueAt(tblNhanVien.getSelectedRow(), 4));
        cboVaiTro.setSelectedItem(nv.isVaitro()==true?"Quản Lý":"Nhân Viên");
    }

    void clearForm() {
        txtEmail.setText("");
        txtMatKhau.setText("");
        txtTenNhanVien.setText("");
        txtMaNhanVien.setText("");
        this.row = -1;
        cboVaiTro.setSelectedItem(0);
        tblNhanVien.clearSelection();
    }

    void edit() {
        try {
            String maNV = tblNhanVien.getValueAt(this.row, 0).toString();
            NhanVien nv = nvdao.selectByID(maNV);
            this.setForm(nv);
        } catch (Exception e) {

        }
    }

    NhanVien getForm() {
        NhanVien nv = new NhanVien();
        nv.setMaNV(lblGV1.getText()+txtMaNhanVien.getText());
        nv.setTenNhanVien(txtTenNhanVien.getText());
        nv.setGmail(txtEmail.getText());
        nv.setVaitro(( cboVaiTro.getSelectedItem().toString().equals("Quản Lý")?true:false));
        nv.setMatKhau(txtMatKhau.getText());
        return nv;
    }

    void insert() {
        if (fixForm() == false) {
            return;
        }
        NhanVien nv = getForm();
        try {
            nvdao.insert(nv);
            this.fillTable();
            this.clearForm();
            JOptionPane.showMessageDialog(this, "Thêm mới thành công !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thêm mới thất bại !");
            e.printStackTrace();
        }
    }

    void update() {
        if (fixFormUpdate() == false) {
            return;
        }
        NhanVien nv = getForm();
        try {
            nvdao.update(nv);
            this.fillTable();
            this.clearForm();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
            e.printStackTrace();
        }
    }

    void delete() {
        if (!Auth.isManager()) {
            JOptionPane.showMessageDialog(this, "Bạn không có quyền thực hiện chức năng này");
        } else {
            String manv = lblGV1.getText()+txtMaNhanVien.getText();
            if (MsgBox.confirm(this, "Bạn có thực sữ muốn xóa nhân viên này này!")) {
                try {
                    nvdao.delete(manv);
                    this.fillTable();
                    this.clearForm();
                    JOptionPane.showMessageDialog(this, "Xóa thành công!");
                } catch (Exception e) {
                    JOptionPane.showConfirmDialog(this, "Xóa thất bại!");
                    e.printStackTrace();
                }
            }
        }
    }

    void first() {
        this.row = 0;
        this.edit();
    }

    void next() {
        if (this.row < tblNhanVien.getRowCount() - 1) {
            this.row++;
            this.edit();
        }
    }

    void prev() {
        if (this.row > 0) {
            this.row--;
            this.edit();
        }
    }

    void last() {
        this.row = tblNhanVien.getRowCount() - 1;
        this.edit();
    }

    boolean fixForm() {
        int x = tblNhanVien.getRowCount();
        if (txtMaNhanVien.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống mã nhân viên !");
            return false;
        }
        if (txtTenNhanVien.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống Tên nhân viên !");
            return false;
        }
        if (txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống mã nhân viên !");
            return false;
        }
        if (txtMatKhau.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống mã nhân viên !");
            return false;
        }
        String checkmail = "\\w+@\\w+(\\.\\w+){1,2}";
        try {
            if (!txtEmail.getText().matches(checkmail)) {
                MsgBox.alert(this, "Không nhập đúng định dạng email (abc@xyz .123)!");
                return false;
            }
        } catch (Exception e) {
        }
        for (int i = 0; i < x; i++) {
            if (txtMaNhanVien.getText().equalsIgnoreCase(tblNhanVien.getValueAt(i, 0).toString())) {
                JOptionPane.showMessageDialog(this, "Mã Nhân viên đã tồn tại!");
                return false;
            }
            if (txtTenNhanVien.getText().equalsIgnoreCase(tblNhanVien.getValueAt(i, 2).toString())) {
                JOptionPane.showMessageDialog(this, "Tên Nhân Viên đã tồn tại!");
                return false;
            }
            if (txtEmail.getText().equalsIgnoreCase(tblNhanVien.getValueAt(i, 3).toString())) {
                JOptionPane.showMessageDialog(this, "Email đã tồn tại!");
                return false;
            }
        }
        return true;
    }

    boolean fixFormUpdate() {
        int x = tblNhanVien.getRowCount();
        if (txtMaNhanVien.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống mã nhân viên !");
            return false;
        }
        if (txtTenNhanVien.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống Tên nhân viên !");
            return false;
        }
        if (txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống Email !");
            return false;
        }
        if (txtMatKhau.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được bỏ trống mật khẩu !");
            return false;
        }
        String checkmail = "\\w+@\\w+(\\.\\w+){1,2}";
        try {
            if (!txtEmail.getText().matches(checkmail)) {
                MsgBox.alert(this, "Không nhập đúng định dạng email (abc@xyz .123)!");
                return false;
            }
        } catch (Exception e) {
        }
        int checktrung = -1;
        for (int i = 0; i < x; i++) {
            if (txtMaNhanVien.getText().equalsIgnoreCase(tblNhanVien.getValueAt(i, 0).toString())) {
                checktrung = i;
                break;
            }
            if ((i == x - 1) && (!txtMaNhanVien.getText().equalsIgnoreCase(tblNhanVien.getValueAt(i, 0).toString()))) {
                MsgBox.alert(this, "Mã giảng viên không tồn tại!");
                return false;
            }
        }
        for (int i = 0; i < x; i++) {
            if (txtMaNhanVien.getText().equalsIgnoreCase(tblNhanVien.getValueAt(i, 0).toString())) {
                JOptionPane.showMessageDialog(this, "Mã Nhân viên đã tồn tại!");
                return false;
            }
            if (txtTenNhanVien.getText().equalsIgnoreCase(tblNhanVien.getValueAt(i, 2).toString())) {
                JOptionPane.showMessageDialog(this, "Tên Nhân Viên đã tồn tại!");
                return false;
            }
            if (txtEmail.getText().equalsIgnoreCase(tblNhanVien.getValueAt(i, 3).toString())) {
                JOptionPane.showMessageDialog(this, "Email đã tồn tại!");
                return false;
            }
        }
        return true;
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
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        txtTenNhanVien = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        cboVaiTro = new javax.swing.JComboBox<>();
        txtMatKhau = new javax.swing.JTextField();
        btnSave = new javax.swing.JLabel();
        btnNew = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        lblGV1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnKichHoat = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1180, 780));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 31, 151));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 38, 1180, -1));

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTimKiem.setBorder(null);
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });
        add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 350, 310, 20));

        tblNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Email", "Vai trò", "Mật khẩu"
            }
        ));
        tblNhanVien.setGridColor(new java.awt.Color(255, 255, 255));
        tblNhanVien.setRowHeight(20);
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 1030, 327));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Mã nhân viên :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Tên nhân viên :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Email :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Mật khẩu :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Vai trò :");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, -1, -1));

        txtMaNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        add(txtMaNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 260, -1));

        txtTenNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        add(txtTenNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 290, -1));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 290, -1));

        cboVaiTro.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cboVaiTro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản Lý", "Nhân Viên" }));
        cboVaiTro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboVaiTroActionPerformed(evt);
            }
        });
        add(cboVaiTro, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, 270, -1));

        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 190, 270, -1));

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
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 120, -1));

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
        add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 120, -1));

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
        add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 120, -1));

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
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 120, -1));

        lblGV1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblGV1.setText("NV");
        add(lblGV1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, 30));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/barSearch.png"))); // NOI18N
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 340, 465, -1));

        btnKichHoat.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnKichHoat.setText("Kích hoạt nhận diện khuôn mặt");
        btnKichHoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKichHoatActionPerformed(evt);
            }
        });
        add(btnKichHoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        row = tblNhanVien.getSelectedRow();
        edit();
    }//GEN-LAST:event_tblNhanVienMouseClicked
    public void setColor(JLabel p) {
        p.setForeground(new Color(255, 250, 101));
    }

    public void resetColor(JLabel p1) {
        p1.setForeground(new Color(255, 255, 255));
    }


    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        insert();
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseEntered
        setColor(btnSave);
    }//GEN-LAST:event_btnSaveMouseEntered

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
        resetColor(btnSave);
    }//GEN-LAST:event_btnSaveMouseExited

    private void btnNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewMouseClicked
        clearForm();
    }//GEN-LAST:event_btnNewMouseClicked

    private void btnNewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewMouseEntered
        setColor(btnNew);
    }//GEN-LAST:event_btnNewMouseEntered

    private void btnNewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewMouseExited
        resetColor(btnNew);
    }//GEN-LAST:event_btnNewMouseExited

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        update();
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseEntered
        setColor(btnUpdate);
    }//GEN-LAST:event_btnUpdateMouseEntered

    private void btnUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseExited
        resetColor(btnUpdate);
    }//GEN-LAST:event_btnUpdateMouseExited

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        delete();
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseEntered
        setColor(btnDelete);
    }//GEN-LAST:event_btnDeleteMouseEntered

    private void btnDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseExited
        resetColor(btnDelete);
    }//GEN-LAST:event_btnDeleteMouseExited

    private void cboVaiTroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboVaiTroActionPerformed
        if(cboVaiTro.getSelectedItem().toString().equals("Quản Lý")){
            lblGV1.setText("QL");
        }else{
            lblGV1.setText("NV");
        }
    }//GEN-LAST:event_cboVaiTroActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        DefaultTableModel model = (DefaultTableModel)tblNhanVien.getModel();
        try {
            TableRowSorter<DefaultTableModel> ts = new TableRowSorter<>(model);
            tblNhanVien.setRowSorter(ts);
            ts.setRowFilter(RowFilter.regexFilter(txtTimKiem.getText()));
//            tblGridView.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnKichHoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKichHoatActionPerformed
        DangKyFaceIDFrame dk =new DangKyFaceIDFrame(Auth.USER);
        dk.setVisible(true); 

        // TODO add your handling code here:;
    }//GEN-LAST:event_btnKichHoatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDelete;
    private javax.swing.JButton btnKichHoat;
    private javax.swing.JLabel btnNew;
    private javax.swing.JLabel btnSave;
    private javax.swing.JLabel btnUpdate;
    private javax.swing.JComboBox<String> cboVaiTro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGV1;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtTenNhanVien;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
