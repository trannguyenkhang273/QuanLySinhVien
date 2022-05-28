/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.DAO;

import com.QLSV.Model.SinhVien;
import com.QLSV.Utility.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hi
 */
public class SinhVienDAO extends MainDAO<SinhVien, String>{
    String INSERT_SQL = "INSERT INTO sinhVien(maSinhVien, tenSinhvien, gioitinh, ngaysinh, ngayNhapHoc, ngayTotnghiep, email, sodienthoai, cmnd, anhdaidien, tinhtrang, tenNganh, matkhau, manv) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
    String UPDATE_SQL = "UPDATE sinhVien SET  tenSinhvien =?, gioitinh =?, ngaysinh =?, ngayNhapHoc =?, ngayTotnghiep =?, email =?, sodienthoai =?, cmnd =?, anhdaidien =?, tinhtrang =?, tenNganh =? where maSinhVien =?";
    String DELETE_SQL = "delete from sinhvien where masinhvien = ?";
    String SELECT_ALL_SQL = "select * from sinhVien";
    String SELECT_BY_ID_SQL = "select * from sinhVien where maSinhVien =?";

    String tblRight="select * from sinhvien where masinhvien in (select masinhvien from LopSinhVien where malop like ?)";
    String tblLeft ="select * where tennganh like ? and masinhvien in (select masinhvien from diem where trangthai like N'Rớt' and maMon like ? )";
    String svmoi= "select *from sinhvien where masinhvien not in (select maSinhVien from LopSinhVien) and tenNganh like ?"; 
    
    String UPDATE_MK= "UPDATE sinhVien set matkhau= ? where maSinhVien =?";
    String INSERT_DIEM= "exec diemSV ?,?";
    @Override
    public void insert(SinhVien d) {
        JdbcHelper.update(INSERT_SQL, d.getMaSinhVien(), d.getTenSinhVien(), d.isGioiTinh(), d.getNgaySinh(), d.getNgayNhapHoc(),d.getNgayTotNgiep(),
                d.getEmail(),d.getSoDienThoai(),d.getCmnd(),d.getAnhDaiDien(),d.isTinhTrang(),d.getTenNganh(),d.getMaSinhVien(),"NV01");
    }

    @Override
    public void update(SinhVien d) {
        JdbcHelper.update(UPDATE_SQL,    d.getTenSinhVien(), d.isGioiTinh(), d.getNgaySinh(), d.getNgayNhapHoc(),d.getNgayTotNgiep(),
                d.getEmail(),d.getSoDienThoai(),d.getCmnd(),d.getAnhDaiDien(),d.isTinhTrang(),d.getTenNganh(),d.getMaSinhVien());
    }


    @Override
    public List<SinhVien> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }


    @Override
    protected List<SinhVien> selectBySql(String sql, Object... agrs) {
        List<SinhVien> list = new ArrayList<SinhVien>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                SinhVien d = new SinhVien();
                d.setMaSinhVien(rs.getString("maSinhVien"));
                d.setTenSinhVien(rs.getString("tenSinhvien"));
                d.setGioiTinh(rs.getBoolean("gioitinh"));
                d.setNgaySinh(rs.getDate("ngaysinh"));
                d.setNgayNhapHoc(rs.getDate("ngayNhapHoc"));
                d.setNgayTotNgiep(rs.getDate("ngayTotnghiep"));
                d.setEmail(rs.getString("email"));
                d.setSoDienThoai(rs.getString("sodienthoai"));
                d.setCmnd(rs.getString("cmnd"));
                d.setAnhDaiDien(rs.getString("anhdaidien"));
                d.setTinhTrang(rs.getBoolean("tinhtrang"));
                d.setTenNganh(rs.getString("tenNganh"));
                d.setMatKhau(rs.getString("matkhau"));
                d.setMaNV(rs.getString("manv"));
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
    public SinhVien selectByID(String id) {
        List<SinhVien> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    
    public void updateQMK(SinhVien d) {
        JdbcHelper.update("UPDATE sinhVien SET matkhau =?  where maSinhVien =?", d.getMatKhau(),d.getMaSinhVien());
    }
    public List<SinhVien> tblRight(String maLop) {
        return this.selectBySql(tblRight,maLop);
    }
    public List<SinhVien> svMoi(String tenNganh) {
        return this.selectBySql(svmoi,tenNganh);
    }
    public List<SinhVien> FillTblLeft(String tenNganh,String maMon) {
        tblLeft ="select *from sinhvien where tennganh like N'"+tenNganh+"' "+" and masinhvien in (select masinhvien from diem where trangthai like N'Rớt' and maMon like N'"+maMon+"')";
        return this.selectBySql(tblLeft); 
    }
    
    public void updateMK(SinhVien d) {
         JdbcHelper.update(UPDATE_MK, d.getMatKhau(),d.getMaSinhVien());
    }
    public void InsertDiem(String  maSV, String maNganh) {
        JdbcHelper.update(INSERT_DIEM, maSV,maNganh);
    }
    public List<SinhVien> selectThongKe(String maNganh) {
        String sql = "select * from sinhvien where\n" +
        "maSinhVien in (select maSinhVien from lopsinhvien where \n" +
        "malop in (select malop from lop where maNganh like ?))";
        return selectBySql(sql,maNganh);
    }
}   
