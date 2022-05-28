/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.DAO;

import com.QLSV.Model.Nganh;
import com.QLSV.Model.LuuTaiKhoan;
import com.QLSV.Utility.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Tho
 */
public class LuuTaiKhoanDAO extends MainDAO<LuuTaiKhoan, String>  {
    String UPDATE_SQL = "UPDATE Luutaikhoan SET tendangnhap = ? , matkhau = ?";

    @Override
    public void insert(LuuTaiKhoan entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(LuuTaiKhoan entity) {
        JdbcHelper.update(UPDATE_SQL,entity.getTenDangNhap(),entity.getMatKhau() );
    }
    
    public LuuTaiKhoan select() throws SQLException{
        String sql="select*from luuTaiKhoan";
        ResultSet rs=JdbcHelper.query(sql);
        rs.next();
        LuuTaiKhoan luuTaiKhoan =new LuuTaiKhoan(rs.getString("tendangnhap"),rs.getString("matkhau"));
        return luuTaiKhoan;
    }
    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LuuTaiKhoan> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LuuTaiKhoan selectByID(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected List<LuuTaiKhoan> selectBySql(String sql, Object... agrs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    

    
}
