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
public class KhachHangDAO {
    
    public List<KhachHang> getAllKhachHang(){
        List<KhachHang> ls = new ArrayList<>(); 
        Connection con = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "select * from khachhang";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            rs = sttm.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setIdKhachHang(rs.getInt(1));
                kh.setTenKhachHang(rs.getString(2));
                kh.setSoDienThoai(rs.getInt(3));
                ls.add(kh);
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
    
    public List<KhachHang> getKhachHangBySDT(int SDT){
        List<KhachHang> ls = new ArrayList<>(); 
        Connection con = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "select * from khachhang where sodienthoai like ";
            String sSDT = "\"" + SDT + "%\""  ;
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL+sSDT);
            rs = sttm.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setIdKhachHang(rs.getInt(1));
                kh.setTenKhachHang(rs.getString(2));
                kh.setSoDienThoai(rs.getInt(3));
                ls.add(kh);
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
    public KhachHang getKhachHangByID(int ID){
        KhachHang kh = new KhachHang();
        Connection con = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "select * from khachhang where idkhachhang = ? ";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setInt(1, ID);
            rs = sttm.executeQuery();
            while(rs.next()){
                kh.setIdKhachHang(rs.getInt(1));
                kh.setTenKhachHang(rs.getString(2));
                kh.setSoDienThoai(rs.getInt(3));
                return kh;
            }
        } catch (Exception e) {
            System.out.println("Error!");
            System.out.println(e.getMessage());
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
        public List<KhachHang> getKhachHangByName(String name){
        List<KhachHang> lkh = new ArrayList<>();
        Connection con = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "select * from khachhang where tenkhachhang like  ";
            String t = sSQL + "\"" + name + "%\"";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(t);
            rs = sttm.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setIdKhachHang(rs.getInt(1));
                kh.setTenKhachHang(rs.getString(2));
                kh.setSoDienThoai(rs.getInt(3));
                kh.setDiaChi(rs.getString(4));
                lkh.add(kh);
            }
            return lkh;
        } catch (Exception e) {
            System.out.println("Error!");
            System.out.println(e.getMessage());
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
    
    public void ThemKhachHang(KhachHang kh){
        Connection con = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "insert into khachhang(tenkhachhang, sodienthoai)"
                    + "value(?,?)";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setString(1, kh.getTenKhachHang());
            sttm.setInt(2, kh.getSoDienThoai());
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
    public void SuaKhachHang(KhachHang kh){
        Connection con = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update khachhang set tenkhachhang = ?, sodienthoai = ? where idkhachhang = ?";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setString(1, kh.getTenKhachHang());
            sttm.setInt(2, kh.getSoDienThoai());
            sttm.setInt(3, kh.getIdKhachHang());
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
    
    public void XoaKhachHang(int idKhachHang){
        Connection con = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "delete from khachhang where idkhachhang = ?";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setInt(1, idKhachHang);
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
      public void CapNhatKhachHang(KhachHang kh){
        Connection con = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update khachhang set tenkhachhang = ?, sodienthoai = ? where idkhachhang = ?";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setString(1, kh.getTenKhachHang());
            sttm.setInt(2, kh.getSoDienThoai());
            sttm.setInt(3, kh.getIdKhachHang());
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
