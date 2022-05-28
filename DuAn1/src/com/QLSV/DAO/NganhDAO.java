/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.DAO;

import com.QLSV.Model.Nganh;
import com.QLSV.Utility.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hi
 */
public class NganhDAO extends MainDAO<Nganh, String> {
    String INSERT_SQL = "INSERT INTO Nganh(maNganh, tenNganh,mota) VALUES (?,?,?)";
    String UPDATE_SQL = "UPDATE Nganh SET tenNganh = ? ,mota =? where manganh = ?";
    String DELETE_SQL = "delete from nganh where manganh = ?";
    String SELECT_ALL_SQL = "Select * from nganh";
    String SELECT_BY_ID_SQL = "Select * from nganh where manganh = ?";

    @Override
    public void insert(Nganh entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaNganh(), entity.getTenNganh(), entity.getMoTa());
    }

    @Override
    public void update(Nganh entity) {
        JdbcHelper.update(UPDATE_SQL,   entity.getTenNganh(),entity.getMoTa(),entity.getMaNganh());
    }


    @Override
    public List<Nganh> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }


    @Override
    protected List<Nganh> selectBySql(String sql, Object... agrs) {
        List<Nganh> list = new ArrayList<Nganh>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                Nganh entity = new Nganh();
                entity.setMaNganh(rs.getString("maNganh"));
                entity.setTenNganh(rs.getString("tenNganh"));
                entity.setMoTa(rs.getString("mota"));
                list.add(entity);
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
    public Nganh selectByID(String id) {
        List<Nganh> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
}
