/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.DAO;

import com.QLSV.Model.CauHoi;
import com.QLSV.Utility.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tho
 */
public class CauHoiDAO extends MainDAO<CauHoi, String>{

    String INSERT_SQL = "INSERT INTO CauHoi (maCauhoi,noidung,made,linkdinhkem) VALUES (?,?,?,?)";
    String UPDATE_SQL = "UPDATE CauHoi SET  noidung = ? ,set made= ?  where maCauhoi =?";
    String DELETE_SQL = "delete from CauHoi where maCauhoi =?";
    String SELECT_ALL_SQL = "select * from CauHoi";
    String SELECT_BY_ID_SQL = "select * from CauHoi where maCauhoi =?";
    String SELECT_BY_MADE="delete  from CauHoi where made =?";
    String soDapAn="select count(ketqua) from dapan where macauhoi like ? and ketqua =1";
    @Override
    public void insert(CauHoi entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaCauHoi(),entity.getNoiDung(),entity.getMaDe(),entity.getLinkDinhKem());
    }

    @Override
    public void update(CauHoi entity) {
        JdbcHelper.update(INSERT_SQL,entity.getNoiDung(),entity.getMaDe(),entity.getLinkDinhKem(), entity.getMaCauHoi());
    }

    @Override
    public void delete(String key) {
        JdbcHelper.update(SELECT_BY_MADE,key);
    }

    @Override
    public List<CauHoi> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }
    
    @Override
    public CauHoi selectByID(String key) {
        List<CauHoi> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<CauHoi> selectBySql(String sql, Object... agrs) {
        List<CauHoi> list = new ArrayList<CauHoi>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                CauHoi entity = new CauHoi();
                entity.setMaDe(rs.getString("made"));
                entity.setMaCauHoi(rs.getString("macauhoi"));
                entity.setNoiDung(rs.getString("noidung"));
                entity.setLinkDinhKem(rs.getString("linkdinhkem"));
                list.add(entity);
            }
            rs.getStatement().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
            }
    }
    
    public List<CauHoi> selectByMaDe() {
        return this.selectBySql(SELECT_BY_MADE);
    }
    public int soDapAn(String maCauHoi){
        return (int) JdbcHelper.value(soDapAn, maCauHoi);
    }
}
