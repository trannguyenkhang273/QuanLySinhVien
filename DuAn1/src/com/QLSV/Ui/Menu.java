package com.QLSV.Ui;

import com.QLSV.DAO.GiangVienDAO;
import com.QLSV.DAO.NhanVienDAO;
import com.QLSV.DAO.SinhVienDAO;
import com.QLSV.Model.GiangVien;
import com.QLSV.Model.NhanVien;
import com.QLSV.Model.SinhVien;
import com.QLSV.Utility.Auth;
import com.QLSV.Utility.MsgBox;
import com.QLSV.Utility.XImage;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu extends javax.swing.JFrame implements Runnable, ThreadFactory {

    private WebcamPanel panel = null;
    private Webcam webcam = null;

    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    public Menu() {
        initComponents();
        initWebcam();this.setIconImage(XImage.getAppIcon());
    }
    NhanVienDAO nvDAO = new NhanVienDAO();
    GiangVienDAO gvDAO = new GiangVienDAO();
    SinhVienDAO svDAO = new SinhVienDAO();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 470, 320));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 350));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0); //0 is default webcam
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 300));

        executor.execute(this);
    }
    public void QR() throws IOException{
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                //No result...
            }

            if (result != null) {
                String full= result.getText();
            String ma = full.substring(0,full.indexOf("-"));
            int index = full.indexOf("-");
            String mk= full.substring(index+1);
            String user = ma;
            String ktuser = user.substring(0, 2);
            if (ktuser.equalsIgnoreCase("GV")) {
                GiangVien gv = gvDAO.selectByID(user);
                if (gv == null) {
                    MsgBox.alert(this, "Mã QR Không Tồn Tại");
                } else if (!mk.equals(gv.getMatKhau())) {
                    MsgBox.alert(this, "Mã QR Không Tồn Tại");
                } else {
                    Auth.USERGV = gv;
                    this.dispose();
                     NhapDiemFrame gdc = new NhapDiemFrame();
                    gdc.setVisible(true);;

                }
            } else if (ktuser.equalsIgnoreCase("NV") || ktuser.equalsIgnoreCase("QL")) {
                NhanVien nv = nvDAO.selectByID(user);
                if (nv == null) {
                    MsgBox.alert(this, "Mã QR Không Tồn Tại");
                } else if (!mk.equals(nv.getMatKhau())) {
                    MsgBox.alert(this, "Mã QR Không Tồn Tại");
                } else {
                    Auth.USER = nv;
                    this.dispose();
                    GiaoDienChinh gdc = new GiaoDienChinh();
                    gdc.setVisible(true);
                }
            }
              else if(ktuser.equalsIgnoreCase("SV")){
                SinhVien sv =  svDAO.selectByID(user);
                if(sv==null){
                    MsgBox.alert(this, "Mã QR Không Tồn Tại");
                }else if (!mk.equals(sv.getMatKhau())) {
                    MsgBox.alert(this, "Mã QR Không Tồn Tại");
                } else {
                    Auth.USERSV = sv;
                    this.dispose();
                    BangDiemFrame gdc = new BangDiemFrame();
                    gdc.setVisible(true);
                }

            }
                }
            } while (true);
    }

    @Override
    public void run() {
        try {
            QR();
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
}
