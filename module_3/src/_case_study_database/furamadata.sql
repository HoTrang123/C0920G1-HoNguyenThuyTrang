use furamaresort;

insert into vitri  values
	(1, 'Le tan'),
	(2, 'Phuc vu'),
	(3, 'Chuyen vien'),
	(4, 'Giam sat'),
	(5, 'Quan ly'),
	(6, 'Giam doc');
    
    insert into trinhdo values
	(1, 'Trung cap'),
	(2, 'Cao dang'),
	(3, 'Dai hoc'),
	(4, 'Co kinh nghiem');
    
    insert into bophan values 
	(1, 'Sale-Maketing'),
    (2, 'Hanh chinh'),
	(3, 'Phuc vu'),
    (4, 'Quan ly');

insert into nhanvien values
	(1, 'Khang', 3, 3, 2, '1998-10-28', '68761234', '8000000', '0432874655', 'khang@gmail.com', 'Hoa khanh'),
	(2, 'Bao', 5, 3, 4, '1997-09-24', '68761234', '8000000', '0432874655', 'bao@gmail.com', 'Hoa khanh'),
	(3, 'Thinh', 4,  3, 1, '2003-10-28', '68761234', '8000000', '0432874655', 'thinh@gmail.com', 'Hoa khanh');
    
    insert into loaikhach values
	(1, 'Diamond'),
	(2, 'Platinium'),
	(3, 'Gold'),
	(4, 'Silver'),
	(5, 'Member');
    
    insert into khachhang values
	(1, 2, 'Trang', '1997-11-20', '812364873', '0123456789', 'trang@gmail.com', 'Dien bien phu'),
	(2, 1, 'Anh',  '1995-04-09', '812364873', '0123456789', 'trang@gmail.com', 'Dien bien phu'),
	(3, 3, 'Nhan', '1993-12-13', '812364873', '0123456789', 'trang@gmail.com', 'Dien bien phu');
    
    
insert into kieuthue (id_kieu_thue, ten_kieu_thue, gia) values
	(1, 'Nam', 100000000),
	(2, 'Thang', 10000000),
	(3, 'Ngay', 1000000),
	(4, 'Gio', 100000);
    
insert into loaidichvu (id_loai_dich_vu, ten_loai_dich_vu) values
	(1, 'Vip'),
	(2, 'Tot'),
	(3, 'Thuong');
    
insert into dichvu values
    (1, 'Villa', 500, 2, '4', '20000000', 2, 1, 'Con'),
    (2, 'House', 300, 3, '8', '8000000', 1, 2, 'Con'),
    (3, 'Room', 100, 1, '4', '1000000', 3, 3, 'Con');

insert into hopdong values
	(1, 1, 2, 2, '2020-12-04', '2020-12-25', 30000000, 60000000),
	(2, 2, 1, 3, '2020-12-14', '2021-01-05', 20000000, 40000000),
	(3, 3, 2, 1, '2020-12-24', '2021-01-01', 3000000, 6000000);
    
insert into dichvudikem values
	(1, 'Massage', 500000, 2, 'Con'),
	(2, 'Karaoke', 300000, 5, 'Con'),
	(3, 'Food', 200000, 10, 'Con'),
	(4, 'Drink', 100000, 20, 'Con'),
	(5, 'Car', 150000, 10, 'Con');
    
insert into hopdongchitiet values
	(1, 2, 3, 2),
	(2, 3, 4, 3),
	(3, 1, 1, 2);

