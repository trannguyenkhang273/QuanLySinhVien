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
public class DapAn {
    String maCauHoi;
    String noiDung;
    boolean dapAn;

    

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public boolean isDapAn() {
        return dapAn;
    }

    public void setDapAn(boolean dapAn) {
        this.dapAn = dapAn;
    }

    public DapAn(String maCauHoi, String noiDung, boolean dapAn) {
        this.maCauHoi = maCauHoi;
        this.noiDung = noiDung;
        this.dapAn = dapAn;
    }

    public String getMaCauHoi() {
        return maCauHoi;
    }

    public void setMaCauHoi(String maCauHoi) {
        this.maCauHoi = maCauHoi;
    }

    

    public DapAn() {
    }
}
