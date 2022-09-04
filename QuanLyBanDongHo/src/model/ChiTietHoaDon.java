/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class ChiTietHoaDon {
    private int idHoaDon;
    private int idSanPham;
    private int soLuong;
    private int ThanhTien;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int idHoaDon, int idSanPham, int soLuong, int ThanhTien) {
        this.idHoaDon = idHoaDon;
        this.idSanPham = idSanPham;
        this.soLuong = soLuong;
        this.ThanhTien = ThanhTien;
    }
    
    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(int ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
}
