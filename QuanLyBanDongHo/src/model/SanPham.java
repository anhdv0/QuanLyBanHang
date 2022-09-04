/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class SanPham {
    private int idSanPham;
    private String tenSanPham;
    private int gia;
    private String tenDanhMuc;
    private String nuocSanXuat;
    private String nhaSanXuat;
    private String mauSac;
    private String kichThuoc;

    public SanPham(int idSanPham, String tenSanPham, int gia, String tenDanhMuc, String nuocSanXuat, String nhaSanXuat, String mauSac, String kichThuoc) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.tenDanhMuc = tenDanhMuc;
        this.nuocSanXuat = nuocSanXuat;
        this.nhaSanXuat = nhaSanXuat;
        this.mauSac = mauSac;
        this.kichThuoc = kichThuoc;
    }

    public SanPham() {
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getNuocSanXuat() {
        return nuocSanXuat;
    }

    public void setNuocSanXuat(String nuocSanXuat) {
        this.nuocSanXuat = nuocSanXuat;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }
    
}
