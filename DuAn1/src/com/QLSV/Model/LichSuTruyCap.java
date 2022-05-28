/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.Model;

/**
 *
 * @author Tho
 */
public class LichSuTruyCap {
    String masinhvien ;
    String made;
    String now;

   

    public LichSuTruyCap() {
    }

    public String getMasinhvien() {
        return masinhvien;
    }

    public void setMasinhvien(String masinhvien) {
        this.masinhvien = masinhvien;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    public LichSuTruyCap(String masinhvien, String made, String now) {
        this.masinhvien = masinhvien;
        this.made = made;
        this.now = now;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

   

    

   
}
