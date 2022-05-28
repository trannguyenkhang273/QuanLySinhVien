/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.Ui;

import com.QLSV.DAO.CauHoiDAO;
import com.QLSV.Model.CauHoi;
import com.QLSV.Model.DapAn;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Tho
 */
public class CauHoiPanel extends javax.swing.JPanel {
    CauHoi cauHoi ;
    List<DapAn> list;
    TabButton btnF;
    CauHoiDAO chdao= new CauHoiDAO();
    /**
     * Creates new form CauHoiPanel
     */
    public CauHoiPanel(CauHoi ch,List<DapAn> listDA,int cauHoiSo,TabButton btn) throws MalformedURLException, IOException, LineUnavailableException, UnsupportedAudioFileException{
        initComponents();
        lblCauHoiSo.setText("Câu hỏi số : "+String.valueOf(cauHoiSo+1)); 
        if(chdao.soDapAn(ch.getMaCauHoi())==1){
            lblNoiDung.setText(ch.getNoiDung()+" (Chọn 1 đáp án)"); 
        }else{
            lblNoiDung.setText(ch.getNoiDung()+" (Chọn nhiều đáp án)"); 
        }
        Collections.shuffle(listDA);
        lblA.setText("A. "+listDA.get(0).getNoiDung());
        lblB.setText("B. "+listDA.get(1).getNoiDung());
        lblC.setText("C. "+listDA.get(2).getNoiDung());
        lblD.setText("D. "+listDA.get(3).getNoiDung());
        cauHoi=ch;
        list=listDA;
        btnF=btn;
        if(ch.getLinkDinhKem().equals("")){
            
        }else{
            if(!ch.getLinkDinhKem().contains("family")){
                    image(ch.getLinkDinhKem());
            }else{
                Sound(ch.getLinkDinhKem()); 
            }
            
        }
    }
    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
    Clip clip;
    void image(String pec)throws MalformedURLException, IOException, LineUnavailableException, UnsupportedAudioFileException{
        URL url = new URL(pec);
        Image image = ImageIO.read(url);
        JLabel lblAnh =new JLabel();
        lblAnh.setBounds(0, 0, 630, 420);
        lblAnh.setIcon(new ImageIcon(getScaledImage(image,630,420)));
        panelLinkKem.add(lblAnh);
        panelLinkKem.repaint();
    }
    void Sound(String pec) throws MalformedURLException, LineUnavailableException, UnsupportedAudioFileException, IOException{
        URL url = new URL(pec);
        clip = AudioSystem.getClip();
        AudioInputStream ais = AudioSystem.getAudioInputStream( url );
        AudioFormat format = ais.getFormat();
        AudioFormat newFormat=new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,format.getSampleRate(),16, format.getChannels(),    format.getChannels() * 2,   format.getSampleRate(),    false);
         ais = AudioSystem.getAudioInputStream( newFormat, ais);
        clip.open(ais); 
        JButton btn =new JButton("Play");
        btn.setIcon(new ImageIcon(getClass().getResource("/com/QLSV/Icon/play_30px.png"))); 
        btn.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btn.setBounds(100, 50, 120, 50); 
        panelLinkKem.add(btn);
        panelLinkKem.repaint();
        btn.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                clip.start();
                clip.loop(2);
                btn.setEnabled(false);
            }
        });
