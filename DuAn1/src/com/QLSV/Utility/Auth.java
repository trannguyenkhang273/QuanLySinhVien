/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.Utility;

import com.QLSV.Model.GiangVien;
import com.QLSV.Model.NhanVien;
import com.QLSV.Model.SinhVien;




public class Auth {

     public static NhanVien USER = null;
    
    public static void clear() {
        Auth.USER = null;
    }
    public static GiangVien USERGV = null;
    public static SinhVien USERSV = null;

    public static boolean isLogin(){
        return Auth.USER != null;
    }
    
    public static boolean isManager(){
        return Auth.isLogin()&& USER.isVaitro();
    }
    
    public static boolean isLoginGV(){
        return Auth.USERGV != null;
    }
    
}

