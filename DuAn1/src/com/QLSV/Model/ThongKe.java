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
public class ThongKe {
    String tennganh ;
    int solong ;

    public ThongKe() {
    }

    public ThongKe(String tennganh, int solong) {
        this.tennganh = tennganh;
        this.solong = solong;
    }

    public String getTennganh() {
        return tennganh;
    }

    public void setTennganh(String tennganh) {
        this.tennganh = tennganh;
    }

    public int getSolong() {
        return solong;
    }

    public void setSolong(int solong) {
        this.solong = solong;
    }
    
}
