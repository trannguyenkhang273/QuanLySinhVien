/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.DAO;

import com.QLSV.Model.Diem;
import com.QLSV.Utility.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hi
 */
public class DiemDAO extends MainDAO<Diem, Integer>{
     String INSERT_SQL = "INSERT INTO diem(maSinhVien, maMon, diemChuyenCan, diemGiuaKi,diemCuoiKi,trangthai) VALUES (?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE diem SET  diemChuyenCan =?, diemGiuaKi =?, diemCuoiKi =? ,trangthai = ? where maSinhVien =? and maMon =?";
    String DELETE_SQL = "DELETE FROM diem where maSinhVien =? and maMon =?";
    String SELECT_ALL_SQL = "SELECT * FROM diem";
    String SELECT_BY_ID_SQL = "SELECT * FROM diem where maSinhVien = ?";
    String themSVRot="update diem set trangthai = N'Học lại', diemChuyenCan=null, diemCuoiKi=null,diemGiuaKi=null where maSinhVien like ? and maMon like ?";
    String updateOutLop="update diem set trangthai = N'Rớt', diemChuyenCan=null, diemCuoiKi=null,diemGiuaKi=null where maSinhVien like ? and maMon like ?";
    @Override
    public void insert(Diem d) {
        JdbcHelper.update(INSERT_SQL, d.getMaSinhVien(), d.getMaMon(), d.getDiemChuyenCan(), d.getDiemGiuaKi(), d.getDiemCuoiKi(), d.getTrangThai());
    }

    @Override
    public void update(Diem d) {
        JdbcHelper.update(UPDATE_SQL,   d.getDiemChuyenCan()==-1?null:d.getDiemChuyenCan(), d.getDiemGiuaKi()==-1?null:d.getDiemGiuaKi(), d.getDiemCuoiKi()==-1?null:d.getDiemCuoiKi(),d.getTrangThai(), d.getMaSinhVien(), d.getMaMon());
    }
    
    @Override
    public List<Diem> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }
