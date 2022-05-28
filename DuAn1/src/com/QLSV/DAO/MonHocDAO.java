/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.DAO;

import com.QLSV.Model.MonHoc;
import com.QLSV.Utility.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hi
 */
public class  MonHocDAO extends MainDAO<MonHoc, String>{
    String INSERT_SQL = "INSERT INTO monHoc (maMon, tenMon, mota, anhDaidien)VALUES (?,?,?,?)";
    String UPDATE_SQL = "UPDATE monHoc SET  tenMon =?, mota =?, anhDaidien =? where maMon =?";
    String DELETE_SQL = "delete from monhoc where maMon =?";
    String SELECT_ALL_SQL = "select * from monhoc ";
    String SELECT_BY_ID_SQL = "select * from monhoc where maMon =?";

    String sqlcboMon="select * from monhoc mh where mh.maMon in (select maMon from MonHocCuaNganh where maky = ? and manganh  in (select maNganh from lop where malop =?) )";
    String cboThem="select * from monhoc mh where mh.maMon in (select maMon from MonHocCuaNganh where maky = ? and manganh like ?)";
    @Override
    public void insert(MonHoc d) {
        JdbcHelper.update(INSERT_SQL, d.getMaMon(), d.getTenMon(), d.getMoTa(), d.getAnhDaiDien());
    }

    @Override
    public void update(MonHoc d) {
        JdbcHelper.update(UPDATE_SQL,    d.getTenMon(), d.getMoTa(), d.getAnhDaiDien(),d.getMaMon());
    }


    @Override
    public List<MonHoc> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }


    @Override
    protected List<MonHoc> selectBySql(String sql, Object... agrs) {
        List<MonHoc> list = new ArrayList<MonHoc>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                MonHoc d = new MonHoc();
                d.setMaMon(rs.getString("maMon"));
                d.setTenMon(rs.getString("tenMon"));
                d.setMoTa(rs.getString("mota"));
                d.setAnhDaiDien(rs.getString("anhDaidien"));
                list.add(d);
            }
            rs.getStatement().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String key) {
        JdbcHelper.update(DELETE_SQL, key);
 }

    @Override
    public MonHoc selectByID(String id) {
        List<MonHoc> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    
    public List<MonHoc> selectNotInCourse(String mamon){
        String sql = "select * from Monhoc "
                + " where mamon not in(select mamon from moncuagiangvien where magiangvien = ?) ";
        return this.selectBySql(sql,mamon);
    }
    
    public List<MonHoc> selectInCourse(String magv){
        String sql = "select * from Monhoc where mamon = ?";
        return this.selectBySql(sql,magv);
    }
    
    public List<MonHoc> selectNotInNganh(String manganh,int maky){
        String sql = "select * from Monhoc "
                + " where mamon not in(select mamon from monhoccuanganh where manganh = ? and maky = ?) ";
        return this.selectBySql(sql,manganh,maky);
    }
    public List<MonHoc> cboMon(int maKy,String maLop) {
        return this.selectBySql(sqlcboMon,maKy,maLop);
    }
    public List<MonHoc> cboThem(int maKy,String maNganh) {
        return this.selectBySql(cboThem,maKy,maNganh);
    }
}
