/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Database.DatabaseUtils;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class NhanVienDAO {
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
}
