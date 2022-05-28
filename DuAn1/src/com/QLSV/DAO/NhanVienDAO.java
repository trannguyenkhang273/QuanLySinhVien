/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.DAO;

import com.QLSV.Model.NhanVien;
import com.QLSV.Utility.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hi
 */
public class NhanVienDAO extends MainDAO<NhanVien, String>{
    String INSERT_SQL = "INSERT INTO nhanvien (manv, matkhau, tenNhanvien, gmail, vaitro) VALUES (?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE nhanvien SET  matkhau =?, tenNhanvien =?, gmail =?, vaitro = ? where manv =?";
    String DELETE_SQL = "delete from nhanvien where manv = ?";
    String SELECT_ALL_SQL = "select * from nhanvien";
    String SELECT_BY_ID_SQL = "select * from nhanvien where manv =?";

    @Override
    public void insert(NhanVien d) {
        JdbcHelper.update(INSERT_SQL, d.getMaNV(),d.getMatKhau(),d.getTenNhanVien(),d.getGmail(),d.isVaitro());
    }

    @Override
    public void update(NhanVien d) {
        JdbcHelper.update(UPDATE_SQL,  d.getMatKhau(),d.getTenNhanVien(),d.getGmail(),d.isVaitro(),d.getMaNV());
    }


    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }


    @Override
    protected List<NhanVien> selectBySql(String sql, Object... agrs) {
        List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                NhanVien d = new NhanVien();
                d.setMaNV(rs.getString("manv"));
                d.setMatKhau(rs.getString("matkhau"));
                d.setTenNhanVien(rs.getString("tenNhanvien"));
                d.setGmail(rs.getString("gmail"));
                d.setVaitro(rs.getBoolean("vaitro"));
                list.add(d);
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
    public NhanVien selectByID(String id) {
        List<NhanVien> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
}
