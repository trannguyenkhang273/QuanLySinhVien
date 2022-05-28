/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.DAO;

import com.QLSV.Model.DapAn;
import com.QLSV.Utility.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tho
 */
public class DapAnDAO extends MainDAO<DapAn , String>{
String INSERT_SQL = "INSERT INTO DapAn (macauhoi,noidung,ketqua) VALUES (?,?,?)";
    String UPDATE_SQL = "UPDATE DapAn SET  noidung = ? ,set ketqua= ?  where macauhoi =?";
    String DELETE_SQL = "delete from DapAn where macauhoi =?";
    String DELETE_SQL_ByMADE = "delete from DapAn where macauhoi  like ?";
 
    String SELECT_ALL_SQL = "select * from DapAn";
    String SELECT_BY_ID_SQL = "select * from DapAn where macauhoi =?";
    
    @Override
    public void insert(DapAn entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaCauHoi(),entity.getNoiDung(),entity.isDapAn());
    }

    @Override
    public void update(DapAn entity) {
        JdbcHelper.update(INSERT_SQL,entity.getNoiDung(),entity.isDapAn(), entity.getMaCauHoi(   ));
    }

    @Override
    public void delete(String key) {
        JdbcHelper.update(DELETE_SQL,key);
    }
        public void delete_MaDe(String key) {
        JdbcHelper.update(DELETE_SQL_ByMADE,key);
    }
    @Override
    public List<DapAn> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public DapAn selectByID(String key) {
        List<DapAn> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    public List<DapAn> selectByMa(String key) {
        List<DapAn> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if(list.isEmpty()){
            return null;
        }
        return list;
    }
    @Override
    protected List<DapAn> selectBySql(String sql, Object... agrs) {
        List<DapAn> list = new ArrayList<DapAn>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                DapAn entity = new DapAn();
                entity.setMaCauHoi(rs.getString("macauhoi"));
                entity.setNoiDung(rs.getString("noidung"));
                entity.setDapAn(rs.getBoolean("ketqua"));
                list.add(entity);
            }
            rs.getStatement().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
            }    }
    
}
