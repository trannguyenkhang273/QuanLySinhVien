package com.QLSV.Ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TabButton extends JButton {
    List<CauHoiPanel> listPanel;
    int i;
    public TabButton(int cauHoiSo,List<CauHoiPanel> list) {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPanel(cauHoiSo);
            }
        }); 
        i=cauHoiSo;
        listPanel=list;
     
    }
    public void showPanel(int index){
        for (int i = 0; i < listPanel.size(); i++) {
            listPanel.get(i).show(false);
            if(i==index){
                listPanel.get(index).show(true);
            }
        } 
    }
     
    
    
}
