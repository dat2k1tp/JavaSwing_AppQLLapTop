create database QLBH
go
use QLBH
go


create table SANPHAM
(
	maSP nvarchar(15) not null,
	tenSP nvarchar(100) not null,
	giaSP float not null,
	namSX int not null,
	soLuong int not null,
	motaSP nvarchar(255),
	Xoa bit not null,
	constraint PK_SANPHAM primary key (maSP),
	Constraint check_SoLuong check(soLuong>0),
	Constraint check_DonGia check(giaSP>0)
)
go

create table NHANVIEN
(
	maNV nvarchar(15) not null ,
	tenNV nvarchar(100) not null,
	diachi nvarchar(200) not null,
	soDT nvarchar(15) not null,
	email nvarchar(50) not null,
	gioiTinh nvarchar(3) not null,
	username nvarchar(20) not null,
	passwords  nvarchar(20) not null,
	chucVu nvarchar(30) not null,
	Xoa bit not null,
	constraint PK_NhanVien primary key (maNV)
)
go

create table KHACHHANG
(
	
	maKH nvarchar(15) not null,
	tenKH nvarchar(100) not null,
	gioiTinh nvarchar(3) not null,
	diachi nvarchar(200) not null,
	soDT nvarchar(15) not null,
	email nvarchar(50) not null,
	Xoa bit not null,
	constraint PK_KhachHang primary key (maKH)
)
go


create table HOADON
(
	maHD nvarchar(15) not null,
	maNV nvarchar(15) not null,
	maKH nvarchar(15) not null,
	NgayMuaHang datetime not null,
	GhiChu nvarchar(200),
	constraint PK_HOADON primary key (maHD)
)
go

Create table HoaDonChiTiet
(
	MaHoaDonChiTiet nvarchar(15) not null,
	maHD nvarchar(15) not null,
	SoLuong int not null,
	maSP nvarchar(15) not null,
	tenSP nvarchar(100) not null,
	GiaSP float not null,
	GiamGia float not null,
	Constraint PK_HoaDonChiTiet primary key(MaHoaDonChiTiet)
)
go


--danh sach khoa ngoai
alter table HOADON
add constraint FK_HOADON_NHANVIEN foreign key (maNV) references NHANVIEN(maNV)

alter table HOADON
add constraint FK_HOADON_KHACHHANG foreign key (maKH) references KHACHHANG(maKH)

alter table HoaDonChiTiet
add constraint FK_HoaDonChiTiet_HoaDon foreign key (maHD) references HoaDon(maHD)

alter table HoaDonChiTiet
add constraint FK_HoaDonChiTiet_SanPham foreign key (maSP) references SanPham(maSP)


