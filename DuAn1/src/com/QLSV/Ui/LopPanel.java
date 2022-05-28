/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.QLSV.Ui;

import com.QLSV.DAO.KyDAO;
import com.QLSV.DAO.LopDAO;
import com.QLSV.DAO.NganhDAO;
import com.QLSV.Model.Ky;
import com.QLSV.Model.Lop;
import com.QLSV.Model.Nganh;
import com.QLSV.Model.SinhVien;
import com.QLSV.Utility.Other;
import com.QLSV.Utility.XImage;
import java.awt.Color;
import static java.awt.Color.white;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tontr
 */
public class LopPanel extends javax.swing.JPanel {
    ArrayList<JPanel> list ;
    int trang;
    int trangKy;
    /**
     * Creates new form LopPanel
     */
    public LopPanel(ArrayList<JPanel> j,int i,int ky) {
        initComponents();
        Other.setTable(tblLop);
        fillComboBox();
        fillComboBoxKy();
        load();
        list=j;
        trang=i;
        trangKy=ky;
    }
    public void showPanel(int index){
        for (int i = 0; i < list.size(); i++) {
            list.get(i).show(false);
            if(i==index){
                list.get(index).show(true);
            }
        } 
    }
    int index = 0;
    NganhDAO ngdao = new NganhDAO();
    LopDAO ldao = new LopDAO();
    KyDAO kdao = new KyDAO();
    void fillComboBox() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbMaNghanh.getModel(); 
        model.removeAllElements();   
        try {
            List<Nganh> list = ngdao.selectAll();
            for (Nganh cd : list) {
                model.addElement(cd.getMaNganh());
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    void fillComboBoxKy() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboKy.getModel(); 
        model.removeAllElements();   
        try {
            List<Ky> list = kdao.selectAll();
            for (Ky cd : list) {
                model.addElement(cd.getMaKy());
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    void load() {
        DefaultTableModel model = (DefaultTableModel) tblLop.getModel();
        model.setRowCount(0);   //đưa số dòng về 0 (xóa bảng)
        try {
            List<Lop> list = ldao.selectAll();
            for (Lop sv : list) {
                Object[] row = {
                    sv.getMaLop(),
                    sv.getMaNganh(),
                    sv.getMaky()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    void setModel(Lop model) {
        
        txtMaLop.setText(model.getMaLop());
        cbbMaNghanh.setSelectedItem(model.getMaNganh());
        cboKy.setSelectedItem(model.getMaky());

    }

    Lop getModel() {
        Lop model = new Lop();
        model.setMaLop(txtMaLop.getText());
        Object a = (Object) cbbMaNghanh.getSelectedItem();
        String b = String.valueOf(a);
        model.setMaNganh(b);
        
        Object c = (Object) cboKy.getSelectedItem();
        Integer d = Integer.parseInt(c.toString());
        model.setMaky(d);
                System.out.println(model.getMaLop());
        System.out.println(model.getMaky());
        System.out.println(model.getMaNganh());
        return model;
        
    }
    void insert() {
        Lop model = getModel();
        try {
            ldao.insert(model);   
            this.load();                  
            JOptionPane.showMessageDialog(this, "Thêm msới thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Thêm mới thất bại!");
        }
    }
    void update() {
        Lop model = getModel();
        try {
            ldao.update(model);   
            this.load();         
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
            e.printStackTrace();
        }
    }
    void delete() {
            String masv = txtMaLop.getText();
            try {
                ldao.delete(masv);
                this.load();
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(this, "Xóa thất bại!");
            }
    }

    public void setTrang() {
        txtMaLop.setBackground(white);
    }


    void edit() {
        setTrang();
        try {
            String manh = (String) tblLop.getValueAt(this.index, 0);
            Lop model = ldao.selectByID(manh);  
            if (model != null) {
                this.setModel(model);  
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu!");
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLop = new javax.swing.JTable();
        cbbMaNghanh = new javax.swing.JComboBox<>();
        txtMaLop = new javax.swing.JTextField();
        btnNew = new javax.swing.JLabel();
        btnSave = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        btnAddStudent = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboKy = new javax.swing.JComboBox<>();
        btnKy = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1180, 780));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 31, 151));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUẢN LÝ LỚP");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Mã nghành :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Mã lớp :");

        tblLop.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblLop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã lớp", "Mã Ngành", "Mã Kỳ"
            }
        ));
        tblLop.setGridColor(new java.awt.Color(255, 255, 255));
        tblLop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLopMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLop);

        cbbMaNghanh.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbbMaNghanh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtMaLop.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        btnNew.setBackground(new java.awt.Color(241, 242, 246));
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

        btnAddStudent.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAddStudent.setForeground(new java.awt.Color(255, 255, 255));
        btnAddStudent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAddStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/nutTuGiacDai.png"))); // NOI18N
        btnAddStudent.setText("Thêm sinh viên");
        btnAddStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddStudent.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddStudentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddStudentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddStudentMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Kỳ");

        cboKy.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cboKy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnKy.setBackground(new java.awt.Color(241, 242, 246));
        btnKy.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnKy.setForeground(new java.awt.Color(255, 255, 255));
        btnKy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnKy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/nutTuGiacTB.png"))); // NOI18N
        btnKy.setText("Kỳ");
        btnKy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnKyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnKyMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboKy, 0, 248, Short.MAX_VALUE)
                            .addComponent(cbbMaNghanh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(130, 130, 130)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddStudent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnKy, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbMaNghanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnSave)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnAddStudent)
                    .addComponent(btnKy))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setColor(JLabel p) {
        p.setForeground(new Color(255, 250, 101));
    }

    public void resetColor(JLabel p1) {
        p1.setForeground(new Color(255, 255, 255));
    }

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

    private void btnAddStudentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddStudentMouseEntered
        setColor(btnAddStudent);
    }//GEN-LAST:event_btnAddStudentMouseEntered

    private void btnAddStudentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddStudentMouseExited
        resetColor(btnAddStudent);
    }//GEN-LAST:event_btnAddStudentMouseExited

    private void tblLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLopMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            this.index = tblLop.rowAtPoint(evt.getPoint());//lấy vị trí dòng được chọn
            if (this.index >= 0) {
                this.edit();
            }
        }
    }//GEN-LAST:event_tblLopMouseClicked

    private void btnNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewMouseClicked
        // TODO add your handling code here:
        setTrang();
    }//GEN-LAST:event_btnNewMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        // TODO add your handling code here:
        insert();
        load();
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        // TODO add your handling code here:
        update();
        load();
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnAddStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddStudentMouseClicked
            // TODO add your handling code here:
        showPanel(trang);  
    }//GEN-LAST:event_btnAddStudentMouseClicked

    private void btnKyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKyMouseClicked
        showPanel(trangKy);            // TODO add your handling code here:
    }//GEN-LAST:event_btnKyMouseClicked

    private void btnKyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKyMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKyMouseEntered

    private void btnKyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKyMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKyMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAddStudent;
    private javax.swing.JLabel btnDelete;
    private javax.swing.JLabel btnKy;
    private javax.swing.JLabel btnNew;
    private javax.swing.JLabel btnSave;
    private javax.swing.JLabel btnUpdate;
    private javax.swing.JComboBox<String> cbbMaNghanh;
    private javax.swing.JComboBox<String> cboKy;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLop;
    private javax.swing.JTextField txtMaLop;
    // End of variables declaration//GEN-END:variables
}
