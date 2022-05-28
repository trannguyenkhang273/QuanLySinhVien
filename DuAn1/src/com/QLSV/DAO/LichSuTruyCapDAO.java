/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.DAO;

import com.QLSV.Model.LichSuTruyCap;
import com.QLSV.Model.MonCuaGiangVien;
import com.QLSV.Utility.JdbcHelper;
import com.mindfusion.common.DateTime;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tho
 */
public class LichSuTruyCapDAO extends MainDAO<LichSuTruyCap, String>{
    String sql_insert= "insert lichsutruycap(masinhvien,made,thoigian) values(?,?,?)";
    String selectALL= "select *from lichsutruycap";
    @Override
    public void insert(LichSuTruyCap entity) {
        JdbcHelper.update(sql_insert, entity.getMasinhvien(),entity.getMade(),entity.getNow());
    }

    @Override
    public void update(LichSuTruyCap entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LichSuTruyCap> selectAll() {
        return selectBySql(selectALL);
    }

    @Override
    public LichSuTruyCap selectByID(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<LichSuTruyCap> selectBySql(String sql, Object... agrs) {
        List<LichSuTruyCap> list = new ArrayList<LichSuTruyCap>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                LichSuTruyCap d = new LichSuTruyCap();
                d.setMasinhvien(rs.getString("Masinhvien"));
                d.setMade(rs.getString("made"));
                d.setNow(rs.getString("thoigian")); 
                list.add(d);
            }
            rs.getStatement().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
