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
public class Diem {
   int idDiem ;
    String maSinhVien ;
    String maMon ;
    float diemChuyenCan ;
    float diemGiuaKi ;
    float diemCuoiKi ;
    String trangThai ;
    String tenSV ;
    
    public Diem() {
    }

    public Diem(int idDiem, String maSinhVien, String maMon, float diemChuyenCan, float diemGiuaKi, float diemCuoiKi, String trangThai, String tenSV) {
        this.idDiem = idDiem;
        this.maSinhVien = maSinhVien;
        this.maMon = maMon;
        this.diemChuyenCan = diemChuyenCan;
        this.diemGiuaKi = diemGiuaKi;
        this.diemCuoiKi = diemCuoiKi;
        this.trangThai = trangThai;
        this.tenSV = tenSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

   

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

   

    public void setIdDiem(int idDiem) {
        this.idDiem = idDiem;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public void setDiemChuyenCan(float diemChuyenCan) {
        this.diemChuyenCan = diemChuyenCan;
    }

    public void setDiemGiuaKi(float diemGiuaKi) {
        this.diemGiuaKi = diemGiuaKi;
    }

    public void setDiemCuoiKi(float diemCuoiKi) {
        this.diemCuoiKi = diemCuoiKi;
    }

    public int getIdDiem() {
        return idDiem;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public String getMaMon() {
        return maMon;
    }

    public float getDiemChuyenCan() {
        return diemChuyenCan;
    }

    public float getDiemGiuaKi() {
        return diemGiuaKi;
    }

    public float getDiemCuoiKi() {
        return diemCuoiKi;
    }

    
}
