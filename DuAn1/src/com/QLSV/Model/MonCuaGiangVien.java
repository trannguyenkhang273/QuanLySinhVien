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
public class MonCuaGiangVien {
    int idMonCuaGiangVien ;
    String maGiangVien ;
    String maMon ;

    public MonCuaGiangVien() {
    }

    public MonCuaGiangVien(int idMonCuaGiangVien, String maGiangVien, String maMon) {
        this.idMonCuaGiangVien = idMonCuaGiangVien;
        this.maGiangVien = maGiangVien;
        this.maMon = maMon;
    }

    public int getIdMonCuaGiangVien() {
        return idMonCuaGiangVien;
    }

    public void setIdMonCuaGiangVien(int idMonCuaGiangVien) {
        this.idMonCuaGiangVien = idMonCuaGiangVien;
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
    
}
