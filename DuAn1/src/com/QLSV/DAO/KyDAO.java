/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.DAO;

import com.QLSV.Model.Ky;
import com.QLSV.Utility.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hi
 */
public class KyDAO extends MainDAO<Ky, Integer>{
    String INSERT_SQL = "INSERT INTO ky (maky) VALUES (?)";
    String UPDATE_SQL = "UPDATE Lop SET  maNganh = ? where maLop =?";
    String DELETE_SQL = "delete from ky where maky =?";
    String SELECT_ALL_SQL = "select * from Ky";
    String SELECT_BY_ID_SQL = "select * from ky where maky =?";
    
    @Override
    public void insert(Ky entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaKy());
    }

    @Override
    public void update(Ky entity) {
        JdbcHelper.update(UPDATE_SQL,   entity.getMaKy());
    }


    @Override
    public List<Ky> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }


    @Override
    protected List<Ky> selectBySql(String sql, Object... agrs) {
        List<Ky> list = new ArrayList<Ky>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                Ky entity = new Ky();
                entity.setMaKy(rs.getInt("maky"));
                list.add(entity);
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
    public Ky selectByID(Integer id) {
        List<Ky> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
}
