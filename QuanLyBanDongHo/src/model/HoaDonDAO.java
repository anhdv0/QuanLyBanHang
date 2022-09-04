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
import java.util.Date;
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
            String sSQL = "SELECT hd.IDHoaDon, hd.NgayBan, hd.IDNhanVien, khachhang.IDKhachHang FROM hoadon AS hd "
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
                hd.setIdKhachHang(rs.getInt(4));
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
    
    public List<HoaDon> getAllHoaDon(){
        List<HoaDon> lhd = new ArrayList<>(); 
        Connection con = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "select * from hoadon where trangthai = " + "\"TT"  + "\"";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            rs = sttm.executeQuery();
            while(rs.next()){
                HoaDon hd = new HoaDon();
                hd.setIdHoaDon(rs.getInt(1));
                hd.setIdNhanVien(rs.getString(2));
                hd.setIdKhachHang(rs.getInt(3));
                hd.setNgayBan(rs.getDate(4));
                hd.setTongTien(rs.getInt(5));
                hd.setTrangThai(rs.getString(6));
                hd.setTienKhachDua(rs.getInt(7));
                hd.setTienThuaTraKhach(rs.getInt(8));
                lhd.add(hd);
            }
            return lhd;
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
    public void UpdateTTHoaDon(int tongTien, int tienKhachDua, int tienTraKhach, String TT, int IDHD){
        Connection con = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update hoadon set tongtien = ?, tienkhachdua = ?, tienthuatrakhach = ? ,trangthai = ? where idhoadon = ?";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            sttm.setInt(1, tongTien);
            sttm.setInt(2, tienKhachDua);
            sttm.setInt(3, tienTraKhach);
            sttm.setString(4, TT);
            sttm.setInt(5, IDHD);
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
    public List<HoaDon> TimKiemByDate(String date){
        List<HoaDon> lhd = new ArrayList<>(); 
        Connection con = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String trangthai = "TT";
            String sSQL = "SELECT * FROM hoadon WHERE NgayBan like  ";
            String t = sSQL + "\"" + date + "\"" + "and trangthai = "+ "\"" + trangthai+ "\"";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(t);
            rs = sttm.executeQuery();
            while(rs.next()){
                HoaDon hd = new HoaDon();
                hd.setIdHoaDon(rs.getInt(1));
                hd.setIdNhanVien(rs.getString(2));
                hd.setIdKhachHang(rs.getInt(3));
                hd.setNgayBan(rs.getDate(4));
                hd.setTongTien(rs.getInt(5));
                hd.setTrangThai(rs.getString(6));
                hd.setTienKhachDua(rs.getInt(7));
                hd.setTienThuaTraKhach(rs.getInt(8));
                lhd.add(hd);
            }
            return lhd;
        } catch (Exception e) {
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
    public List<HoaDon> TimKiemByMonth(String m1, String m2){
        List<HoaDon> lhd = new ArrayList<>(); 
        Connection con = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String trangthai = "TT";
            String sSQL = "SELECT * FROM hoadon WHERE NgayBan "
                    + "BETWEEN "+"\"" +  m1 + "\""+" AND "+"\"" +  m2 + "\"" + "AND trangthai = " +"\"" +  trangthai + "\"";
            con = DatabaseUtils.getDBConnect();
            sttm = (PreparedStatement) con.prepareStatement(sSQL);
            rs = sttm.executeQuery();
            while(rs.next()){
                HoaDon hd = new HoaDon();
                hd.setIdHoaDon(rs.getInt(1));
                hd.setIdNhanVien(rs.getString(2));
                hd.setIdKhachHang(rs.getInt(3));
                hd.setNgayBan(rs.getDate(4));
                hd.setTongTien(rs.getInt(5));
                hd.setTrangThai(rs.getString(6));
                hd.setTienKhachDua(rs.getInt(7));
                hd.setTienThuaTraKhach(rs.getInt(8));
                lhd.add(hd);
            }
            return lhd;
        } catch (Exception e) {
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
}
