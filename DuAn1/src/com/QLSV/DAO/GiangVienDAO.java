/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.DAO;

import com.QLSV.Model.GiangVien;
import com.QLSV.Utility.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hi
 */
public class GiangVienDAO extends MainDAO<GiangVien, String>{
    String INSERT_SQL = "INSERT INTO giangVien (maGiangVien, tenGiangVien, email, sodienthoai, ngaysinh, ngayvao, gioitinh, anhDaiDien, trinhDo, cmnd, chuyenmon, diachi, matKhau,manv) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE giangVien SET tenGiangVien =?, email =?, sodienthoai =?, ngaysinh =?, ngayvao =?, gioitinh =?, anhDaiDien =?, trinhDo =?, cmnd =?, chuyenmon =?, diachi =? , manv = ? where magiangvien = ?";
    String DELETE_SQL = "delete from giangvien where magiangvien =?";
    String SELECT_ALL_SQL = "SELECT * FROM giangVien";
    String SELECT_BY_ID_SQL = "SELECT * FROM giangVien where magiangvien =?";
    String sql="select *from giangvien where maGiangVien in (select maGiangVien from MonCuaGiangVien where mamon like ?)";
    
    @Override
    public void insert(GiangVien d) {
        JdbcHelper.update(INSERT_SQL, d.getMaGiangVien(), d.getTenGiangVien(), d.getEmail(), d.getSoDienThoai(), d.getNgaySinh(),d.getNgayVao(),
                d.isGioiTinh(),d.getAnhDaiDien(),d.getTrinhDo(),d.getCmnd(),d.getChuyenMon(),d.getDiaChi(),d.getMatKhau(),d.getManv());
    }

    @Override
    public void update(GiangVien d) {
        JdbcHelper.update(UPDATE_SQL,   d.getTenGiangVien(), d.getEmail(), d.getSoDienThoai(), d.getNgaySinh(),d.getNgayVao(),
                d.isGioiTinh(),d.getAnhDaiDien(),d.getTrinhDo(),d.getCmnd(),d.getChuyenMon(),d.getDiaChi() ,d.getManv(),d.getMaGiangVien());
    }

    public List<GiangVien> selectChuyenMoncuaGiangvien(){
        String sql = " select distinct chuyenmon from giangVien";
        return this.selectBySql1(sql);
    }
    
     protected List<GiangVien> selectBySql1(String sql, Object... agrs) {
        List<GiangVien> list = new ArrayList<GiangVien>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                GiangVien d = new GiangVien();
                d.setChuyenMon(rs.getString("chuyenmon"));
                list.add(d);
            }
            rs.getStatement().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public List<GiangVien> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }
    public List<GiangVien> cboGiangVien(String maMon) {
        return this.selectBySql(sql,maMon);
    }

    @Override
    protected List<GiangVien> selectBySql(String sql, Object... agrs) {
        List<GiangVien> list = new ArrayList<GiangVien>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                GiangVien d = new GiangVien();
                d.setMaGiangVien(rs.getString("maGiangVien"));
                d.setTenGiangVien(rs.getString("tenGiangVien"));
                d.setEmail(rs.getString("email"));
                d.setSoDienThoai(rs.getString("SoDienThoai"));
                d.setNgaySinh(rs.getDate("ngaysinh"));
                d.setNgayVao(rs.getDate("ngayvao"));
                d.setGioiTinh(rs.getBoolean("gioitinh"));
                d.setAnhDaiDien(rs.getString("anhDaiDien"));
                d.setTrinhDo(rs.getString("trinhDo"));
                d.setCmnd(rs.getString("cmnd"));
                d.setChuyenMon(rs.getString("chuyenmon"));
                d.setDiaChi(rs.getString("diachi"));
                d.setMatKhau(rs.getString("matKhau"));
                d.setManv(rs.getString("manv"));
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
    public GiangVien selectByID(String id) {
        List<GiangVien> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    
    public List<GiangVien> selectChuyenMon(String chuyenmon){
        String sql = " select * from giangvien where chuyenmon = ?";
        return this.selectBySql(sql, chuyenmon);
    }
}
