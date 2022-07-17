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
public class ChiTietHoaDonDAO {
    public void ThemCTHoaDon(ChiTietHoaDon cthd){
        Connection con = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "insert into chitiethoadon(idHoaDon, idSanPham,soLuong, ThanhTien)"
                    + "value(?,?,?,?)";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setInt(1, cthd.getIdHoaDon());
            sttm.setInt(2, cthd.getIdSanPham());
            sttm.setInt(3, cthd.getSoLuong());
            sttm.setInt(4, cthd.getThanhTien());
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
    public List<ChiTietHoaDon> getCTHoaDonByID(int idHoaDon){
        List<ChiTietHoaDon> ls = new ArrayList<>(); 
        Connection con = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT  * FROM chitiethoadon where idhoadon = ? ";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setInt(1, idHoaDon);
            rs = sttm.executeQuery();
            while(rs.next()){
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setIdHoaDon(rs.getInt(1));
                cthd.setIdSanPham(rs.getInt(2));
                cthd.setSoLuong(rs.getInt(3));
                cthd.setThanhTien(rs.getInt(4));
                ls.add(cthd);
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
    public ChiTietHoaDon getCTHoaDonByID(int idHoaDon, int idSanPham){
        ChiTietHoaDon cthd = new ChiTietHoaDon(); 
        Connection con = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT  * FROM chitiethoadon where idhoadon = ? and idsanpham = ? ";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setInt(1, idHoaDon);
            sttm.setInt(2, idSanPham);
            rs = sttm.executeQuery();
            while(rs.next()){
                cthd.setIdHoaDon(rs.getInt(1));
                cthd.setIdSanPham(rs.getInt(2));
                cthd.setSoLuong(rs.getInt(3));
                cthd.setThanhTien(rs.getInt(4));
                return cthd;
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
    public  void updateSoLuong (int idHoaDon, int idSanPhamn, int soLuong, int thanhTien){
        Connection con = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "UPDATE chitiethoadon SET soluong = ?, thanhtien = ? WHERE idhoadon = ? and idsanpham = ?" ;
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setInt(1, soLuong);
            sttm.setInt(2, thanhTien);
            sttm.setInt(3, idHoaDon);
            sttm.setInt(4, idSanPhamn);
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
    public void XoaCTHD(int idhd){
        Connection con = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "delete from chitiethoadon where idhoadon = ?";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setInt(1, idhd);
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
    public void XoaCTHD(int idhd, int idsp){
        Connection con = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "delete from chitiethoadon where idhoadon = ? and idsanpham = ?";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setInt(1, idhd);
            sttm.setInt(2, idsp);
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
