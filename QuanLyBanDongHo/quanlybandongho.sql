-- create database quanlybanhang
-- character set utf8mb4
-- collate utf8mb4_unicode_ci;

create table nhanvien (
	IDNhanVien nvarchar(10) primary key,
    TenNhanVien nvarchar(50),
    Luong int not null,
    GioiTinh nvarchar(10),
    SoDienThoai nvarchar(12) not null, 
    DiaChi nvarchar(50)
    );
    
create table users (
	username nvarchar(10)not null,
    password nvarchar(10) not null,
    role bool ,
    primary key (username),
    foreign key (username) references nhanvien(IDNhanVien)
    );
    
create table sanpham (
	IDSanPham int primary key auto_increment,
    Tensanpham nvarchar(50)not null ,
    gia int not null,
    tendanhmuc nvarchar(50)not null,
    nhasanxuat nvarchar(50)not null,
    nuocsanxuat nvarchar(20) not null,
    mausac nvarchar(20) ,
    kichthuoc varchar(20)
    );
    
create table khachhang (
	IDKhachHang int primary key auto_increment,
    TenKhachHang nvarchar(20)not null ,
    Sodienthoai int not null
    );

create table HoaDon (
	IDHoaDon int primary key auto_increment,
    IDNhanVien nvarchar(10) not null,
    IDKhachHang int not null,
    NgayBan date not null ,
    Tongtien nvarchar(20)not null,
    trangthai varchar(20),
    tienkhachdua int not null,
    tienthuatrakhach int,

    foreign key (IDNhanVien) references nhanvien(IDNhanVien),
	foreign key (IDKhachHang) references khachhang(IDKhachHang )
    );

create table ChitietHoaDon (
	IDHoaDon int not null,
    IDSanPham int  not null,
    SoLuong int not null ,
    Thanhtien int not null,
    primary key(IDHoaDon,IDSanPham),
    foreign key (IDHoaDon) references HoaDon(IDHoaDon),
	foreign key (IDSanPham) references sanpham(IDSanPham )
    );
 
insert nhanvien(IDnhanvien, TenNhanVien, Luong, GioiTinh, SoDienThoai, DiaChi)
values
("anhdv0", "Do Van Anh", 5000000, "Nam", "0988096407", "Thanh Hoa" ),
("hoanghv0", "Ha Viet Hoang", 6000000, "Nam", "05345433456", "Soc Son" ),
("khainq0", "Nguyen Quang Khai", 7000000, "Nam", "099234235", "Soc Son" )
;
 
insert into users(username, password, role)
values
("anhdv0", "1", 1 ),
("hoanghv0", "2", 0 ),
("khainq0", "3", 0 )
;
insert into sanpham(Tensanpham, gia, tendanhmuc, nhasanxuat, nuocsanxuat, mausac, kichthuoc)
values
("Tivi LG", "10000000", "Tivi, Tủ lạnh", "LG", "VietNam", "Đen", "24inch" ),
("Tủ lạnh Panasonic", "7000000", "Tivi, Tủ lạnh", "Panasonic", "VietNam", "Xám", "150 lít" ),
("Bếp ga", "1000000", "Dụng cụ bếp", "Sunhouse", "VietNam", "Đen", "" )
;
-- ALTER TABLE hoadon
--   ADD tienkhachdua int not null;
-- ALTER TABLE hoadon
--   ADD tienthuatrakhach int not null;

-- DELETE FROM khachhang;
-- ALTER TABLE khachhang AUTO_INCREMENT=1;
insert into khachhang(tenkhachhang, sodienthoai)
values
("Khách bán lẻ", "0"),
("Đỗ Văn Anh", "0988096407"),
("Hà Việt Hoàng", "025346346"),
("Nguyễn Huy Nam", "45647587")
;
-- DROP TABLE chitiethoadon;
-- DROP TABLE hoadon
-- DROP TABLE sanpham;
-- delete from chitiethoadon;
-- DELETE FROM hoadon;
-- ALTER TABLE hoadon AUTO_INCREMENT=1;
insert into hoadon(idnhanvien, idkhachhang, tongtien, tienkhachdua, tienthuatrakhach, ngayban, trangthai)
values
("anhdv0", "1", 0, 0, 0, "2022-07-11", "KT"),
("hoanghv0", "1", 0, 0, 0, "2022-07-12", "TT"),
("hoanghv0", "1", 0, 0, 0, "2022-07-13", "KT"),
("anhdv0", "2", 0, 0, 0, "2022-07-14", "KT")
;

-- SELECT hd.IDHoaDon, hd.NgayBan, hd.IDNhanVien, kh.TenKhachHang FROM  hoadon AS hd, khachhang kh WHERE IDKhachHang = 1 and trangthai = "KT" and kh.studentID = hd.studentID;
-- SELECT hd.*, khachhang.TenKhachHang FROM hoadon AS hd JOIN khachhang ON khachhang.IDKhachHang = hd.IDKhachHang and  hd.trangthai = "KT" and hd.IDNhanVien = "anhdv0"
-- SELECT DISTINCT tendanhmuc FROM sanpham;
-- SELECT  * FROM hoadon where IDHoaDon = "2";

-- DELETE FROM chitiethoadon;
-- ALTER TABLE chitiethoadon;
-- insert into chitiethoadon(idhoadon, idsanpham, soluong, thanhtien)
-- values
-- (4, 1, 1, 10000000 ),
-- (4, 2, 1, 7000000 ),
-- (3, 2, 1, 7000000 )
-- ;
-- SELECT  * FROM chitiethoadon where IDHoaDon = "4";
-- SELECT * FROM sanpham WHERE Tensanpham like "t%"
-- SELECT * FROM sanpham WHERE tendanhmuc = "Tivi, Tủ lạnh%" and tenSanPham like "tu%"