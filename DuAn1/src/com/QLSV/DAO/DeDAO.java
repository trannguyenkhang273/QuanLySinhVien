/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.DAO;

import com.QLSV.Model.De;
import com.QLSV.Model.Ky;
import com.QLSV.Utility.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tho
 */
public class DeDAO extends MainDAO<De, String >{
    String INSERT_SQL = "INSERT INTO De (made,mamon,kythi,magiangvien,thoigian,socauhoi,password,ngaymo,ngaydong) VALUES (?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE De SET  mamon = ? , kythi= ?,  magiangvien =?,thoigian = ? ,socauhoi = ?,password = ?,ngaymo=? ,ngaydong = ? where made =?";
    String DELETE_SQL = "delete  De where made =?";
    String SELECT_ALL_SQL = "select * from De";
    String SELECT_BY_ID_SQL = "select * from De where made =?";
    String selectByMon ="select*from de where maMon like ?";
    @Override
    public void insert(De entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaDe(),entity.getMaMon(),entity.getKyThi(),
                entity.getMaGiangVien(),entity.getThoigian(),entity.getSoCauHoi(),
                entity.getPassword(),new java.sql.Date(entity.getNgayMo().getTime()),new java.sql.Date(entity.getNgayDong().getTime()));
    }

    @Override
    public void update(De entity) {
        JdbcHelper.update(UPDATE_SQL,entity.getMaMon(),entity.getKyThi(),entity.getMaGiangVien(),entity.getThoigian()  
                , entity.getSoCauHoi(),entity.getPassword(),new java.sql.Date(entity.getNgayMo().getTime()),new java.sql.Date(entity.getNgayDong().getTime()),entity.getMaDe());
    }

    @Override
    public void delete(String key) {
        JdbcHelper.update(DELETE_SQL,key);
    }

    @Override
    public List<De> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public De selectByID(String key) {
        List<De> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<De> selectBySql(String sql, Object... agrs) {
        List<De> list = new ArrayList<De>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                De entity = new De();
                entity.setMaDe(rs.getString("made"));
                entity.setKyThi(rs.getString("kythi"));
                entity.setMaGiangVien(rs.getString("magiangvien"));
                entity.setMaMon(rs.getString("mamon"));
                entity.setThoigian(rs.getInt("thoigian"));
                entity.setSoCauHoi(rs.getInt("socauhoi"));
                entity.setPassword(rs.getString("password"));
                entity.setNgayDong(rs.getDate("Ngaydong"));
                entity.setNgayMo(rs.getDate("Ngaymo"));
                list.add(entity); 
            }
            rs.getStatement().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
            }    }
    public List<De> selectByMonHoc(String maMon) {
        return this.selectBySql(selectByMon,maMon);
    }

}
