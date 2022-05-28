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
public class MonHoc {
    String maMon ;
    String tenMon ; 
    String moTa ;
    String anhDaiDien ;

    public MonHoc() {
    }

    public MonHoc(String maMon, String tenMon, String moTa, String anhDaiDien) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.moTa = moTa;
        this.anhDaiDien = anhDaiDien;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getAnhDaiDien() {
        return anhDaiDien;
    }

    public void setAnhDaiDien(String anhDaiDien) {
        this.anhDaiDien = anhDaiDien;
    }
    
    
}

