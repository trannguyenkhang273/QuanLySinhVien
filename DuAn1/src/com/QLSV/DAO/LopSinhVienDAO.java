/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.DAO;

import com.QLSV.Model.GiangVien;
import com.QLSV.Model.LopSinhVien;
import com.QLSV.Utility.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tho
 */
public class LopSinhVienDAO extends MainDAO<LopSinhVien,Integer>{
    String INSERT_SQL = "INSERT INTO LopSinhVien (maLop , maSinhVien) VALUES (?,?)";
    String UPDATE_SQL = "update LopSinhVien set maLop =? , maSinhVien = ? where idLopSinhVien =?";
    String DELETE_SQL = "delete from LopSinhVien where idLopSinhVien =?";
    String SELECT_ALL_SQL = "select * from LopSinhVien"; 
    String SELECT_BY_ID_SQL = "select * from LopSinhVien where idLopSinhVien =?";
    String outLop="delete from LopSinhVien where maLop =? and masinhvien =?";
    String doitrangthai = "UPDATE diem SET  trangthai = N'Đậu(2)' where trangthai = N'Đậu(1)' or trangthai = N'Đậu' and maMon in (select maMon from MonHocCuaNganh where MaKy in(select MaKy from lop where maLop =?))";
    String outlop = "delete from LopSinhVien where maLop = ? and maSinhVien in (select maSinhvien from diem where trangthai = N'Rớt(1)' or trangthai = N'Đậu(1)')";
    @Override
    public void insert(LopSinhVien entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaLop(),entity.getMaSinhVien());
    }
    public void delete(String maLop) {
        JdbcHelper.update(outlop, maLop);
    }
    @Override
    public void update(LopSinhVien entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getMaLop(),entity.getMaSinhVien(),entity.getIdLopSinhVien());
    }


    @Override
    public List<LopSinhVien> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }
    public void delete(String maLop,String maSV) {
        JdbcHelper.update(outLop, maLop,maSV);
    }
  
    @Override
    protected List<LopSinhVien> selectBySql(String sql, Object... agrs) {
        List<LopSinhVien> list = new ArrayList<LopSinhVien>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                LopSinhVien d = new LopSinhVien();
                d.setIdLopSinhVien(rs.getInt("idLopSinhVien"));
                d.setMaLop(rs.getString("MaLop"));
                d.setMaSinhVien(rs.getString("masinhvien"));
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
        JdbcHelper.update(UPDATE_SQL, key);
    }

    @Override
    public LopSinhVien selectByID(Integer key) {
        List<LopSinhVien> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    public void doitrangthai(String maLop) {
        JdbcHelper.update(doitrangthai, maLop);
    }
}
