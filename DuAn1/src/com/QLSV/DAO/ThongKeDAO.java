/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.DAO;

import com.QLSV.Model.ThongKe;
import com.QLSV.Model.Nganh;
import com.QLSV.Utility.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hi
 */
public class ThongKeDAO extends MainDAO<ThongKe, String>{
    String INSERT_SQL = "INSERT INTO Nganh(maNganh, tenNganh,mota) VALUES (?,?,?)";
    String UPDATE_SQL = "UPDATE Nganh SET tenNganh = ? ,mota =? where manganh = ?";
    String DELETE_SQL = "delete from nganh where manganh = ?";
    String SELECT_ALL_SQL = "select count(tennganh)as soluong,tennganh from sinhvien group by tennganh";
    String SELECT_BY_ID_SQL = "Select * from nganh where manganh = ?";
    String SELECT_ALL_SQL1 = "select count(maSinhVien) as soluong ,year(ngaynhaphoc) as  nam from sinhvien where year(ngayNhapHoc) in (select distinct year(ngaynhaphoc) as nam from sinhvien group by year(ngaynhaphoc))\n" +
"group by year(ngaynhaphoc)";
    String asdasd = "select count(maSinhVien) as soluong ,year(ngaynhaphoc) as  nam from sinhvien where year(ngayNhapHoc) in (select distinct year(ngaynhaphoc) as nam from sinhvien group by year(ngaynhaphoc))  " +
"group by year(ngaynhaphoc)";
    @Override
    public void insert(ThongKe d) {
        JdbcHelper.update(INSERT_SQL, d.getTennganh());
    }

    @Override
    public void update(ThongKe d) {
        JdbcHelper.update(UPDATE_SQL,   d.getTennganh());
    }


    @Override
    public List<ThongKe> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }


    @Override
    protected List<ThongKe> selectBySql(String sql, Object... agrs) {
        List<ThongKe> list = new ArrayList<ThongKe>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                ThongKe entity = new ThongKe();
                entity.setTennganh(rs.getString("tennganh"));
                entity.setSolong(rs.getInt("soluong"));
                list.add(entity);
            }
            rs.getStatement().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<ThongKe> selectcot() {
        return this.selectBySqlCot(asdasd);
    }
    protected List<ThongKe> selectBySqlCot(String sql, Object... agrs) {
        List<ThongKe> list = new ArrayList<ThongKe>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                ThongKe entity = new ThongKe(); 
                entity.setTennganh(String.valueOf(rs.getInt("nam")));
                entity.setSolong(rs.getInt("soluong"));
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
    public ThongKe selectByID(String id) {
        List<ThongKe> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
}