public List<Diem> selectAll0() {
        return this.selectBySql0(SELECT_ALL_SQL);
    }

    @Override
    protected List<Diem> selectBySql(String sql, Object... agrs) {
        List<Diem> list = new ArrayList<Diem>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                Diem d = new Diem();
                d.setMaSinhVien(rs.getString("maSinhVien"));
                d.setMaMon(rs.getString("maMon"));
                //d.setDiemChuyenCan(rs.getFloat("diemChuyenCan"));
//                if(rs.getString("diemChuyenCan").equals("null")){
//                    System.out.println("1");
//                    d.setDiemChuyenCan(-1);
//                }else{
//                    System.out.println("2");
//                    d.setDiemChuyenCan(rs.getFloat("diemChuyenCan"));
//                }
                
//                System.out.println("asd");
                rs.getFloat("diemChuyenCan");
                if(rs.wasNull()){
                    d.setDiemChuyenCan(-1);
                }else{
                    d.setDiemChuyenCan(rs.getFloat("diemChuyenCan"));
                }
                rs.getFloat("diemGiuaKi");
                //d.setDiemGiuaKi(rs.getFloat("diemGiuaKi"));
                if(rs.wasNull()){
                    d.setDiemGiuaKi(-1);
                }else{
                    d.setDiemGiuaKi(rs.getFloat("diemGiuaKi"));
                }
                rs.getFloat("diemCuoiKi");
//                d.setDiemCuoiKi(rs.getFloat("diemCuoiKi"));
                if(rs.wasNull()){
                    d.setDiemCuoiKi(-1);
                }else{
                    d.setDiemCuoiKi(rs.getFloat("diemCuoiKi"));
                }
                
                d.setTenSV(rs.getString("tensinhvien"));
                
                d.setTrangThai(rs.getString("trangthai"));
                list.add(d);
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
    public List<Diem> selectByID(String id) {
           return this.selectBySql(SELECT_BY_ID_SQL, id);
    }
    @Override
    public Diem selectByID(Integer id) {
        List<Diem> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    
    public  List<Diem> selectSinhVien(String mamon,String malop){
        String sql = "   select diem.masinhvien,sinhVien.tenSinhvien,maMon,diemChuyenCan,diemCuoiKi,diemGiuaKi,trangthai from diem ,sinhVien where diem.maSinhVien = sinhvien.maSinhVien and mamon =?  \n" +
" and diem.masinhvien in ( select masinhvien from LopSinhVien where diem.masinhvien = lopsinhvien.masinhvien and maLop = ?) \n" +
" and (trangthai is null or (trangthai not like N'Đậu (2)'))";
        return this.selectBySql(sql,mamon,malop);
    }
//    public  List<Diem> selectSinhViendiem(String sinhvien,String mamon){
//        String sql = "  SELECT diem.masinhvien,sinhVien.tenSinhvien,maMon,diemChuyenCan,diemCuoiKi,diemGiuaKi,trangthai FROM diem,sinhvien where diem.masinhvien = ? and mamon = ? and diem.maSinhVien = sinhvien.maSinhVien";
//        return this.selectBySql(sql,sinhvien,mamon);
//    }
    
    public Diem selectSinhViendiem(String sinhvien,String mamon) {
        String sql = "  SELECT diem.masinhvien,sinhVien.tenSinhvien,maMon,diemChuyenCan,diemCuoiKi,diemGiuaKi,trangthai FROM diem,sinhvien where diem.masinhvien = ? and mamon = ? and diem.maSinhVien = sinhvien.maSinhVien";
        List<Diem> list = this.selectBySql(sql, sinhvien,mamon);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    public void themSV(String maSV,String maMon) {
        JdbcHelper.update(themSVRot,maSV,maMon);   
    }
    
    public void updateOutLop(String maSV,String maMon) {
        JdbcHelper.update(updateOutLop,maSV,maMon);   
    }
    
    public List<Diem> selectAllThongKe(String mamon) {
        return this.selectBySql0("select * from diem where mamon = ? and trangthai is not null and trangthai not like '' ",mamon);
    }
    
    public List<Diem> selectByID0(String id) {
           return this.selectBySql0(SELECT_BY_ID_SQL, id);
    }
    protected List<Diem> selectBySql0(String sql, Object... agrs) {
        List<Diem> list = new ArrayList<Diem>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                Diem d = new Diem();
                d.setMaSinhVien(rs.getString("maSinhVien"));
                d.setMaMon(rs.getString("maMon"));
                //d.setDiemChuyenCan(rs.getFloat("diemChuyenCan"));
//                if(rs.getString("diemChuyenCan").equals("null")){
//                    System.out.println("1");
//                    d.setDiemChuyenCan(-1);
//                }else{
//                    System.out.println("2");
//                    d.setDiemChuyenCan(rs.getFloat("diemChuyenCan"));
//                }
                
//                System.out.println("asd");
                rs.getFloat("diemChuyenCan");
                if(rs.wasNull()){
                    d.setDiemChuyenCan(-1);
                }else{
                    d.setDiemChuyenCan(rs.getFloat("diemChuyenCan"));
                }
                rs.getFloat("diemGiuaKi");
                //d.setDiemGiuaKi(rs.getFloat("diemGiuaKi"));
                if(rs.wasNull()){
                    d.setDiemGiuaKi(-1);
                }else{
                    d.setDiemGiuaKi(rs.getFloat("diemGiuaKi"));
                }
                rs.getFloat("diemCuoiKi");
//                d.setDiemCuoiKi(rs.getFloat("diemCuoiKi"));
                if(rs.wasNull()){
                    d.setDiemCuoiKi(-1);
                }else{
                    d.setDiemCuoiKi(rs.getFloat("diemCuoiKi"));
                }
                
                d.setTenSV("a");
                
                d.setTrangThai(rs.getString("trangthai"));
                list.add(d);
            }
            rs.getStatement().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public  List<Diem> selectThongkeDiem(String masv){
        String sql =  "select * from diem where trangthai like N'Đậu (2)' \n" +
        "and masinhvien like ? and maMon in \n" +
        "(select mamon from MonHocCuaNganh where maky in \n" +
        "(select maky-1 from lop where malop in \n" +
        "(select malop from lopsinhvien where masinhvien like ?) \n" +
        "and maNganh in (select manganh from lop where malop in \n" +
        "(select malop from lopsinhvien where masinhvien like ?) )))";
        String sql1 = "select * from diem where masinhvien = ?";
        return this.selectBySql0(sql,masv,masv,masv);
    }
    
    public Diem selectCheckThi(String maMon,String maSV){
        String sql ="select *from diem where masinhvien like ? and mamon like ? ";
        try{
                    return (Diem) this.selectBySql0(sql,maSV, maMon).get(0);
        }catch(Exception e){
            return null;
        }
    }
    
    
   
    
    
    public List<Diem> selectMonCuaSinhVien(String masinhvien,String manganh , int maky) {
        return this.selectBySql0("select * from diem where masinhvien  = ? \n" +
"and mamon in (select mamon from MonHocCuaNganh where maNganh like ? and MaKy = ?) ",masinhvien,manganh,maky);
    }
    
    
    
    protected List<Diem> selectBySql1(String sql, Object... agrs) {
        List<Diem> list = new ArrayList<Diem>();
        try {
            ResultSet rs =JdbcHelper.query(sql, agrs);
            while(rs.next()){
                Diem d = new Diem();
                d.setMaSinhVien(rs.getString("maSinhVien"));
                d.setMaMon("a");
                rs.getFloat("diemChuyenCan");
                if(rs.wasNull()){
                    d.setDiemChuyenCan(-1);
                }else{
                    d.setDiemChuyenCan(rs.getFloat("diemChuyenCan"));
                }
                rs.getFloat("diemGiuaKi");
                if(rs.wasNull()){
                    d.setDiemGiuaKi(-1);
                }else{
                    d.setDiemGiuaKi(rs.getFloat("diemGiuaKi"));
                }
                rs.getFloat("diemCuoiKi");
                if(rs.wasNull()){
                    d.setDiemCuoiKi(-1);
                }else{
                    d.setDiemCuoiKi(rs.getFloat("diemCuoiKi"));
                }
                
                d.setTenSV("a");
                
                d.setTrangThai("a");
                list.add(d);
            }
            rs.getStatement().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public  List<Diem> selectThongkeDiem1(String masv,int makycu,int maky){
        String sql =  "select diem.masinhvien,avg(diemchuyencan)as diemchuyencan,avg(diemgiuaki) as diemgiuaki,avg(diemcuoiki)as diemcuoiki from diem ,Lop\n" +
"where maSinhVien = ? and \n" +
"malop in (select malop from lopsinhvien where maSinhVien = diem.masinhvien) and \n" +
"mamon in (select mamon from MonHocCuaNganh where \n" +
"maky =? and\n" +
"maNganh in (select maNganh from lop where malop = lop.maLop))and lop.MaKy =? \n" +
"group by diem.masinhvien,maky,maLop\n" +
"having lop.maky>1";
        return this.selectBySql1(sql,masv,makycu,maky);
    }
    
}
