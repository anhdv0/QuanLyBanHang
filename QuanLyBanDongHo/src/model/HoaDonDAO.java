/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Database.DatabaseUtils;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class HoaDonDAO {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    public void ThemHoaDon(HoaDon hd){
        Connection con = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "insert into hoadon(IDNhanVien, IDKhachHang, NgayBan, TongTien, trangthai, tienkhachdua, tienthuatrakhach)"
                    + "value(?,?,?,?,?,?,?)";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setString(1, hd.getIdNhanVien());
            sttm.setInt(2, hd.getIdKhachHang());
            sttm.setString(3, df.format(hd.getNgayBan()));
            sttm.setInt(4, hd.getTongTien());
            sttm.setString(5, hd.getTrangThai());
            sttm.setInt(6, hd.getTienKhachDua());
            sttm.setInt(7, hd.getTienThuaTraKhach());
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
    
    public void XoaHoaDon(int idhd){
        Connection con = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "delete from hoadon where idhoadon = ?";
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
    
    public List<HoaDon> getHoaDon(String TT, String idNhanVien){
        List<HoaDon> ls = new ArrayList<>(); 
        Connection con = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT hd.IDHoaDon, hd.NgayBan, hd.IDNhanVien, khachhang.TenKhachHang FROM hoadon AS hd "
                    + "JOIN khachhang ON khachhang.IDKhachHang = hd.IDKhachHang and  hd.trangthai = ? and hd.IDNhanVien = ?";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setString(1,TT);
            sttm.setString(2,idNhanVien);
            rs = sttm.executeQuery();
            while(rs.next()){
                HoaDon hd = new HoaDon();
                hd.setIdHoaDon(rs.getInt(1));
                hd.setNgayBan(rs.getDate(2));
                hd.setIdNhanVien(rs.getString(3));
                hd.setTrangThai(rs.getString(4));
                ls.add(hd);
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
    public HoaDon getHoaDonByID(int idHoaDon){
        HoaDon hd = new HoaDon();
        Connection con = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM hoadon where idhoadon = ?";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setInt(1,idHoaDon);
            rs = sttm.executeQuery();
            while(rs.next()){
                hd.setIdHoaDon(rs.getInt(1));
                hd.setIdNhanVien(rs.getString(2));
                hd.setIdKhachHang(rs.getInt(3));
                hd.setNgayBan(rs.getDate(4));
                hd.setTongTien(rs.getInt(5));
                hd.setTrangThai(rs.getString(6));
                hd.setTienKhachDua(rs.getInt(7));
                hd.setTienThuaTraKhach(rs.getInt(8));
                return hd;
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
    
    public void UpdateIdkhHoaDon(int IDHD, int IDKH){
        Connection con = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update hoadon set idkhachhang = ? where idhoadon = ?";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setInt(1, IDKH);
            sttm.setInt(2, IDHD);
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
