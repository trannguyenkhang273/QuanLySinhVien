/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.Ui;

import com.QLSV.DAO.KyDAO;
import com.QLSV.DAO.MonHocCuaNganhDAO;
import com.QLSV.DAO.MonHocDAO;
import com.QLSV.DAO.NganhDAO;
import com.QLSV.Model.Ky;
import com.QLSV.Model.MonHoc;
import com.QLSV.Model.MonHocCuaNganh;
import com.QLSV.Model.Nganh;
import com.QLSV.Utility.MsgBox;
import com.QLSV.Utility.Other;
import java.awt.Color;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Tho
 */
public class MonCuaNganhPanel extends javax.swing.JPanel {

    /**
     * Creates new form MonCuaNganhPanel
     */
    public MonCuaNganhPanel() {
        initComponents();
        txtTimKiem.setBackground(new Color(255, 255, 255, 0));
        Other.setTable(tblLeft);
        Other.setTable(tblRight);
        init();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRight = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblLeft = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cboNganh = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cboKy = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnNext = new javax.swing.JLabel();
        btnPrevious = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1180, 780));
        setPreferredSize(new java.awt.Dimension(1180, 780));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 31, 151));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ MÔN HỌC CỦA NGHÀNH");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1180, -1));

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTimKiem.setBorder(null);
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });
        add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 330, 20));

        tblRight.setAutoCreateRowSorter(true);
        tblRight.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblRight.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã môn", "Tên môn", "Mô tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRight.setGridColor(new java.awt.Color(255, 255, 255));
        tblRight.setOpaque(false);
        tblRight.setRowHeight(20);
        tblRight.setSurrendersFocusOnKeystroke(true);
        tblRight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRightMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblRight);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 490, 500));

        tblLeft.setAutoCreateRowSorter(true);
        tblLeft.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblLeft.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã môn", "Tên môn", "Mô tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLeft.setGridColor(new java.awt.Color(255, 255, 255));
        tblLeft.setOpaque(false);
        tblLeft.setRowHeight(20);
        tblLeft.setSurrendersFocusOnKeystroke(true);
        tblLeft.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLeftMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblLeft);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 490, 500));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Ngành :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, -1, -1));

        cboNganh.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cboNganh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboNganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNganhActionPerformed(evt);
            }
        });
        add(cboNganh, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, 190, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Kỳ:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 130, -1, -1));

        cboKy.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cboKy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kỳ 1", "Kỳ 2", "Kỳ 3", "Kỳ 4", "Kỳ 5" }));
        cboKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKyActionPerformed(evt);
            }
        });
        add(cboKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 130, 70, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/barSearch.png"))); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 470, -1));

        btnNext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/next.png"))); // NOI18N
        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNextMouseClicked(evt);
            }
        });
        add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 110, -1));

        btnPrevious.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/rewind_120px.png"))); // NOI18N
        btnPrevious.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrevious.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPreviousMouseClicked(evt);
            }
        });
        add(btnPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, 110, 90));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNextMouseClicked
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnNextMouseClicked

    private void btnPreviousMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPreviousMouseClicked
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnPreviousMouseClicked

    private void tblLeftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLeftMouseClicked
        // TODO add your handling code here:
        row= tblLeft.getSelectedRow();
        tblRight.clearSelection();
    }//GEN-LAST:event_tblLeftMouseClicked

    private void tblRightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRightMouseClicked
        // TODO add your handling code here:
        rowRight= tblRight.getSelectedRow();
        tblLeft.clearSelection();
    }//GEN-LAST:event_tblRightMouseClicked

    private void cboNganhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNganhActionPerformed
        // TODO add your handling code here:
        filltableLeft();
        fillTableRight();
    }//GEN-LAST:event_cboNganhActionPerformed

    private void cboKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboKyActionPerformed
        // TODO add your handling code here:
        filltableLeft();
        fillTableRight();
    }//GEN-LAST:event_cboKyActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        DefaultTableModel model = (DefaultTableModel)tblLeft.getModel();
        try {
            TableRowSorter<DefaultTableModel> ts = new TableRowSorter<>(model);
            tblLeft.setRowSorter(ts);
            ts.setRowFilter(RowFilter.regexFilter(txtTimKiem.getText()));
//            tblGridView.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemKeyReleased

    public void setColor(JLabel p) {
        p.setForeground(new Color(255, 250, 101));
    }

    public void resetColor(JLabel p1) {
        p1.setForeground(new Color(255, 255, 255));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnNext;
    private javax.swing.JLabel btnPrevious;
    private javax.swing.JComboBox<String> cboKy;
    private javax.swing.JComboBox<String> cboNganh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblLeft;
    private javax.swing.JTable tblRight;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
    MonHocDAO dao = new MonHocDAO();
    int row = -1;
    int rowRight = -1;
    DefaultTableModel modelLeft ;
    DefaultTableModel modelRight ;
    NganhDAO nganhDao = new NganhDAO();
    KyDAO kyDao = new KyDAO();
    MonHocCuaNganhDAO mcnDao = new MonHocCuaNganhDAO();
    
     void init(){
        //fillComboBoxNganh();
        //filltableLeft();
        fillComboBoxNganh();
        fillComboBoxKy();
    }
    
    void fillComboBoxNganh(){
        DefaultComboBoxModel cbomodel = (DefaultComboBoxModel) cboNganh.getModel();
        cbomodel.removeAllElements();
        List<Nganh> list = nganhDao.selectAll();
        for(Nganh c: list){
            cbomodel.addElement(c);
        }
    }
    
    void fillComboBoxKy(){
        DefaultComboBoxModel cbomodel = (DefaultComboBoxModel) cboKy.getModel();
        cbomodel.removeAllElements();
        List<Ky> list = kyDao.selectAll();
        for(Ky c: list){
            cbomodel.addElement(c.getMaKy());
        }
    }
    
    private void filltableLeft(){
        Object manganh = (Object) cboNganh.getSelectedItem();
        String asdasd = String.valueOf(manganh);
        String[] parts = asdasd.split("-");
        String parts1 = parts[0];
        int mk = 0 ;
        try {
            int maky = (int) cboKy.getSelectedItem();
            mk = maky;
        } catch (Exception e) {
        }
        modelLeft = (DefaultTableModel) tblLeft.getModel();
        modelLeft.setRowCount(0);
        try {
            List<MonHoc> list = null;
            list = dao.selectNotInNganh(parts1,mk);
            for(MonHoc n : list){
                Object row[] = {n.getMaMon(),n.getTenMon(),n.getMoTa()};
                modelLeft.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
            e.printStackTrace();
        }
    }
    
    void fillTableRight(){
        Object manganh = (Object) cboNganh.getSelectedItem();
        String asdasd = String.valueOf(manganh);
        String[] parts = asdasd.split("-");
        String parts1 = parts[0];
        int mk = 0 ;
        try {
            int maky = (int) cboKy.getSelectedItem();
            mk = maky;
        } catch (Exception e) {
        }
        modelRight = (DefaultTableModel) tblRight.getModel();
        modelRight.setRowCount(0);
        List<MonHocCuaNganh> list = mcnDao.selectnganh(parts1,mk);
        for(MonHocCuaNganh mcn : list){
            try {
                List<MonHoc> listmcgv = null;
                listmcgv = dao.selectInCourse(mcn.getMaMon());
                for(MonHoc n : listmcgv){
                    Object row[] = {n.getMaMon(),n.getTenMon(),n.getMoTa()};
                    modelRight.addRow(row);
            }
            } catch (Exception e) {
                MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
            }
        }
    }
    
    void insert(){
        Object magv = (Object) cboNganh.getSelectedItem();
        String asdasd = String.valueOf(magv);
        String[] parts = asdasd.split("-");
        String parts1 = parts[0];
        int mk = 0 ;
        try {
            int maky = (int) cboKy.getSelectedItem();
            mk = maky;
        } catch (Exception e) {
        }
        try {
            if(tblLeft.getSelectedRow()==-1){
                MsgBox.alert(this, "Bạn chưa chọn môn");
            }else{
                for(int row : tblLeft.getSelectedRows()){
                    MonHocCuaNganh mcn = new MonHocCuaNganh();
                    mcn.setMaNganh(parts1);
                    mcn.setMaMon((String) tblLeft.getValueAt(row, 0));
                    mcn.setMaky(mk);
                    mcnDao.insert(mcn);
                    
                }
                fillTableRight();
                filltableLeft();
            }
        } catch (Exception e) {
        }
    }
    
    void delete(){
        Object magv = (Object) cboNganh.getSelectedItem();
        String asdasd = String.valueOf(magv);
        String[] parts = asdasd.split("-");
        String parts1 = parts[0];
        int mk = 0 ;
        try {
            int maky = (int) cboKy.getSelectedItem();
            mk = maky;
        } catch (Exception e) {
        }
        try {
            if(tblRight.getSelectedRow()==-1){
                MsgBox.alert(this, "Bạn chưa chọn môn");
            }else{
                for(int row : tblRight.getSelectedRows()){
                    MonHocCuaNganh mcn = new MonHocCuaNganh();
                    mcn.setMaNganh(parts1);
                    mcn.setMaMon((String) tblRight.getValueAt(row, 0));
                    mcn.setMaky(mk);
                    mcnDao.deleteMcN(mcn);
                }
                fillTableRight();
                filltableLeft();
            }
        } catch (Exception e) {
        }
    }
}
