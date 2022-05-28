package com.QLSV.Ui;

/*test_tiep cai_demo*/
import com.QLSV.DAO.GiangVienDAO;
import com.QLSV.Utility.NhacNen;
import com.QLSV.Ui.DangNhapFrame;
import com.QLSV.DAO.LuuTaiKhoanDAO;
import com.QLSV.DAO.NhanVienDAO;
import com.QLSV.DAO.SinhVienDAO;
import com.QLSV.Model.GiangVien;
import com.QLSV.Model.NhanVien;
import com.QLSV.Model.LuuTaiKhoan;
import com.QLSV.Model.SinhVien;
import com.QLSV.Utility.Auth;
import com.QLSV.Utility.MsgBox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.sound.sampled.*;
import sun.rmi.transport.Transport;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author sushi
 */
public class QuenMatKhauFrame extends javax.swing.JFrame {

    /**
     * Creates new form DangNhapFrame
     */
    int posX;
    int posY;
    LuuTaiKhoanDAO dao = new LuuTaiKhoanDAO();

    public QuenMatKhauFrame() throws SQLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        initComponents();
        textExample();

        panelThongBao.setBackground(new Color(255, 255, 255, 0));

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setBackground(new Color(255, 255, 255, 0));
        txtUserName.setBackground(new Color(255, 255, 255, 0));
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
        btnCancel.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
        btnSubmit.setHorizontalTextPosition((int) CENTER_ALIGNMENT);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        txtPlace = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblLoi = new javax.swing.JLabel();
        lblSound = new javax.swing.JLabel();
        panelThongBao = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtUserName = new javax.swing.JTextField();
        btnCancel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JLabel();
        rightPanel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        leftPanel = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPlace.setFont(new java.awt.Font("Trebuchet MS", 3, 16)); // NOI18N
        txtPlace.setForeground(new java.awt.Color(241, 241, 241));
        txtPlace.setText("vd : PS18597");
        getContentPane().add(txtPlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 130, 20));

        jLabel8.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Username");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 150, 30));

        lblLoi.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblLoi.setForeground(new java.awt.Color(238, 118, 118));
        lblLoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageTest/warning.png"))); // NOI18N
        lblLoi.setText("Các ô không được để trống");
        getContentPane().add(lblLoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, 320, -1));

        lblSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageTest/sound_30px.png")));
        lblSound.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSoundMouseClicked(evt);
            }
        });
        getContentPane().add(lblSound, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 60, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Một mã gồm 4 số đã được gửi về gmail của bạn ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Vui lòng nhập để tiếp tục !");

        javax.swing.GroupLayout panelThongBaoLayout = new javax.swing.GroupLayout(panelThongBao);
        panelThongBao.setLayout(panelThongBaoLayout);
        panelThongBaoLayout.setHorizontalGroup(
            panelThongBaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongBaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelThongBaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(21, 21, 21))
        );
        panelThongBaoLayout.setVerticalGroup(
            panelThongBaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongBaoLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        getContentPane().add(panelThongBao, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 390, 330, 60));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, 320, -1));

        txtUserName.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        txtUserName.setForeground(new java.awt.Color(255, 255, 255));
        txtUserName.setBorder(null);
        txtUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtUserNameMouseReleased(evt);
            }
        });
        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUserNameKeyReleased(evt);
            }
        });
        getContentPane().add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 320, 50));

        btnCancel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageTest/nut.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setToolTipText("");
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelMouseExited(evt);
            }
        });
        getContentPane().add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 500, 160, 70));

        jLabel2.setFont(new java.awt.Font("Cambria Math", 1, 40)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Forgot Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 350, 60));

        btnLogin.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageTest/DangXuat.png"))); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginMouseExited(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, 190, 40));

        btnSubmit.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageTest/nut.png"))); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSubmitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSubmitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSubmitMouseExited(evt);
            }
        });
        getContentPane().add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 510, 140, 50));

        rightPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rightPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageTest/right_panel.png"))); // NOI18N
        getContentPane().add(rightPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, -10, 740, 670));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Come Fly With Us");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 250, 50));

        leftPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        leftPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageTest/left_panel.png"))); // NOI18N
        getContentPane().add(leftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 0, 680, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        if (MsgBox.confirm(this, "Bạn có muốn thoạt không :")) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnCancelMouseClicked

    private void btnSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseClicked
        try {
            quenMatKhau();
        } catch (MessagingException ex) {
            Logger.getLogger(QuenMatKhauFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSubmitMouseClicked

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        try {
            setVisible(false);
            DangNhapFrame dNF = new DangNhapFrame();
            dNF.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(QuenMatKhauFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(QuenMatKhauFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(QuenMatKhauFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(QuenMatKhauFrame.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnLoginMouseClicked

    private void txtUserNameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserNameMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameMouseReleased

    private void txtUserNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyReleased
        textExample();         // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameKeyReleased
    int conMat = 0;
    private void lblSoundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSoundMouseClicked
        NhacNen.stop();
        if (NhacNen.nhac == 1) {
            lblSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageTest/sound_30px.png")));
        } else {
            lblSound.setIcon(new ImageIcon(getClass().getResource("/imageTest/foreign_language_sound_30px.png")));
        }
    }//GEN-LAST:event_lblSoundMouseClicked

    private void btnSubmitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseEntered
        setColor(btnSubmit);
    }//GEN-LAST:event_btnSubmitMouseEntered

    private void btnSubmitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmitMouseExited
        resetColor(btnSubmit);
    }//GEN-LAST:event_btnSubmitMouseExited

    private void btnCancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseEntered
        setColor(btnCancel);
    }//GEN-LAST:event_btnCancelMouseEntered

    private void btnCancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseExited
        resetColor(btnCancel);
    }//GEN-LAST:event_btnCancelMouseExited

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        setColor(btnLogin);
    }//GEN-LAST:event_btnLoginMouseEntered

    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseExited
        resetColor(btnLogin);
    }//GEN-LAST:event_btnLoginMouseExited
    String realPass = "";

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
            java.util.logging.Logger.getLogger(QuenMatKhauFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhauFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhauFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhauFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    //                try {
                    new QuenMatKhauFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(QuenMatKhauFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(QuenMatKhauFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(QuenMatKhauFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(QuenMatKhauFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void setColor(JLabel p) {
        p.setForeground(new Color(255, 250, 101));
    }

    public void resetColor(JLabel p1) {
        p1.setForeground(new Color(255, 255, 255));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCancel;
    private javax.swing.JLabel btnLogin;
    private javax.swing.JLabel btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblLoi;
    private javax.swing.JLabel lblSound;
    private javax.swing.JLabel leftPanel;
    private javax.swing.JPanel panelThongBao;
    private javax.swing.JLabel rightPanel;
    private javax.swing.JLabel txtPlace;
    public javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
    public LuuTaiKhoan getModel() {
        LuuTaiKhoan luu = new LuuTaiKhoan(txtUserName.getText(), realPass);
        return luu;
    }

    public void textExample() {
        if (txtUserName.getText().equals("")) {
            txtPlace.setVisible(true);
        } else {
            txtPlace.setVisible(false);
        }
    }

    NhanVienDAO nvDAO = new NhanVienDAO();
    GiangVienDAO gvDAO = new GiangVienDAO();
    SinhVienDAO svDAO =new  SinhVienDAO();
    
    void quenMatKhau() throws MessagingException {
        String user = txtUserName.getText();
        String ktuser = user.substring(0, 2);
        String email = "";
        if (ktuser.equalsIgnoreCase("GV")) {
            GiangVien gv = gvDAO.selectByID(user);
            if (gv == null) {
                MsgBox.alert(this, "Sai tên đăng nhập!");
            } else {
                email = gv.getEmail();
                String matkhau = matKhauMoi();
                guiMail(email, matkhau);
                gvDAO.update(gv);
                MsgBox.alert(this, "Mật khẩu đã được gửi vào email của bạn!");
            }
        } else if (ktuser.equalsIgnoreCase("NV") || ktuser.equalsIgnoreCase("QL")) {
            NhanVien nv = nvDAO.selectByID(user);
            if (nv == null) {
                MsgBox.alert(this, "Sai tên đăng nhập!");
            } else {
                email = nv.getGmail();
                String matkhau = matKhauMoi();
                guiMail(email, matkhau);
                nv.setMatKhau(matkhau);
                nvDAO.update(nv);
                MsgBox.alert(this, "Mật khẩu đã được gửi vào email của bạn!");
            }
        }else if(ktuser.equalsIgnoreCase("SV")){
            SinhVien sv =  svDAO.selectByID(user);
            if(sv==null){
                 MsgBox.alert(this, "Sai tên đăng nhập!");
            } else {
                email = sv.getEmail();
                String matkhau = matKhauMoi();
                guiMail(email, matkhau);
                sv.setMatKhau(matkhau);
                svDAO.updateQMK(sv);
                MsgBox.alert(this, "Mật khẩu đã được gửi vào email của bạn!");
            }
        }    
        else {
            MsgBox.alert(this, "Sai tên đăng nhập!");
        }
    }

    void guiMail(String Email, String matKhauMoi) throws AddressException, MessagingException {
        try {
            Properties p = new Properties();
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.port", 587);
            String accountName = "trannguyenkhang147@gmail.com";
            String accountPassword = "01627987350a";
            Session s = Session.getInstance(p,
                    new javax.mail.Authenticator() {
                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new javax.mail.PasswordAuthentication(accountName, accountPassword);
                }
            });
            String from = "trannguyenkhang147@gmail.com";
            String to = Email;
            String subject = "Lập trình city";
            String body = "Mật khẩu mới của bạn là: " + matKhauMoi;
            javax.mail.Message msg = new MimeMessage(s);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject(subject);
            msg.setText(body);
            javax.mail.Transport.send(msg);
        } catch (HeadlessException ex) {
            Logger.getLogger(QuenMatKhauFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    String matKhauMoi() {
        Double a = Math.random() * 1000000;
        int b = (int) Math.round(a);
        String chuyen = String.valueOf(b);
        if (chuyen.length() < 6) {
            for (int i = chuyen.length(); i < 6; i++) {
                a = a * 10;
            }
            b = (int) Math.round(a);
            chuyen = String.valueOf(b);
        }
        return chuyen;
    }
}