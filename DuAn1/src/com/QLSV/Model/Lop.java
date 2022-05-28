/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.Model;

/**
 *
 * @author hi
 */
public class Lop {
    String maLop ;
    String maNganh ;
    int maky;
    
    
    public Lop() {
    }

    public Lop(String maLop, String maNganh, int maky) {
        this.maLop = maLop;
        this.maNganh = maNganh;
        this.maky = maky;
    }

    public int getMaky() {
        return maky;
    }

    public void setMaky(int maky) {
        this.maky = maky;
    }



    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }
    
}
