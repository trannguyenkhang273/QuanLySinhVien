/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.DAO;

import com.QLSV.Model.MonHocCuaNganh;
import com.QLSV.Utility.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hi
 */
public class MonHocCuaNganhDAO extends MainDAO<MonHocCuaNganh, Integer>{
    String INSERT_SQL = "INSERT INTO MonHocCuaNganh (maNganh, maMon,maky) VALUES (?,?,?)";
    String UPDATE_SQL = "UPDATE MonHocCuaNganh SET maNganh =?, maMon = ?,maky = ? where idMonHocCuaNganh =?";
    String DELETE_SQL = "delete from MonHocCuaNganh where manganh =? and mamon= ? and maky=?";
    String SELECT_ALL_SQL = "select * from MonHocCuaNganh";
    String SELECT_BY_ID_SQL = "select * from MonHocCuaNganh where idMonHocCuaNganh =?";
    
    String sql ="select distinct maky from MonHocCuaNganh  where maky>= (select maky from lop where malop =?) and maNganh = (select maNganh from lop where malop  = ?)";
    String sqlcboKy="select *from MonHocCuaNganh where maMon like ? and maNganh in (select maNganh from lop where malop like ?)";
    String sqlThem="select distinct maky from MonHocCuaNganh where manganh like ?";
    @Override
    public void insert(MonHocCuaNganh d) {
        JdbcHelper.update(INSERT_SQL, d.getMaNganh(), d.getMaMon(),d.getMaky());
    }

    @Override
    public void update(MonHocCuaNganh d) {
        JdbcHelper.update(UPDATE_SQL,   d.getMaNganh(), d.getMaMon(),d.getIdMonHocCuaNganh());
    }


    @Override
    public List<MonHocCuaNganh> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }


    @Override
    protected List<MonHocCuaNganh> selectBySql(String sql, Object... agrs) {
        List<MonHocCuaNganh> list = new ArrayList<MonHocCuaNganh>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                MonHocCuaNganh d = new MonHocCuaNganh();
                d.setIdMonHocCuaNganh(rs.getInt("idMonHocCuaNganh"));
                d.setMaNganh(rs.getString("maNganh"));
                d.setMaMon(rs.getString("maMon"));
                d.setMaky(rs.getInt("maky"));
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
    public MonHocCuaNganh selectByID(Integer id) {
        List<MonHocCuaNganh> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    
    public List<MonHocCuaNganh> selectnganh(String manganh,Integer maky){
        String sql = " select * from monhoccuanganh where manganh = ? and maky = ? ";
        return this.selectBySql(sql, manganh,maky);
    }
    
   
    
    public void deleteMcN(MonHocCuaNganh d) {
        JdbcHelper.update(DELETE_SQL, d.getMaNganh(), d.getMaMon(),d.getMaky());
    }
    protected List<MonHocCuaNganh> selectNew(String sql, Object... agrs) {
        List<MonHocCuaNganh> list = new ArrayList<MonHocCuaNganh>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                MonHocCuaNganh d = new MonHocCuaNganh();
                d.setIdMonHocCuaNganh(0);
                d.setMaNganh("0");
                d.setMaMon("0");
                d.setMaky(rs.getInt("maky"));
                list.add(d);
            }
            rs.getStatement().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<MonHocCuaNganh> cboKy(String maLop) {
        return this.selectNew(sql,maLop,maLop);
    }
    public List<MonHocCuaNganh> cboKy(String maMon,String maLop) {
        return this.selectBySql(sqlcboKy,maMon,maLop);
    }
    public List<MonHocCuaNganh> cboThem(String maNganh) {
        return this.selectNew(sqlThem,maNganh);
    }
}
