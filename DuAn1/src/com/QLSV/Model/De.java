/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.Model;

import java.util.Date;



/**
 *
 * @author Tho
 */
public class De {
    int thoigian,soCauHoi ;
    String maMon,kyThi,maGiangVien,password,maDe;
    Date ngayMo,ngayDong;
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getThoigian() {
        return thoigian;
    }

    public void setThoigian(int thoigian) {
        this.thoigian = thoigian;
    }

    public int getSoCauHoi() {
        return soCauHoi;
    }

    public void setSoCauHoi(int soCauHoi) {
        this.soCauHoi = soCauHoi;
    }

    public De() {
    }

    public De(int thoigian, int soCauHoi, String maMon, String kyThi, String maGiangVien, String password, String maDe, Date ngayMo, Date ngayDong) {
        this.thoigian = thoigian;
        this.soCauHoi = soCauHoi;
        this.maMon = maMon;
        this.kyThi = kyThi;
        this.maGiangVien = maGiangVien;
        this.password = password;
        this.maDe = maDe;
        this.ngayMo = ngayMo;
        this.ngayDong = ngayDong;
    }

    public Date getNgayMo() {
        return ngayMo;
    }

    public void setNgayMo(Date ngayMo) {
        this.ngayMo = ngayMo;
    }

    public Date getNgayDong() {
        return ngayDong;
    }

    public void setNgayDong(Date ngayDong) {
        this.ngayDong = ngayDong;
    }

   

    public String getMaDe() {
        return maDe;
    }

    public void setMaDe(String maDe) {
        this.maDe = maDe;
    }


    

 

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getKyThi() {
        return kyThi;
    }

    public void setKyThi(String kyThi) {
        this.kyThi = kyThi;
    }

    public String getMaGiangVien() {
        return maGiangVien;
    }

    public void setMaGiangVien(String maGiangVien) {
        this.maGiangVien = maGiangVien;
    }
    
}
