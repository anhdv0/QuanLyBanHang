/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class HoaDon {
    private int idHoaDon;
    private String idNhanVien;
    private int idKhachHang;
    private Date ngayBan;
    private int tongTien;
    private String trangThai;
    private int tienKhachDua;
    private int tienThuaTraKhach;

    public HoaDon() {
    }

    public HoaDon(int idHoaDon, String idNhanVien, int idKhachHang, Date ngayBan, int tongTien, String trangThai, int tienKhachDua, int tienThuaTraKhach) {
        this.idHoaDon = idHoaDon;
        this.idNhanVien = idNhanVien;
        this.idKhachHang = idKhachHang;
        this.ngayBan = ngayBan;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.tienKhachDua = tienKhachDua;
        this.tienThuaTraKhach = tienThuaTraKhach;
    }
    
    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public Date getNgayBan() {
//        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return ngayBan;
    }

    public void setNgayBan(Date ngayBan) {
        this.ngayBan = ngayBan;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(int tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public int getTienThuaTraKhach() {
        return tienThuaTraKhach;
    }

    public void setTienThuaTraKhach(int tienThuaTraKhach) {
        this.tienThuaTraKhach = tienThuaTraKhach;
    }
        
}
