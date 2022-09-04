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
public class SanPhamDAO {
    public List<SanPham> getAllSanPham(){
        List<SanPham> ls = new ArrayList<>(); 
        Connection con = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "select * from sanpham";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            rs = sttm.executeQuery();
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setIdSanPham(rs.getInt(1));
                sp.setTenSanPham(rs.getString(2));
                sp.setGia(rs.getInt(3));
                sp.setTenDanhMuc(rs.getString(4));
                sp.setNhaSanXuat(rs.getString(5));
                sp.setNuocSanXuat(rs.getString(6));
                sp.setMauSac(rs.getString(7));
                sp.setKichThuoc(rs.getString(8));
                ls.add(sp);
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
    public SanPham getSanPhamByID(int idSanPham){
        SanPham sp = new SanPham(); 
        Connection con = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "select * from sanpham where idsanpham = ?";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setInt(1, idSanPham);
            rs = sttm.executeQuery();
            while(rs.next()){
                sp.setIdSanPham(rs.getInt(1));
                sp.setTenSanPham(rs.getString(2));
                sp.setGia(rs.getInt(3));
                sp.setTenDanhMuc(rs.getString(4));
                sp.setNhaSanXuat(rs.getString(5));
                sp.setNuocSanXuat(rs.getString(6));
                sp.setMauSac(rs.getString(7));
                sp.setKichThuoc(rs.getString(8));
                return sp;
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
    
    public void ThemSanPham(SanPham sp){
        Connection con = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "insert into sanpham(tensanpham, gia, tendanhmuc, nhasanxuat, nuocsanxuat, mausac, kichthuoc)"
                    + "value(?,?,?,?,?,?,?)";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setString(1, sp.getTenSanPham());
            sttm.setInt(2, sp.getGia());
            sttm.setString(3, sp.getTenDanhMuc());
            sttm.setString(4, sp.getNhaSanXuat());
            sttm.setString(5, sp.getNuocSanXuat());
            sttm.setString(6, sp.getMauSac());
            sttm.setString(7, sp.getKichThuoc());
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
    } // chua xong
    public List <String> getAllDanhMuc(){
        List<String> ls = new ArrayList<>(); 
        Connection con = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT DISTINCT tendanhmuc FROM sanpham;";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            rs = sttm.executeQuery();
            while(rs.next()){
                ls.add(rs.getString(1));
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
    public List<SanPham> timKiemSP(String tenSP){
        List<SanPham> ls = new ArrayList<>(); 
        Connection con = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM sanpham WHERE Tensanpham like ";
            String t = sSQL + "\"" + tenSP + "%\"";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(t);
            rs = sttm.executeQuery();
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setIdSanPham(rs.getInt(1));
                sp.setTenSanPham(rs.getString(2));
                sp.setGia(rs.getInt(3));
                sp.setTenDanhMuc(rs.getString(4));
                sp.setNhaSanXuat(rs.getString(5));
                sp.setNuocSanXuat(rs.getString(6));
                sp.setMauSac(rs.getString(7));
                sp.setKichThuoc(rs.getString(8));
                ls.add(sp);
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
    public List<SanPham> timKiemSPByDanhMuc(String danhMuc){
        List<SanPham> ls = new ArrayList<>(); 
        Connection con = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM sanpham WHERE tendanhmuc = ? ";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setString(1, danhMuc);
            rs = sttm.executeQuery();
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setIdSanPham(rs.getInt(1));
                sp.setTenSanPham(rs.getString(2));
                sp.setGia(rs.getInt(3));
                sp.setTenDanhMuc(rs.getString(4));
                sp.setNhaSanXuat(rs.getString(5));
                sp.setNuocSanXuat(rs.getString(6));
                sp.setMauSac(rs.getString(7));
                sp.setKichThuoc(rs.getString(8));
                ls.add(sp);
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
    public List<SanPham> timKiemSP(String tenSanPham, String danhMuc){
        List<SanPham> ls = new ArrayList<>(); 
        Connection con = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM sanpham WHERE tendanhmuc = " + "\"" +  danhMuc + "\"" + " and tenSanPham like " + "\"" + tenSanPham + "%\"" ;
            con = DatabaseUtils.getDBConnect();
            System.out.println(sSQL);
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            rs = sttm.executeQuery();
            while(rs.next()){
                SanPham sp = new SanPham();
                sp.setIdSanPham(rs.getInt(1));
                sp.setTenSanPham(rs.getString(2));
                sp.setGia(rs.getInt(3));
                sp.setTenDanhMuc(rs.getString(4));
                sp.setNhaSanXuat(rs.getString(5));
                sp.setNuocSanXuat(rs.getString(6));
                sp.setMauSac(rs.getString(7));
                sp.setKichThuoc(rs.getString(8));
                ls.add(sp);
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
    
    public void XoaSanPham(int idsp){
        Connection con = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "delete from sanpham where idsanpham = ?";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setInt(1, idsp);
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

      public void CapNhatSanPham(SanPham sp){
        Connection con = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update sanpham set tensanpham = ?, gia = ?,"
                    + " tendanhmuc = ?, nhasanxuat = ?, nuocsanxuat = ?, "
                    + "mausac = ?, kichthuoc = ? where IDSanPham = ?";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setString(1, sp.getTenSanPham());
            sttm.setInt(2, sp.getGia());
            sttm.setString(3, sp.getTenDanhMuc());
            sttm.setString(4, sp.getNhaSanXuat());
            sttm.setString(5, sp.getNuocSanXuat());
            sttm.setString(6, sp.getMauSac());
            sttm.setString(7, sp.getKichThuoc());
            sttm.setInt(8, sp.getIdSanPham());
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
}
    