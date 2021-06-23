Use QLBH
go

Insert into SANPHAM
values('SP01','Asus A412DA','20.49','2019','50',
N'AMD,Quad Core R5RAM:8GB,DDR4,Ổ cứng:SSD,512 GB',0)
Insert into SANPHAM
values('SP02','Asus X509FA','15.89','2015','100',
N'Intel,Core i3,RAM :4GB,DDR4,Ổ cứng:SSD, 512 GB',0)
Insert into SANPHAM
values('SP03','Asus D509DA','10.79','2020','200',
N'AMD,Ryzen 3,RAM:4GB,DDR4,Ổ cứng:SSD,512 GB',0)
Insert into SANPHAM
values('SP04','Asus X509MA','5.99','2020','300',
N'Intel,Celeron,RAM:4 GB,DDR4,Ổ cứng:SSD,256 GB',0)
Insert into SANPHAM
values('SP05','Asus M413IA','30.49','2016','200',
N'AMD,Ryzen 5.4,RAM:8 GB,DDR4,Ổ cứng:SSD,512 GB',0)
--delete from SANPHAM
Insert into NHANVIEN
values('NV01',N'Phạm Nhật Vượng',N'Ba Đình,Hà Nội',N'0365555470'
,'ptv@gmail.com',N'Nam','user1','123',N'Nhân Viên',0),
('NV02',N'Đoàn Nguyên Đức',N'Cầu Giấy,Hà Nội',N'0765555480'
,'dnd@gmail.com',N'Nam','user2','123',N'Nhân Viên',0),
('NV03',N'Mai Kiều Liên',N'Long Biên,Hà Nội',N'0165558480'
,'mkl@gmail.com',N'Nữ','user3','123',N'Quản Lý',0),
('NV04',N'Phạm Thị Việt Nga',N'Thanh Xuân,Hà Nội',N'0565558490'
,'ptvn@gmail.com',N'Nữ','user4','123',N'Nhân Viên',0),
('NV05',N'Đặng Lê Nguyên Vũ',N'Hoàn Kiếm,Hà Nội',N'0665558470'
,'dlnv@gmail.com',N'Nam','user5','123',N'Nhân Viên',0)
--delete from NHANVIEN

Insert into KHACHHANG
values('KH01',N'Đông Nhi',N'Nữ',N'Nam Từ Liêm,Hà Nội','0178226692','dnhi@gmail.com',0),
('KH02',N'Noo Phước Thịnh',N'Nam',N'Đông Anh,Hà Nội','0478226699','npthinh@gmail.com',0),
('KH03',N'Soobin Hoàng Sơn',N'Nam',N'Thường Tín,Hà Nội','0378226661','shson@gmail.com',0),
('KH04',N'Mỹ Tâm',N'Nữ',N'Thạch Thất,Hà Nội','0778226679','mtam@gmail.com',0),
('KH05',N'Hà Anh Tuấn',N'Nam',N'Hai Bà Trưng,Hà Nội','0888226674','hatuan@gmail.com',0)
--delete from KHACHHANG

Insert into HOADON
values('HD01','NV05','KH01','2020-07-24',N'Đã thanh toán'),
('HD02','NV01','KH02','2019-08-24',N'Đã thanh toán'),
('HD03','NV04','KH03','2020-01-04',N'Đã thanh toán'),
('HD04','NV02','KH05','2018-12-04',N'Đã thanh toán'),
('HD05','NV04','KH01','2017-09-07',N'Đã thanh toán')
--delete from HOADON

Insert into HoaDonChiTiet
values('CT01','HD01','4','SP01',N'Asus A412DA','20.49','10'),
('CT02','HD02','5','SP02',N'Asus X509FA','15.89','5'),
('CT03','HD03','1','SP03',N'Asus D509DA','10.79','0'),
('CT04','HD04','3','SP04',N'Asus X509MA','5.99','5'),
('CT05','HD05','5','SP01',N'Asus A412DA','20.49','15')
--delete from HoaDonChiTiet