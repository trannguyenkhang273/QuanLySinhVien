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
public class MonHocCuaNganh {
    int idMonHocCuaNganh;
    String maNganh ;
    String maMon ;
    int maky; 

    public MonHocCuaNganh(int idMonHocCuaNganh, String maNganh, String maMon, int maky) {
        this.idMonHocCuaNganh = idMonHocCuaNganh;
        this.maNganh = maNganh;
        this.maMon = maMon;
        this.maky = maky;
    }

    public int getMaky() {
        return maky;
    }

    public void setMaky(int maky) {
        this.maky = maky;
    }
    
    public MonHocCuaNganh() {
    }

   

    public int getIdMonHocCuaNganh() {
        return idMonHocCuaNganh;
    }

    public void setIdMonHocCuaNganh(int idMonHocCuaNganh) {
        this.idMonHocCuaNganh = idMonHocCuaNganh;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }
    
}
