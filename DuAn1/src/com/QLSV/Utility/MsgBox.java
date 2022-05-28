/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.Utility;

import java.awt.Component;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Tho
 */
public class MsgBox {
 
    public static void alert(Component parent, String message) {
        URL url = XImage.class.getResource("/imageTest/iconfram.png");
        ImageIcon icon = new ImageIcon(url);
//        Icon icon = 
       JOptionPane.showMessageDialog(parent, message,
       "Hệ thống quản lý đào tạo", JOptionPane.INFORMATION_MESSAGE,icon);
    }
    
    public static boolean confirm(Component parent, String message) {
        URL url = XImage.class.getResource("/imageTest/iconfram.png");
        ImageIcon icon = new ImageIcon(url);
       int result = JOptionPane.showConfirmDialog(parent, message,
       "Hệ thống quản lý đào tạo",
       JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,icon);
       return result == JOptionPane.YES_OPTION;
    }
    
    public static String prompt(Component parent, String message) {
        String[] options = new String[2];
                options[0] = new String("Xem điểm");
                options[1] = new String("Vào thi");
        URL url = XImage.class.getResource("/imageTest/iconfram.png");
        ImageIcon icon = new ImageIcon(url);
       return (String) JOptionPane.showInputDialog(parent, message,
       "Hệ thống quản lý đào tạo", JOptionPane.INFORMATION_MESSAGE,icon,options,options[1]);
    }
}
