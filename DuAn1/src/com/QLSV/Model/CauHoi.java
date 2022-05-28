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
public class CauHoi {
    
    String noiDung,maCauHoi,maDe,linkDinhKem;

    public CauHoi() {
    }

    public CauHoi(String noiDung, String maCauHoi, String maDe, String linkDinhKem) {
        this.noiDung = noiDung;
        this.maCauHoi = maCauHoi;
        this.maDe = maDe;
        this.linkDinhKem = linkDinhKem;
    }

    public String getLinkDinhKem() {
        return linkDinhKem;
    }

    public void setLinkDinhKem(String linkDinhKem) {
        this.linkDinhKem = linkDinhKem;
    }

   

    public String getMaCauHoi() {
        return maCauHoi;
    }

    public void setMaCauHoi(String maCauHoi) {
        this.maCauHoi = maCauHoi;
    }

    

    

    public String getMaDe() {
        return maDe;
    }

    public void setMaDe(String maDe) {
        this.maDe = maDe;
    }

    

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
    
}
