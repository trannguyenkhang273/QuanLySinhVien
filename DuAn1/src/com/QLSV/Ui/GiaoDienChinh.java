/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.Ui;

import com.QLSV.Model.Ky;
import com.QLSV.Utility.Auth;
import com.QLSV.Utility.MsgBox;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import com.QLSV.Utility.NhacNen;
import com.QLSV.Utility.XImage;
import java.awt.Desktop;
import java.io.File;
import java.sql.SQLException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 *
 * @author Tho
 */
public class GiaoDienChinh extends javax.swing.JFrame implements Runnable {
    LopPanel quanLyLop;
    DoiMatkhauPanel doiMatKhau;
    LamTheSinhVienPanel lamTheSinhVien;
    MonCuaGiangVienPane monCuaGiangVien;
    MonCuaNganhPanel monHocCuaNganh;
    MonHocPanel monHoc;
    NganhPanel quanLyNganh;
    QuanLyGiangVienPanel quanLyGiangVien;
    QuanLyKyPanel quanLyKy;
    QuanLyNhanVienPanel quanLyNhanVien;
    QuanLySinhVienPanel quanLySinhVien;
    ThemSinhVienPanel themSinhVien;
    ThongKePanel thongKe;
    TangKyPanel tangKy;
    GiangVienLopMonPanel  lichGiangDay; 
    
