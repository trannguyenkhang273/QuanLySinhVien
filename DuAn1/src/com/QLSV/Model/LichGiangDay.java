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
public class LichGiangDay {
    private int idLichGiangDay  ;
    private String maGiangVien ;
    private String maMon;
    private String maLop ;

    public int getIdLichGiangDay() {
        return idLichGiangDay;
    }

    public void setIdLichGiangDay(int idLichGiangDay) {
        this.idLichGiangDay = idLichGiangDay;
    }

    public String getMaGiangVien() {
        return maGiangVien;
    }

    public void setMaGiangVien(String maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public LichGiangDay(int idLichGiangDay, String maGiangVien, String maMon, String maLop) {
        this.idLichGiangDay = idLichGiangDay;
        this.maGiangVien = maGiangVien;
        this.maMon = maMon;
        this.maLop = maLop;
    }

    public LichGiangDay() {
    }
    
    
}