//        clip.loop(2); 
    }
    boolean trueFalse(){
        String dapAn ="";
        for(DapAn d:list){
            if(d.isDapAn()){
                dapAn+="T";
            }else{
                dapAn+="F";
            }
        }
        String cauTraLoi ="";
        if(chkA.isSelected()){
            cauTraLoi+="T";
        }else{
            cauTraLoi+="F";
        }
        
        if(chkB.isSelected()){
            cauTraLoi+="T";
        }else{
            cauTraLoi+="F";
        }
        if(chkC.isSelected()){
            cauTraLoi+="T";
        }else{
            cauTraLoi+="F";
        }
        if(chkD.isSelected()){
            cauTraLoi+="T";
        }else{
            cauTraLoi+="F";
        }
        if(dapAn.equals(cauTraLoi)){
            return true;
        }else{
            return false;
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

        panelHoi = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        chkA = new javax.swing.JCheckBox();
        chkB = new javax.swing.JCheckBox();
        chkD = new javax.swing.JCheckBox();
        chkC = new javax.swing.JCheckBox();
        panelNoiDung = new javax.swing.JPanel();
        lblNoiDung = new javax.swing.JLabel();
        lblCauHoiSo = new javax.swing.JLabel();
        lblB = new javax.swing.JLabel();
        lblA = new javax.swing.JLabel();
        lblC = new javax.swing.JLabel();
        lblD = new javax.swing.JLabel();
        panelLinkKem = new javax.swing.JPanel();

        panelHoi.setBackground(new java.awt.Color(255, 255, 255));
        panelHoi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Đáp án :");

        chkA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chkA.setText("A");
        chkA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAActionPerformed(evt);
            }
        });

        chkB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chkB.setText("B");
        chkB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBActionPerformed(evt);
            }
        });

        chkD.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chkD.setText("D");
        chkD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDActionPerformed(evt);
            }
        });

        chkC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chkC.setText("C");
        chkC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHoiLayout = new javax.swing.GroupLayout(panelHoi);
        panelHoi.setLayout(panelHoiLayout);
        panelHoiLayout.setHorizontalGroup(
            panelHoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHoiLayout.createSequentialGroup()
                .addGroup(panelHoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHoiLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1))
                    .addGroup(panelHoiLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(panelHoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(chkB)
                            .addComponent(chkA)
                            .addComponent(chkC)
                            .addComponent(chkD))))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        panelHoiLayout.setVerticalGroup(
            panelHoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHoiLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(57, 57, 57)
                .addComponent(chkA)
                .addGap(33, 33, 33)
                .addComponent(chkB)
                .addGap(31, 31, 31)
                .addComponent(chkC)
                .addGap(31, 31, 31)
                .addComponent(chkD)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelNoiDung.setBackground(new java.awt.Color(255, 255, 255));
        panelNoiDung.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNoiDung.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblNoiDung.setText("Nội dung cau hỏi");

        lblCauHoiSo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCauHoiSo.setText("Cau hỏi số :");

        lblB.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblB.setText("B.Câu trả lời 2");

        lblA.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblA.setText("A.Câu trả lời 1");

        lblC.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblC.setText("C.Câu trả lời 3");

        lblD.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblD.setText("D.Câu trả lời 4");

        panelLinkKem.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelLinkKemLayout = new javax.swing.GroupLayout(panelLinkKem);
        panelLinkKem.setLayout(panelLinkKemLayout);
        panelLinkKemLayout.setHorizontalGroup(
            panelLinkKemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );
        panelLinkKemLayout.setVerticalGroup(
            panelLinkKemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelNoiDungLayout = new javax.swing.GroupLayout(panelNoiDung);
        panelNoiDung.setLayout(panelNoiDungLayout);
        panelNoiDungLayout.setHorizontalGroup(
            panelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNoiDungLayout.createSequentialGroup()
                .addGroup(panelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelNoiDungLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(panelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                                .addComponent(lblD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(20, 20, 20)
                        .addComponent(panelLinkKem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelNoiDungLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblCauHoiSo)))
                .addContainerGap())
        );
        panelNoiDungLayout.setVerticalGroup(
            panelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNoiDungLayout.createSequentialGroup()
                .addGroup(panelNoiDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelNoiDungLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelLinkKem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelNoiDungLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblCauHoiSo)
                        .addGap(36, 36, 36)
                        .addComponent(lblNoiDung)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                        .addComponent(lblA)
                        .addGap(64, 64, 64)
                        .addComponent(lblB)
                        .addGap(61, 61, 61)
                        .addComponent(lblC)
                        .addGap(70, 70, 70)
                        .addComponent(lblD)))
                .addGap(87, 87, 87))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelHoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelNoiDung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelNoiDung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chkDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDActionPerformed
        checkCheck();        // TODO add your handling code here:
    }//GEN-LAST:event_chkDActionPerformed

    private void chkAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAActionPerformed
        checkCheck();
    }//GEN-LAST:event_chkAActionPerformed

    private void chkBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBActionPerformed
        checkCheck();        // TODO add your handling code here:
    }//GEN-LAST:event_chkBActionPerformed

    private void chkCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCActionPerformed
        checkCheck();        // TODO add your handling code here:
    }//GEN-LAST:event_chkCActionPerformed
    void checkCheck(){
        if(chkA.isSelected()){
            btnF.setBackground(Color.GREEN);
            return;
        }
        if(chkB.isSelected()){
            btnF.setBackground(Color.GREEN);
            return;
        }
        if(chkC.isSelected()){
            btnF.setBackground(Color.GREEN);
            return;
        }
        if(chkD.isSelected()){
            btnF.setBackground(Color.GREEN);
            return;
        }
        btnF.setBackground(new Color(230,230,230));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkA;
    private javax.swing.JCheckBox chkB;
    private javax.swing.JCheckBox chkC;
    private javax.swing.JCheckBox chkD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblA;
    private javax.swing.JLabel lblB;
    private javax.swing.JLabel lblC;
    private javax.swing.JLabel lblCauHoiSo;
    private javax.swing.JLabel lblD;
    private javax.swing.JLabel lblNoiDung;
    private javax.swing.JPanel panelHoi;
    private javax.swing.JPanel panelLinkKem;
    private javax.swing.JPanel panelNoiDung;
    // End of variables declaration//GEN-END:variables
}
