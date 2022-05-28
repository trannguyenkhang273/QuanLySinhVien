/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.DAO;

import com.QLSV.Model.LichGiangDay;
import com.QLSV.Utility.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hi
 */
public class LichGiangDayDAO extends MainDAO<LichGiangDay, Integer>{
    String INSERT_SQL = "INSERT INTO LichGiangDay(maLop,maGiangVien,maMon)  VALUES (?,?,?)";
    String UPDATE_SQL = "UPDATE LichGiangDay SET  maLop = ? , maGiangVien =? ,mamon = ? where idLichGiangDay = ?";
    String DELETE_SQL = "delete from LichGiangDay where idLichGiangDay = ?" ;
    String SELECT_ALL_SQL = "select * from LichGiangDay";
    String SELECT_BY_ID_SQL = "select * from lichgiangday where idLichgiangday =?";
    String SelectByGiangVien="select *from lichgiangday where magiangvien like ?";
    @Override
    public void insert(LichGiangDay entity) {
        JdbcHelper.update(INSERT_SQL,entity.getMaLop(), entity.getMaGiangVien(),entity.getMaMon());
    }

    @Override
    public void update(LichGiangDay entity) {
        JdbcHelper.update(UPDATE_SQL,    entity.getMaGiangVien(),entity.getMaLop(),entity.getMaMon());
    }


    @Override
    public List<LichGiangDay> selectAll() {
        return this.selectBySqlTho(SELECT_ALL_SQL);
    }


    @Override
    protected List<LichGiangDay> selectBySql(String sql, Object... agrs) {
        List<LichGiangDay> list = new ArrayList<LichGiangDay>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                LichGiangDay entity = new LichGiangDay();
                entity.setMaGiangVien(rs.getString("magiangvien"));
                entity.setMaMon(rs.getString("mamon"));
                entity.setMaLop(rs.getString("malop"));
                list.add(entity);
            }
            rs.getStatement().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected List<LichGiangDay> selectBySqlKhang(String sql, Object... agrs) {
        List<LichGiangDay> list = new ArrayList<LichGiangDay>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                LichGiangDay entity = new LichGiangDay();
                entity.setMaGiangVien(rs.getString("magiangvien"));
                entity.setMaMon(rs.getString("mamon"));
                entity.setMaLop(rs.getString("malop"));
                list.add(entity);
            }
            rs.getStatement().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    protected List<LichGiangDay> selectBySqlTho(String sql, Object... agrs) {
        List<LichGiangDay> list = new ArrayList<LichGiangDay>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                LichGiangDay d = new LichGiangDay();
                d.setMaGiangVien(rs.getString("maGiangVien"));
                d.setIdLichGiangDay(rs.getInt("idLichgiangday")); 
                d.setMaLop(rs.getString("malop"));
                d.setMaMon(rs.getString("mamon"));
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
    public LichGiangDay selectByID(Integer id) {
        List<LichGiangDay> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    
//    public  List<LichGiangDay> selectLop(String magiangvien){
//        String sql = "select * from lichgiangday where magiangvien = ?";
//        return this.selectBySql(sql, magiangvien);
//    }
    
     public  List<LichGiangDay> selectMon(String magiangvien,String malop,int maky, String manganh){
        String sql = "select * from lichgiangday where magiangvien = ? and malop = ? \n" +
                        "and mamon in (select mamon from MonHocCuaNganh where MaKy = ? and maNganh =? )";
        return this.selectBySql(sql, magiangvien,malop,maky,manganh);
    }
     
     public  List<LichGiangDay> selectLop(String magiangvien){
        String sql = "select * from LichGiangDay lgd where lgd.maGiangVien like ? \n" +
                        "and (select maky from lop l where l.maLop = lgd.maLop)\n" +
                        " in (select MaKy  from MonHocCuaNganh k where k.maMon like lgd.maMon \n" +
                        " and k.maNganh =(select manganh from lop where lop.malop =lgd.maLop ))";
        return this.selectBySql(sql, magiangvien);
    }
     
    public List<LichGiangDay> selectByGiangVien(String magiangvien) {
        return this.selectBySqlTho(SelectByGiangVien,magiangvien); 
    }
}
