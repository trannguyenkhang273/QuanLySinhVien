/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.DAO;

import com.QLSV.Model.DanhSachThi;
import com.QLSV.Model.DanhSachThi;
import com.QLSV.Model.De;
import com.QLSV.Utility.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hieup
 */
    public class DanhSachThiDAO extends MainDAO<DanhSachThi, String>{
    
    String INSERT_SQL = "INSERT INTO danhSachThi (masinhvien,made) VALUES (?,?)";
    String UPDATE_SQL = "UPDATE danhSachThi SET  made=? where masinhvien =?";
    String DELETE_SQL = "delete from danhSachThi where masinhvien =?";
    String SELECT_ALL_SQL = "select * from danhSachThi";
    String SELECT_BY_ID_SQL = "select * from danhSachThi where masinhvien=?";
    String checkDanhSach="select *from danhsachthi where masinhvien like ? and made like ?";
    @Override
    public void insert(DanhSachThi entity) {
       JdbcHelper.update(INSERT_SQL, entity.getMaSinhVien(),entity.getMaDe());
    }

    @Override
    public void update(DanhSachThi entity) {
        JdbcHelper.update(UPDATE_SQL,entity.getMaDe(),entity.getMaSinhVien());
    }

    @Override
    public void delete(String key) {
        JdbcHelper.update(DELETE_SQL,key);
    }

    @Override
    public List<DanhSachThi> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }
    public List<DanhSachThi> selectByMon(String maMon) {
        String sql ="select *from danhsachthi where made in(select made from de where mamon = ?)";
        return this.selectBySql(sql,maMon);
    }
    @Override
    public DanhSachThi selectByID(String key) {
        List<DanhSachThi> list = this.selectBySql(SELECT_BY_ID_SQL,key);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<DanhSachThi> selectBySql(String sql, Object... agrs) {
        List<DanhSachThi> list = new ArrayList<DanhSachThi>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                DanhSachThi entity = new DanhSachThi();
                entity.setMaSinhVien(rs.getString("masinhvien"));
                entity.setMaDe(rs.getString("made"));
                list.add(entity);
            }
            rs.getStatement().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
            }    
    }
    public List<DanhSachThi> checkDanhSach(String masv ,String maDe) {
        return this.selectBySql(checkDanhSach,masv,maDe);
    }
    
    
}
    
