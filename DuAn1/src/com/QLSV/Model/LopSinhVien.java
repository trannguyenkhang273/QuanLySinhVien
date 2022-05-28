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
public class LopSinhVien {
    int idLopSinhVien;
    String maSinhVien;
    String maLop;

    public LopSinhVien(String maSinhVien, String maLop) {
        this.maSinhVien = maSinhVien;
        this.maLop = maLop;
    }

    public int getIdLopSinhVien() {
        return idLopSinhVien;
    }

    public void setIdLopSinhVien(int idLopSinhVien) {
        this.idLopSinhVien = idLopSinhVien;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public LopSinhVien() {
    }

    public LopSinhVien(int idLopSinhVien, String maSinhVien, String maLop) {
        this.idLopSinhVien = idLopSinhVien;
        this.maSinhVien = maSinhVien;
        this.maLop = maLop;
    }
    
}
