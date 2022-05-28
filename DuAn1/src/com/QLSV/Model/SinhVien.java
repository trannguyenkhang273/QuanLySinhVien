/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.Model;

import java.util.Date;

/**
 *
 * @author hi
 */
public class SinhVien {
    String maSinhVien ;
    String tenSinhVien ;
    boolean gioiTinh ;
    Date ngaySinh ;
    Date ngayNhapHoc ;
    Date ngayTotNgiep ;
    String email ;
    String soDienThoai ;
    String cmnd ;
    String anhDaiDien ;
    boolean tinhTrang ;
    String tenNganh ;
    String matKhau ;
    String maNV ;

    public SinhVien() {
    }

    public SinhVien(String maSinhVien, String tenSinhVien, boolean gioiTinh, Date ngaySinh, Date ngayNhapHoc, Date ngayTotNgiep, String email, String soDienThoai, String cmnd, String anhDaiDien, boolean tinhTrang, String tenNganh, String matKhau, String maNV) {
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.ngayNhapHoc = ngayNhapHoc;
        this.ngayTotNgiep = ngayTotNgiep;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.cmnd = cmnd;
        this.anhDaiDien = anhDaiDien;
        this.tinhTrang = tinhTrang;
        this.tenNganh = tenNganh;
        this.matKhau = matKhau;
        this.maNV = maNV;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNgayNhapHoc() {
        return ngayNhapHoc;
    }

    public void setNgayNhapHoc(Date ngayNhapHoc) {
        this.ngayNhapHoc = ngayNhapHoc;
    }

    public Date getNgayTotNgiep() {
        return ngayTotNgiep;
    }

    public void setNgayTotNgiep(Date ngayTotNgiep) {
        this.ngayTotNgiep = ngayTotNgiep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getAnhDaiDien() {
        return anhDaiDien;
    }

    public void setAnhDaiDien(String anhDaiDien) {
        this.anhDaiDien = anhDaiDien;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    
    
    
}
