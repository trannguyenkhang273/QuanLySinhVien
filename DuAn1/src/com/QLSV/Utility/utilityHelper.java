/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.Utility;

import com.toedter.calendar.JDateChooser;
import static java.awt.Color.pink;
import static java.awt.Color.white;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Sieu Nhan Bay
 */
public class utilityHelper {


    public static boolean checkPass(JPasswordField txt) {
        txt.setBackground(white);
        if (txt.getPassword().length > 2 && txt.getPassword().length < 17) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), txt.getName() + " phải có từ 3-16 kí tự.");
            return false;
        }
    }
    public static boolean checkNullPass(JPasswordField txt) {
        txt.setBackground(white);
        if (txt.getPassword().length > 0) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }

    public static boolean checkName(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]{3,25}$";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), txt.getName() + " phải là tên tiếng việt hoặc không đấu\ntừ 3-25 kí tự");
            return false;
        }
    }
    public static boolean checkSDT(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "(086|096|097|098|032|033|034|035|036|037|038|039|089|090|093|070|079|077|078|076|088|091|094|083|084|085|081|082|092|056|058|099|059)[0-9]{7}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), txt.getName() + " phải gồm 10 số\nđúng các đầu số của nhà mạng.");
            return false;
        }
    }

    public static boolean checkEmail(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        String rgx = "^[a-zA-Z][a-zA-Z0-9_\\.]{2,32}@[a-zA-Z0-9]{2,10}(\\.[a-zA-Z0-9]{2,4}){1,2}$";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), txt.getName() + " không đúng định dạng");
            return false;
        }
    }

    public static boolean checkNullText(JTextField txt) {
        txt.setBackground(white);
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }
    
     public static boolean CheckNullDate(JDateChooser txt) {
        txt.setBackground(white);
        if (txt.getDate()!=(null)) {
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }
     public static boolean CheckDate(JDateChooser txt, JDateChooser txt1) {
        txt.setBackground(white);
        if (txt.getDate().before(txt1.getDate())){
            return true;
        } else {
            txt.setBackground(pink);
            MsgBox.alert(txt.getRootPane(),txt.getName()+" Không Được Lớn Hơn"+txt1.getName());
            return false;
        }
    }
    public static boolean CheckTrung(JTextField txt, JTable tbl ){
        int tong = tbl.getRowCount();
        txt.setBackground(white);
        for(int i=0;i<tong;i++){
            if(txt.getText().equalsIgnoreCase(tbl.getValueAt(i, 0).toString())){
                txt.setBackground(pink);
                MsgBox.alert(txt.getRootPane(),txt.getName()+" Đã Tồn Tại");
                return false;
            } else {
            }
        }
        return true;  
   }
    public static boolean checkCMND(JTextField txt) {
        txt.setBackground(white);
        try {
             Long.parseLong(txt.getText());
        } catch (Exception e) {
            MsgBox.alert(txt.getRootPane(),txt.getName()+" phải được nhập bằng số");
            return false;
        }
        return true;
    }

}
