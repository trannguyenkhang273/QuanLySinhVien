/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.DAO;

import com.QLSV.Utility.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.QLSV.Model.Lop;

/**
 *
 * @author hi
 */
public class LopDAO extends MainDAO<Lop, String> {

    String INSERT_SQL = "INSERT INTO Lop (maLop, maNganh,maKy) VALUES (?,?,?)";
    String UPDATE_SQL = "UPDATE Lop SET  maNganh = ?, maKy= ? where maLop =?";
    String DELETE_SQL = "delete from lop where malop =?";
    String SELECT_ALL_SQL = "select * from lop";
    String SELECT_BY_ID_SQL = "select * from lop where malop =?";
    String cboThem="select *from lop where maNganh like ? and maky =?";
    @Override
    public void insert(com.QLSV.Model.Lop entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaLop(), entity.getMaNganh(),entity.getMaky());
    }

    @Override
    public void update(com.QLSV.Model.Lop entity) {
        JdbcHelper.update(UPDATE_SQL,   entity.getMaNganh(),entity.getMaky(),entity.getMaLop());
    }


    @Override
    public List<com.QLSV.Model.Lop> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }
    public List<Lop> cboThem(String maNganh ,int maKy) {
        return this.selectBySql(cboThem,maNganh,maKy);
    }

    @Override
    protected List<com.QLSV.Model.Lop> selectBySql(String sql, Object... agrs) {
        List<com.QLSV.Model.Lop> list = new ArrayList<com.QLSV.Model.Lop>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                com.QLSV.Model.Lop entity = new com.QLSV.Model.Lop();
                entity.setMaLop(rs.getString("maLop"));
                entity.setMaNganh(rs.getString("maNganh"));
                entity.setMaky(rs.getInt("maky"));
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
    public com.QLSV.Model.Lop selectByID(String id) {
        List<com.QLSV.Model.Lop> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    public void tangky(com.QLSV.Model.Lop entity) {
        JdbcHelper.update(UPDATE_SQL,   entity.getMaNganh(),entity.getMaky()+1,entity.getMaLop());
    }
    public void giamky(com.QLSV.Model.Lop entity) {
        JdbcHelper.update(UPDATE_SQL,   entity.getMaNganh(),entity.getMaky()-1,entity.getMaLop());
    }
protected List<com.QLSV.Model.Lop> selectBySql1(String sql, Object... agrs) {
        List<com.QLSV.Model.Lop> list = new ArrayList<com.QLSV.Model.Lop>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                com.QLSV.Model.Lop entity = new com.QLSV.Model.Lop();
                entity.setMaLop(rs.getString("maLop"));
                entity.setMaNganh(rs.getString("maNganh"));
                entity.setMaky(rs.getInt("maky"));
                if(rs.wasNull()){
                    entity.setMaky(-1);
                }else{
                    entity.setMaky(rs.getInt("maky"));
                }
                list.add(entity);
            }
            rs.getStatement().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Lop> SelectThongKe(String key) {
        return selectBySql1("select top 1 maLop,maky,maNganh from Lop  \n" +
                                "where malop in (select malop from lopsinhvien where maSinhVien = ?) \n" +
                                "order by MaKy desc", key);
    }
    
}
