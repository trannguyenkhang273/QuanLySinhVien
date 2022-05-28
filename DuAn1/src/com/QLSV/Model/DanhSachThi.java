/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.Model;

import java.util.Date;

/**
 *
 * @author hieup
 */
public class DanhSachThi {
    String maSinhVien ;
    String maDe ;

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getMaDe() {
        return maDe;
    }

    public void setMaDe(String maDe) {
        this.maDe = maDe;
    }

    public DanhSachThi() {
    }

    public DanhSachThi(String maSinhVien, String maDe) {
        this.maSinhVien = maSinhVien;
        this.maDe = maDe;
    }
    
    
}
