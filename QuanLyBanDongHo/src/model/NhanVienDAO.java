/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Database.DatabaseUtils;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class NhanVienDAO {
        public List<NhanVien> getAllNhanVien(){
        List<NhanVien> ls = new ArrayList<>(); 
        Connection con = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "select * from nhanvien";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            rs = sttm.executeQuery();
            while(rs.next()){
                NhanVien nv = new NhanVien();
                nv.setIdNhanVien(rs.getString(1));
                nv.setTenNhanVien(rs.getString(2));
                nv.setLuong(rs.getInt(3));
                nv.setGioiTinh(rs.getString(4));
                nv.setSoDienThoai(rs.getString(5));
                nv.setDiaChi(rs.getString(6));
                ls.add(nv);
            }
            return ls;
        } catch (Exception e) {
            System.out.println("Error!");
        }
        finally{
            try {
                con.close();
                rs.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
        public NhanVien getNhanVienByID(String ID){
        Connection con = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        NhanVien nv = new NhanVien();
        try {
            String sSQL = "select * from nhanvien where idnhanvien = ? ";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setString(1, ID);
            rs = sttm.executeQuery();
            while(rs.next()){
                nv.setIdNhanVien(rs.getString(1));
                nv.setTenNhanVien(rs.getString(2));
                nv.setLuong(rs.getInt(3));
                nv.setGioiTinh(rs.getString(4));
                nv.setSoDienThoai(rs.getString(5));
                nv.setDiaChi(rs.getString(6));
                return nv;
            }
            
        } catch (Exception e) {
            System.out.println("Error!");
        }
        finally{
            try {
                con.close();
                rs.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
        public void ThemNhanVien(NhanVien nv){
        Connection con = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "insert into nhanvien(IDNhanVien, TenNhanVien, Luong, GioiTinh, SoDienThoai, DiaChi)"
                    + "value(?,?,?,?,?,?)";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setString(1, nv.getIdNhanVien());
            sttm.setString(2, nv.getTenNhanVien());
            sttm.setInt(3, nv.getLuong());
            sttm.setString(4, nv.getGioiTinh());
            sttm.setString(5, nv.getSoDienThoai());
            sttm.setString(6, nv.getDiaChi());
            sttm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error!");
            System.out.println(e.getMessage());
        }
        finally{
            try {
                con.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
    }
        public void XoaNhanVien(String idnv){
        Connection con = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "delete from nhanvien where IDNhanVien = ?";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setString(1, idnv);
            sttm.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error!");
            System.out.println(e.getMessage());
        }
        finally{
            try {
                con.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
    }
        public void CapNhatNhanVien(NhanVien nv){
        Connection con = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update nhanvien set TenNhanVien = ?,"
                    + " Luong = ?, GioiTinh = ?, SoDienThoai = ?, "
                    + "DiaChi = ? where IDNhanVien = ?";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setString(6, nv.getIdNhanVien());
            sttm.setString(1, nv.getTenNhanVien());
            sttm.setInt(2, nv.getLuong());
            sttm.setString(3, nv.getGioiTinh());
            sttm.setString(4, nv.getSoDienThoai());
            sttm.setString(5, nv.getDiaChi());
            sttm.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error!");
            System.out.println(e.getMessage());
        }
        finally{
            try {
                con.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
    }
        public List<NhanVien> getNhanVienByName(String name){
        List<NhanVien> ls = new ArrayList<>();
        Connection con = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM nhanvien WHERE idnhanvien like ";
            String t = sSQL + "\"" + name + "%\"";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(t);
            rs = sttm.executeQuery();
            while(rs.next()){
                NhanVien nv = new NhanVien();
                nv.setIdNhanVien(rs.getString(1));
                nv.setTenNhanVien(rs.getString(2));
                nv.setLuong(rs.getInt(3));
                nv.setGioiTinh(rs.getString(4));
                nv.setSoDienThoai(rs.getString(5));
                nv.setDiaChi(rs.getString(6));
                ls.add(nv);
            }
            return ls;
            
        } catch (Exception e) {
            System.out.println("Error!");
        }
        finally{
            try {
                con.close();
                rs.close();
                sttm.close();
            } catch (Exception e) {
            }
        }
        return null;
    }       
      
}
