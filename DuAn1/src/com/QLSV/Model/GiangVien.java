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
public class GiangVien {
    String maGiangVien ;
    String tenGiangVien ;
    String email ;
    String soDienThoai ;
    Date ngaySinh ;
    Date ngayVao ;
    boolean gioiTinh ;
    String anhDaiDien ;
    String trinhDo ;
    String cmnd ;
    String chuyenMon ;
    String diaChi ;
    String matKhau ;
    String manv ;
    
    public GiangVien() {
    }

    public GiangVien(String maGiangVien, String tenGiangVien, String email, String soDienThoai, Date ngaySinh, Date ngayVao, boolean gioiTinh, String anhDaiDien, String trinhDo, String cmnd, String chuyenMon, String diaChi, String matKhau, String manv) {
        this.maGiangVien = maGiangVien;
        this.tenGiangVien = tenGiangVien;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.ngaySinh = ngaySinh;
        this.ngayVao = ngayVao;
        this.gioiTinh = gioiTinh;
        this.anhDaiDien = anhDaiDien;
        this.trinhDo = trinhDo;
        this.cmnd = cmnd;
        this.chuyenMon = chuyenMon;
        this.diaChi = diaChi;
        this.matKhau = matKhau;
        this.manv = manv;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    

    public String getMaGiangVien() {
        return maGiangVien;
    }

    public void setMaGiangVien(String maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public void setTenGiangVien(String tenGiangVien) {
        this.tenGiangVien = tenGiangVien;
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

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNgayVao() {
        return ngayVao;
    }

    public void setNgayVao(Date ngayVao) {
        this.ngayVao = ngayVao;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getAnhDaiDien() {
        return anhDaiDien;
    }

    public void setAnhDaiDien(String anhDaiDien) {
        this.anhDaiDien = anhDaiDien;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    @Override
    public String toString(){
            return this. maGiangVien+ "-" + this.tenGiangVien;
    }
}
