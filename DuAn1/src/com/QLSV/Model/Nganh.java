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
public class Nganh {
    String maNganh ;
    String tenNganh ;
    String moTa ;


    
    public Nganh() {
    }

    public Nganh(String maNganh, String tenNganh, String moTa) {
        this.maNganh = maNganh;
        this.tenNganh = tenNganh;
        this.moTa = moTa;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }
    
    @Override
    public String toString(){
            return this. maNganh+ "-" + this.tenNganh;
    }
    
    
}
