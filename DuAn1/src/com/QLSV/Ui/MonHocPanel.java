/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.Ui;

import com.QLSV.DAO.MonHocDAO;
import com.QLSV.Model.MonHoc;
import com.QLSV.Utility.Auth;
import com.QLSV.Utility.MsgBox;
import com.QLSV.Utility.Other;
import com.QLSV.Utility.XImage;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tho
 */
public class MonHocPanel extends javax.swing.JPanel {
    ArrayList<JPanel> list ;
    int trang;
    /**
     * Creates new form MonHocPanel
     */
    public MonHocPanel(ArrayList<JPanel> j , int i) {
        initComponents();
        Other.setTable(tblMonHoc);
        init();list=j;
        trang=i;
    }
    public void showPanel(int index){
        for (int i = 0; i < list.size(); i++) {
            list.get(i).show(false);
            if(i==index){
                list.get(index).show(true);
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

        jLabel4 = new javax.swing.JLabel();
        txtMaMon = new javax.swing.JTextField();
        txtTenMon = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMonHoc = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblAnhDaiDien = new javax.swing.JLabel();
        btnSave = new javax.swing.JLabel();
        btnNew = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        btnXoaAnh = new javax.swing.JButton();
        btnLichGiangDay = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1180, 780));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Mô tả :");

        txtMaMon.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        txtTenMon.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        txtMoTa.setColumns(20);
        txtMoTa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtMoTa.setRows(5);
        jScrollPane2.setViewportView(txtMoTa);

        tblMonHoc.setAutoCreateRowSorter(true);
        tblMonHoc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tblMonHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã môn", "Tên môn", "Mô tả", "Ảnh đại diện"
            }
        ));
        tblMonHoc.setGridColor(new java.awt.Color(255, 255, 255));
        tblMonHoc.setOpaque(false);
        tblMonHoc.setRowHeight(20);
        tblMonHoc.setSurrendersFocusOnKeystroke(true);
        tblMonHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMonHocMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblMonHoc);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 31, 151));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ MÔN HỌC");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Mã môn :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Tên môn :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Ảnh đại diện :");

        lblAnhDaiDien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        lblAnhDaiDien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhDaiDienMouseClicked(evt);
            }
        });

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

        btnXoaAnh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnXoaAnh.setText("Xóa ảnh");
        btnXoaAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaAnhActionPerformed(evt);
            }
        });

        btnLichGiangDay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLichGiangDay.setForeground(new java.awt.Color(255, 255, 255));
        btnLichGiangDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnLichGiangDay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/nutTuGiacDai.png"))); // NOI18N
        btnLichGiangDay.setText("Lịch giảng dạy");
        btnLichGiangDay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLichGiangDay.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLichGiangDay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLichGiangDayMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLichGiangDayMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLichGiangDayMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaMon, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(129, 129, 129)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(btnXoaAnh))
                                .addGap(30, 30, 30)
                                .addComponent(lblAnhDaiDien, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLichGiangDay))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(btnXoaAnh)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblAnhDaiDien, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDelete)
                        .addComponent(btnLichGiangDay))
                    .addComponent(btnUpdate)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSave)
                        .addComponent(btnNew)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewMouseClicked
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnNewMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void lblAnhDaiDienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhDaiDienMouseClicked
        // TODO add your handling code here:
        chonAnh();
    }//GEN-LAST:event_lblAnhDaiDienMouseClicked

    private void tblMonHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMonHocMouseClicked
        // TODO add your handling code here:
        row = tblMonHoc.getSelectedRow();
        edit();
    }//GEN-LAST:event_tblMonHocMouseClicked

    private void btnXoaAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaAnhActionPerformed
        // TODO add your handling code here:
        lblAnhDaiDien.setIcon(null);
        lblAnhDaiDien.setToolTipText(null);
    }//GEN-LAST:event_btnXoaAnhActionPerformed

    private void btnLichGiangDayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLichGiangDayMouseClicked
        showPanel(trang);        // TODO add your handling code here:
    }//GEN-LAST:event_btnLichGiangDayMouseClicked

    private void btnLichGiangDayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLichGiangDayMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLichGiangDayMouseEntered

    private void btnLichGiangDayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLichGiangDayMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLichGiangDayMouseExited

    public void setColor(JLabel p) {
        p.setForeground(new Color(255, 250, 101));
    }

    public void resetColor(JLabel p1) {
        p1.setForeground(new Color(255, 255, 255));
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDelete;
    private javax.swing.JLabel btnLichGiangDay;
    private javax.swing.JLabel btnNew;
    private javax.swing.JLabel btnSave;
    private javax.swing.JLabel btnUpdate;
    private javax.swing.JButton btnXoaAnh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAnhDaiDien;
    private javax.swing.JTable tblMonHoc;
    private javax.swing.JTextField txtMaMon;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtTenMon;
    // End of variables declaration//GEN-END:variables
    private void init() {
        filltable();
         
    }
    
    MonHocDAO dao = new MonHocDAO();
    int row = -1;
    DefaultTableModel model ;
    
    private void filltable(){
        model = (DefaultTableModel) tblMonHoc.getModel();
        model.setRowCount(0);
        try {
            List<MonHoc> list = null;
            list = dao.selectAll();
            for(MonHoc n : list){
                Object row[] = {n.getMaMon(),n.getTenMon(),n.getMoTa() ,n.getAnhDaiDien()};
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    
    void setForm(MonHoc n){
        txtMaMon.setText(n.getMaMon());
        txtTenMon.setText(n.getTenMon());
        txtMoTa.setText(n.getMoTa());
        try {
            if(!n.getAnhDaiDien().equals("")||n.getAnhDaiDien()!=null){
                    lblAnhDaiDien.setToolTipText(n.getAnhDaiDien());
                    lblAnhDaiDien.setIcon(XImage.readLogo(n.getAnhDaiDien()));

            }else{
                lblAnhDaiDien.setIcon(null);
            }
            if(n.getAnhDaiDien()==null){
                lblAnhDaiDien.setIcon(null);
            }
        } catch (Exception e) {
        }
        if(n.getAnhDaiDien()==null){
                lblAnhDaiDien.setIcon(null);
        }
    }
    
    MonHoc getForm(){
        MonHoc n = new MonHoc();
        n.setMaMon(txtMaMon.getText());
        n.setTenMon(txtTenMon.getText());
        n.setMoTa(txtMoTa.getText());
        n.setAnhDaiDien(getToolTipText());
        return n;
    }
    
    void edit(){
        String manganh = tblMonHoc.getValueAt(row, 0).toString();
        MonHoc n = dao.selectByID(manganh);
        setForm(n);
    }
    
    void insert(){
        if(!fixform()){
            return;
        }
        MonHoc n = getForm();
        try {
            dao.insert(n);
            filltable();
            clearForm();
            MsgBox.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm thất bại!");
        }
    }
    
    void delete(){
        if(!Auth.isManager()){
            MsgBox.alert(this, "Bạn không có quyền thực hiện chức năng này");
        }else{
            if(MsgBox.confirm(this, "Bạn có thực sữ muốn xóa môn học này!")){
                try {
                    String manganh = txtMaMon.getText();
                    dao.delete(manganh);
                    filltable();
                    clearForm();
                    MsgBox.alert(this, "Xóa thành công!");
                } catch (Exception e) {
                    MsgBox.alert(this, "Xóa thất bại!");
                }
            }
        }
    }
    
    void update(){
        if(!fixformUpdate()){
            return;
        }
        MonHoc n = getForm();
        try {
            dao.update(n);
            filltable();
            clearForm();
            MsgBox.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại!");
        }
    }
    
    void clearForm(){
        MonHoc n = new MonHoc();
        setForm(n);
        row = -1;
        tblMonHoc.clearSelection();
        lblAnhDaiDien.setToolTipText(null);
        lblAnhDaiDien.setIcon(null);
    }
    
    boolean fixform(){
        int tong = tblMonHoc.getRowCount();
        if(txtMaMon.getText().equals("")){
            MsgBox.alert(this, "Không được bỏ trống mã môn!");
            return false;
        }
        if(txtTenMon.getText().equals("")){
            MsgBox.alert(this, "Không được bỏ trống tên môn!");
            return false;
        }
        if(txtMoTa.getText().equals("")){
            MsgBox.alert(this, "Không được bỏ trống mô tả!");
            return false;
        }
        for(int i =0; i<tong ;i++){
            if(txtMaMon.getText().equals(tblMonHoc.getValueAt(i ,0).toString())){
                MsgBox.alert(this, "Mã ngành đã tồn tại!");
                return false;
            }
        }
        return true ;
    }
    
    boolean fixformUpdate(){
        int tong = tblMonHoc.getRowCount();
        System.out.println(lblAnhDaiDien.getToolTipText());
        if(txtMaMon.getText().equals("")){
            MsgBox.alert(this, "Không được bỏ trống mã môn!");
            return false;
        }
        if(txtTenMon.getText().equals("")){
            MsgBox.alert(this, "Không được bỏ trống tên môn!");
            return false;
        }
        if(txtMoTa.getText().equals("")){
            MsgBox.alert(this, "Không được bỏ trống mô tả!");
            return false;
        }
        for(int i =0; i<tong ;i++){
            if(txtMaMon.getText().equals(tblMonHoc.getValueAt(i ,0).toString())){
                break;
            }
            if((!txtMaMon.getText().equals(tblMonHoc.getValueAt(i ,0).toString()))&&(i==tong-1)){
                MsgBox.alert(this, "Mã ngành không tồn tại!");
                return false;
            }
        }
        return true ;
    }
    
    void chonAnh(){
        JFileChooser fileChooser= new JFileChooser();
        if(fileChooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            XImage.saveLogo(file);
            ImageIcon icon = XImage.readLogo(file.getName());
            lblAnhDaiDien.setIcon(new ImageIcon(fileChooser.getCurrentDirectory()+"/"+file.getName()));
            lblAnhDaiDien.setToolTipText(file.getName());
        }
    }
}
