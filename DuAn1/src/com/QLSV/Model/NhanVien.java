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
public class NhanVien {
    String maNV ;
    String matKhau ;
    String tenNhanVien ;
    String gmail ;
    boolean vaitro ;

    public NhanVien() {
    }

    public NhanVien(String maNV, String matKhau, String tenNhanVien, String gmail, boolean vaitro) {
        this.maNV = maNV;
        this.matKhau = matKhau;
        this.tenNhanVien = tenNhanVien;
        this.gmail = gmail;
        this.vaitro = vaitro;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public boolean isVaitro() {
        return vaitro;
    }

    public void setVaitro(boolean vaitro) {
        this.vaitro = vaitro;
    }
    
    
}
