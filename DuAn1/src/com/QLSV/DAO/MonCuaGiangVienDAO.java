/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.DAO;

import com.QLSV.Model.MonCuaGiangVien;
import com.QLSV.Utility.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hi
 */
public class MonCuaGiangVienDAO extends MainDAO<MonCuaGiangVien, Integer>{
    String INSERT_SQL = "INSERT INTO MonCuaGiangVien (maGiangVien, maMon) VALUES (?,?)";
    String UPDATE_SQL = "update MonCuaGiangVien set manganh =? , mamon = ? where idMonCuaGiangVien =?";
    String DELETE_SQL = " delete from MonCuaGiangVien where maGiangVien = ? and mamon = ?";
    String SELECT_ALL_SQL = "select * from MonCuaGiangVien";
    String SELECT_BY_ID_SQL = "select * from MonCuaGiangVien where idMonCuaGiangVien =?";
    
    String spl="select * from MonCuaGiangVien where mamon like ?";
    @Override
    public void insert(MonCuaGiangVien d) {
        JdbcHelper.update(INSERT_SQL, d.getMaGiangVien(), d.getMaMon());
    }

    @Override
    public void update(MonCuaGiangVien d) {
        JdbcHelper.update(UPDATE_SQL,   d.getMaGiangVien(), d.getMaMon(),d.getIdMonCuaGiangVien());
    }


    @Override
    public List<MonCuaGiangVien> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }
    public List<MonCuaGiangVien> sboGiangVien(String mamon) {
        return this.selectBySql(spl,mamon);
    }

    @Override
    protected List<MonCuaGiangVien> selectBySql(String sql, Object... agrs) {
        List<MonCuaGiangVien> list = new ArrayList<MonCuaGiangVien>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                MonCuaGiangVien d = new MonCuaGiangVien();
                d.setIdMonCuaGiangVien(rs.getInt("idMonCuaGiangVien"));
                d.setMaGiangVien(rs.getString("maGiangVien"));
                d.setMaMon(rs.getString("maMon"));
                list.add(d);
            }
            rs.getStatement().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public MonCuaGiangVien selectByID(Integer id) {
        List<MonCuaGiangVien> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    
    public List<MonCuaGiangVien> selectMon(String magv){
        String sql = " select * from moncuagiangvien where magiangvien = ?";
        return this.selectBySql(sql, magv);
    }
    
   
    
    public void deleteGvMh(MonCuaGiangVien d) {
        JdbcHelper.update(DELETE_SQL, d.getMaGiangVien(), d.getMaMon());
    }
}