    /**
     * Creates new form GiaoDienChinh
     */
    int posX;
    int posY;
    Timer open;
    Timer close;
    ActionListener dong;
    ActionListener mo;
    public GiaoDienChinh() throws IOException {
        initComponents(); 
        moveFrame();
        AnimationTab();
        getContentPane().setBackground(Color.white);
        addJPanel();
        setPanel();
        addJPanel();
        setPanelIntoPanelChinh();
        showPanel(0);this.setIconImage(XImage.getAppIcon());
    }
    public void setPanel() throws IOException{
        QuanLySinhVienPanel qlsv =new QuanLySinhVienPanel();
        quanLySinhVien=qlsv;
        
        QuanLyGiangVienPanel qlgv =new QuanLyGiangVienPanel(listPanel,11);
        quanLyGiangVien=qlgv;
        
        QuanLyNhanVienPanel qlnv =new QuanLyNhanVienPanel();
        quanLyNhanVien=qlnv;
        
        NganhPanel n=new NganhPanel(listPanel,12);
        quanLyNganh=n;
        
        LopPanel l=new LopPanel(listPanel,10,13);
        quanLyLop=l;
        
        MonHocPanel mh= new MonHocPanel(listPanel,14);
        monHoc=mh;
        
        QuanLyKyPanel qlk= new QuanLyKyPanel();
        quanLyKy=qlk;
        
        LamTheSinhVienPanel ltsv=new LamTheSinhVienPanel();
        lamTheSinhVien=ltsv;
        
        ThongKePanel tk=new ThongKePanel();
        thongKe=tk;
        
        DoiMatkhauPanel dmk =new DoiMatkhauPanel();
        doiMatKhau=dmk;
        
        ThemSinhVienPanel tsv=new ThemSinhVienPanel();
        themSinhVien=tsv;
        
        MonCuaGiangVienPane mhcgv=new MonCuaGiangVienPane();
        monCuaGiangVien=mhcgv;
        
        MonCuaNganhPanel mhcn =new MonCuaNganhPanel();
        monHocCuaNganh=mhcn;
        
        TangKyPanel tkp =new TangKyPanel();
        tangKy =tkp;
        
        GiangVienLopMonPanel lgd =new GiangVienLopMonPanel();
        lichGiangDay =lgd;
    }
    public void addJPanel() {
        listPanel.removeAll(listPanel);
        listPanel.add(quanLySinhVien);//0
        listPanel.add(quanLyGiangVien);//1
        listPanel.add(quanLyNhanVien);//2
        listPanel.add(quanLyNganh);//3
        listPanel.add(quanLyLop);//4
        listPanel.add(monHoc);//5
        listPanel.add(quanLyKy);//6
        listPanel.add(lamTheSinhVien);//7
        listPanel.add(thongKe);//8
        listPanel.add(doiMatKhau);//9
        
        listPanel.add(themSinhVien);//10
        listPanel.add(monCuaGiangVien);//11
        listPanel.add(monHocCuaNganh);//12
        listPanel.add(tangKy);//13
        listPanel.add(lichGiangDay);//14
        
        listLabel.add(btnQuanLySinhVien); //0
        listLabel.add(btnQuanLyGiangVien);//1
        listLabel.add(btnQuanLyNhanVien);//2
        listLabel.add(btnQuanLyNganh);//3
        listLabel.add(btnQuanLyLop);//4
        listLabel.add(btnQuanLyMonHoc);//5
        listLabel.add(btnQuanLyKy);//6
        listLabel.add(btnLamTheSinhVien);//7
        listLabel.add(btnThongKe); //8
        listLabel.add(btnDoiMauKhau);//9
        
        listLabel.add(btnQuanLyLop); //10
        listLabel.add(btnQuanLyGiangVien); //11
        listLabel.add(btnQuanLyNganh); //12
        listLabel.add(btnQuanLyMonHoc);
    }
    void setPanelIntoPanelChinh(){
        for(JPanel p:listPanel){
            panelChinh.add(p);
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

        panelTitle = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelMenu = new javax.swing.JPanel();
        lblMenu = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        panelChinh = new javax.swing.JPanel();
        panelLeft = new javax.swing.JPanel();
        lblSound = new javax.swing.JLabel();
        btnQuanLyNganh = new javax.swing.JLabel();
        btnQuanLyLop = new javax.swing.JLabel();
        btnQuanLyKy = new javax.swing.JLabel();
        btnQuanLySinhVien = new javax.swing.JLabel();
        btnQuanLyNhanVien = new javax.swing.JLabel();
        btnLamTheSinhVien = new javax.swing.JLabel();
        btnQuanLyGiangVien = new javax.swing.JLabel();
        btnQuanLyMonHoc = new javax.swing.JLabel();
        btnLogout = new javax.swing.JLabel();
        btnThongKe = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        btnDoiMauKhau = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelTitle.setBackground(new java.awt.Color(0, 114, 255));
        panelTitle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageTest/x_25px.png"))); // NOI18N
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });
        panelTitle.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1455, 0, 80, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageTest/iconfram.png"))); // NOI18N
        panelTitle.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 0, 66, 45));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Lập Trình City - Quản Lý Sinh Viên");
        panelTitle.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, 30));

        panelMenu.setBackground(new java.awt.Color(72, 187, 255));
        panelMenu.setForeground(new java.awt.Color(255, 255, 255));
        panelMenu.setPreferredSize(new java.awt.Dimension(456, 105));

        lblMenu.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/left_arrow_50px.png"))); // NOI18N
        lblMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuMouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/google_photos_125px.png"))); // NOI18N
        jLabel15.setText("Lập trình City");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelMenuLayout.createSequentialGroup()
                    .addGap(128, 128, 128)
                    .addComponent(jLabel15)
                    .addContainerGap(1082, Short.MAX_VALUE)))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelMenuLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panelChinh.setBackground(new java.awt.Color(255, 255, 255));
        panelChinh.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                panelChinhComponentMoved(evt);
            }
        });
        panelChinh.setLayout(new java.awt.CardLayout());

        panelLeft.setBackground(new java.awt.Color(255, 255, 255));
        panelLeft.setPreferredSize(new java.awt.Dimension(320, 770));
        panelLeft.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                panelLeftComponentMoved(evt);
            }
        });

        lblSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/sound_130px.png"))); // NOI18N
        lblSound.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSoundMouseClicked(evt);
            }
        });

        btnQuanLyNganh.setBackground(new java.awt.Color(6, 159, 245));
        btnQuanLyNganh.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnQuanLyNganh.setForeground(new java.awt.Color(6, 159, 245));
        btnQuanLyNganh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/user_groups_100px.png"))); // NOI18N
        btnQuanLyNganh.setText("Quản lý ngành");
        btnQuanLyNganh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuanLyNganh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLyNganhMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnQuanLyNganhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnQuanLyNganhMouseExited(evt);
            }
        });

        btnQuanLyLop.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnQuanLyLop.setForeground(new java.awt.Color(6, 159, 245));
        btnQuanLyLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/class_120px.png"))); // NOI18N
        btnQuanLyLop.setText("Quản lý lớp");
        btnQuanLyLop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuanLyLop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLyLopMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnQuanLyLopMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnQuanLyLopMouseExited(evt);
            }
        });

        btnQuanLyKy.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnQuanLyKy.setForeground(new java.awt.Color(6, 159, 245));
        btnQuanLyKy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/ky.png"))); // NOI18N
        btnQuanLyKy.setText("Quản lý kỳ");
        btnQuanLyKy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuanLyKy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLyKyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnQuanLyKyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnQuanLyKyMouseExited(evt);
            }
        });

        btnQuanLySinhVien.setBackground(new java.awt.Color(6, 159, 245));
        btnQuanLySinhVien.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnQuanLySinhVien.setForeground(new java.awt.Color(6, 159, 245));
        btnQuanLySinhVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/male_user_120px.png"))); // NOI18N
        btnQuanLySinhVien.setText("Quản lý sinh viên");
        btnQuanLySinhVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuanLySinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLySinhVienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnQuanLySinhVienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnQuanLySinhVienMouseExited(evt);
            }
        });

        btnQuanLyNhanVien.setBackground(new java.awt.Color(6, 159, 245));
        btnQuanLyNhanVien.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnQuanLyNhanVien.setForeground(new java.awt.Color(6, 159, 245));
        btnQuanLyNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/staff_50px.png"))); // NOI18N
        btnQuanLyNhanVien.setText("Quản lỳ nhân viên");
        btnQuanLyNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuanLyNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLyNhanVienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnQuanLyNhanVienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnQuanLyNhanVienMouseExited(evt);
            }
        });

        btnLamTheSinhVien.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnLamTheSinhVien.setForeground(new java.awt.Color(6, 159, 245));
        btnLamTheSinhVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/card_security_120px.png"))); // NOI18N
        btnLamTheSinhVien.setText("Làm thẻ sinh viên");
        btnLamTheSinhVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamTheSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLamTheSinhVienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLamTheSinhVienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLamTheSinhVienMouseExited(evt);
            }
        });

        btnQuanLyGiangVien.setBackground(new java.awt.Color(6, 159, 245));
        btnQuanLyGiangVien.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnQuanLyGiangVien.setForeground(new java.awt.Color(6, 159, 245));
        btnQuanLyGiangVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/teacher_32px.png"))); // NOI18N
        btnQuanLyGiangVien.setText("Quản lý giảng viên");
        btnQuanLyGiangVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuanLyGiangVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLyGiangVienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnQuanLyGiangVienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnQuanLyGiangVienMouseExited(evt);
            }
        });

        btnQuanLyMonHoc.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnQuanLyMonHoc.setForeground(new java.awt.Color(6, 159, 245));
        btnQuanLyMonHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/portrait_120px.png"))); // NOI18N
        btnQuanLyMonHoc.setText("Quản lý môn học");
        btnQuanLyMonHoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuanLyMonHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLyMonHocMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnQuanLyMonHocMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnQuanLyMonHocMouseExited(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(6, 159, 245));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/logout_rounded_left_120px.png"))); // NOI18N
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });

        btnThongKe.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(6, 159, 245));
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/total_sales_50px.png"))); // NOI18N
        btnThongKe.setText("Thống kê");
        btnThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThongKeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnThongKeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnThongKeMouseExited(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/bong.png"))); // NOI18N

        btnDoiMauKhau.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnDoiMauKhau.setForeground(new java.awt.Color(6, 159, 245));
        btnDoiMauKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/change_120px.png"))); // NOI18N
        btnDoiMauKhau.setText("Đổi mật khẩu");
        btnDoiMauKhau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDoiMauKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDoiMauKhauMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDoiMauKhauMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDoiMauKhauMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelLeftLayout = new javax.swing.GroupLayout(panelLeft);
        panelLeft.setLayout(panelLeftLayout);
        panelLeftLayout.setHorizontalGroup(
            panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLeftLayout.createSequentialGroup()
                        .addComponent(btnLogout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSound, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLeftLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnQuanLySinhVien, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addComponent(btnQuanLyGiangVien, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                            .addComponent(btnQuanLyNganh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnQuanLyNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnQuanLyLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnQuanLyMonHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnQuanLyKy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLamTheSinhVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDoiMauKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelLeftLayout.setVerticalGroup(
            panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLeftLayout.createSequentialGroup()
                .addComponent(btnQuanLySinhVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuanLyGiangVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuanLyNhanVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuanLyNganh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuanLyLop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuanLyMonHoc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuanLyKy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLamTheSinhVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThongKe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDoiMauKhau)
                .addGap(31, 31, 31)
                .addGroup(panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout)
                    .addComponent(lblSound))
                .addContainerGap())
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 1536, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelChinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(panelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 1536, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelChinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    int menu = 0;
    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnExitMouseClicked

    private void lblMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuMouseClicked
        if (menu == 0) {
            open.stop();
            close.start();
            lblMenu.setIcon(new ImageIcon(getClass().getResource("/com/QLSV/Icon/menu_rounded_100px.png")));
            menu++;
        } else {
            close.stop();
            open.start();
            lblMenu.setIcon(new ImageIcon(getClass().getResource("/com/QLSV/Icon/left_arrow_50px.png")));
            menu--;
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_lblMenuMouseClicked

    private void panelLeftComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelLeftComponentMoved
        if (panelLeft.getX() < -320) {
            close.stop();
        }
        if (panelLeft.getX() > 8) {
            open.stop();
            panelLeft.setLocation(0, panelLeft.getY());
            panelChinh.setLocation(339, panelLeft.getY());
        }
    }//GEN-LAST:event_panelLeftComponentMoved

    private void panelChinhComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelChinhComponentMoved

    }//GEN-LAST:event_panelChinhComponentMoved

    private void btnQuanLyNganhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyNganhMouseClicked
        if(Auth.isManager()){
            showPanel(3); 
        }else{
            MsgBox.alert(this, "Bạn không có quyền"); 
        }
    }//GEN-LAST:event_btnQuanLyNganhMouseClicked

    private void btnQuanLyMonHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyMonHocMouseClicked
        if(Auth.isManager()){
            showPanel(5);
        }else{
            MsgBox.alert(this, "Bạn không có quyền"); 
        }
    }//GEN-LAST:event_btnQuanLyMonHocMouseClicked

    private void btnQuanLySinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLySinhVienMouseClicked
        
        showPanel(0); 
        quanLySinhVien.load();
        quanLySinhVien.fillComboBox();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLySinhVienMouseClicked

    private void btnQuanLyGiangVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyGiangVienMouseClicked
        if(Auth.isManager()){
            showPanel(1);
            quanLyGiangVien.init();  
        }else{
            MsgBox.alert(this, "Bạn không có quyền"); 
        }
        
    }//GEN-LAST:event_btnQuanLyGiangVienMouseClicked

    private void btnQuanLyNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyNhanVienMouseClicked
        if(Auth.isManager()){
            showPanel(2);
            quanLyNhanVien.init();
        }else{
            MsgBox.alert(this, "Bạn không có quyền"); 
        }
        
        
    }//GEN-LAST:event_btnQuanLyNhanVienMouseClicked

    private void btnQuanLyLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyLopMouseClicked
        showPanel(4);
        quanLyLop.fillComboBox();
        quanLyLop.fillComboBoxKy();
        quanLyLop.load();
    }//GEN-LAST:event_btnQuanLyLopMouseClicked

    private void btnLamTheSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLamTheSinhVienMouseClicked
        showPanel(7);
    }//GEN-LAST:event_btnLamTheSinhVienMouseClicked

    private void btnQuanLySinhVienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLySinhVienMouseEntered
        hover(btnQuanLySinhVien, "");
    }//GEN-LAST:event_btnQuanLySinhVienMouseEntered

    private void btnQuanLyGiangVienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyGiangVienMouseEntered
        hover(btnQuanLyGiangVien, "");
    }//GEN-LAST:event_btnQuanLyGiangVienMouseEntered

    private void btnQuanLyNhanVienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyNhanVienMouseEntered
        hover(btnQuanLyNhanVien, "");        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyNhanVienMouseEntered

    private void btnQuanLyNganhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyNganhMouseEntered
        hover(btnQuanLyNganh, "");        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyNganhMouseEntered

    private void btnQuanLyLopMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyLopMouseEntered
        hover(btnQuanLyLop, "");        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyLopMouseEntered

    private void btnQuanLyMonHocMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyMonHocMouseEntered
        hover(btnQuanLyMonHoc, "");
    }//GEN-LAST:event_btnQuanLyMonHocMouseEntered

    private void btnQuanLyKyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyKyMouseEntered
        hover(btnQuanLyKy, "");
    }//GEN-LAST:event_btnQuanLyKyMouseEntered

    private void btnLamTheSinhVienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLamTheSinhVienMouseEntered
        hover(btnLamTheSinhVien, "");
    }//GEN-LAST:event_btnLamTheSinhVienMouseEntered

    private void btnQuanLySinhVienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLySinhVienMouseExited
        unHover(btnQuanLySinhVien, "", 0);
    }//GEN-LAST:event_btnQuanLySinhVienMouseExited

    private void btnQuanLyGiangVienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyGiangVienMouseExited
        unHover(btnQuanLyGiangVien, "", 1);
    }//GEN-LAST:event_btnQuanLyGiangVienMouseExited

    private void btnQuanLyNhanVienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyNhanVienMouseExited
        unHover(btnQuanLyNhanVien, "", 2);
    }//GEN-LAST:event_btnQuanLyNhanVienMouseExited

    private void btnQuanLyNganhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyNganhMouseExited
        unHover(btnQuanLyNganh, "", 3);
    }//GEN-LAST:event_btnQuanLyNganhMouseExited

    private void btnQuanLyLopMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyLopMouseExited
        unHover(btnQuanLyLop, "", 4);
    }//GEN-LAST:event_btnQuanLyLopMouseExited

    private void btnQuanLyMonHocMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyMonHocMouseExited
        unHover(btnQuanLyMonHoc, "", 5);
    }//GEN-LAST:event_btnQuanLyMonHocMouseExited

    private void btnQuanLyKyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyKyMouseExited
        unHover(btnQuanLyKy, "", 6);
    }//GEN-LAST:event_btnQuanLyKyMouseExited

    private void btnLamTheSinhVienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLamTheSinhVienMouseExited
        unHover(btnLamTheSinhVien, "", 7);
    }//GEN-LAST:event_btnLamTheSinhVienMouseExited

    private void btnQuanLyKyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyKyMouseClicked
        if(Auth.isManager()){
            showPanel(6); 
            quanLyNhanVien.init();
        }else{
            MsgBox.alert(this, "Bạn không có quyền"); 
        }// TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyKyMouseClicked

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered

    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited

    }//GEN-LAST:event_btnExitMouseExited

    private void btnThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeMouseClicked
        if(Auth.isManager()){
            showPanel(8);
            thongKe.showBarChart();
            thongKe.tron();
            thongKe.fillcomboxMon1();
            thongKe.fillcomboxMon2();
            thongKe.TopSV();
        }else{
            MsgBox.alert(this, "Bạn không có quyền"); 
        }//
        
    }//GEN-LAST:event_btnThongKeMouseClicked

    private void btnThongKeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeMouseEntered
        hover(btnThongKe, "");
    }//GEN-LAST:event_btnThongKeMouseEntered

    private void btnThongKeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeMouseExited
         unHover(btnThongKe, "", 8);        // TODO add your handling code here:
    }//GEN-LAST:event_btnThongKeMouseExited

    private void lblSoundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSoundMouseClicked
         NhacNen.stop();
        if (NhacNen.nhac == 0) {
            lblSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QLSV/Icon/mute_50px.png")));
        } else {
            lblSound.setIcon(new ImageIcon(getClass().getResource("/com/QLSV/Icon/sound_130px.png")));
        }
    }//GEN-LAST:event_lblSoundMouseClicked

    private void btnDoiMauKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoiMauKhauMouseClicked
        showPanel(9); 
    }//GEN-LAST:event_btnDoiMauKhauMouseClicked

    private void btnDoiMauKhauMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoiMauKhauMouseEntered
        hover(btnDoiMauKhau, "");   
    }//GEN-LAST:event_btnDoiMauKhauMouseEntered

    private void btnDoiMauKhauMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoiMauKhauMouseExited
        unHover(btnDoiMauKhau, "", 8);   
    }//GEN-LAST:event_btnDoiMauKhauMouseExited

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        DangNhapFrame dn;
        try {
            dn = new DangNhapFrame();        dn.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GiaoDienChinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(GiaoDienChinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GiaoDienChinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(GiaoDienChinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
         try {
            Desktop.getDesktop().browse(new File("/TS/index.html").toURI());
            //thư mục help đặt ngang hàng với src
        } catch (IOException ex) {
             MsgBox.alert(this, "Không tìm thấy file hướng dẫn!");
        }
    }//GEN-LAST:event_jLabel15MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    GiaoDienChinh gdc = new GiaoDienChinh(); 
                    gdc.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(GiaoDienChinh.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDoiMauKhau;
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnLamTheSinhVien;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnQuanLyGiangVien;
    private javax.swing.JLabel btnQuanLyKy;
    private javax.swing.JLabel btnQuanLyLop;
    private javax.swing.JLabel btnQuanLyMonHoc;
    private javax.swing.JLabel btnQuanLyNganh;
    private javax.swing.JLabel btnQuanLyNhanVien;
    private javax.swing.JLabel btnQuanLySinhVien;
    private javax.swing.JLabel btnThongKe;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JLabel lblSound;
    private javax.swing.JPanel panelChinh;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelTitle;
    // End of variables declaration//GEN-END:variables

   void AnimationTab(){
        dong = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int x = panelLeft.getX();
                panelLeft.setLocation(x - 14, panelLeft.getY());
                int y = panelChinh.getX();
                panelChinh.setLocation(y - 7, panelLeft.getY());

            }
        ;
        } ;
        close = new Timer(10, dong);
        mo = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int x = panelLeft.getX();
                panelLeft.setLocation(x + 14, panelLeft.getY());
                int y = panelChinh.getX();
                panelChinh.setLocation(y + 7, panelLeft.getY());
            }
        ;
        } ;  
            open = new Timer(10, mo);
    }
    void moveFrame(){
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                posX = e.getX();
                posY = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent evt) {
                //sets frame position when mouse dragged			
                setLocation(evt.getXOnScreen() - posX, evt.getYOnScreen() - posY);

            }
        });
    }
   
    int panelDangChon = 0;
    ArrayList<JPanel> listPanel = new ArrayList<>();
    ArrayList<JLabel> listLabel = new ArrayList<>();

    

    public void showPanel(int index) {
        panelDangChon = index;
        for (int i = 0; i < listPanel.size(); i++) {
            listPanel.get(i).show(false);
            listLabel.get(i).setForeground(new Color(6, 159, 245));
            if (i == index) {
                listPanel.get(index).show(true);
                listLabel.get(index).setForeground(Color.blue);
            }
        }

    }

    public void hover(JLabel lbl, String url) {
        lbl.setForeground(Color.blue);
    }

    public void unHover(JLabel lbl, String url, int index) {
        lbl.setForeground(new Color(6, 159, 245));
        listLabel.get(panelDangChon).setForeground(Color.blue);
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
