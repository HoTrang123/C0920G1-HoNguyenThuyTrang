drop database if exists furamaresort;
create database furamaresort;
use furamaresort;

create table vitri(
	id_vi_tri int primary key,
    ten_vi_tri varchar(45)
);

create table trinhdo(
	id_trinh_do int primary key,
    ten_trinh_do varchar(45)
);

create table bophan(
	id_bo_phan int primary key,
    ten_bo_phan varchar(45)
);

create table nhanvien(
	id_nhan_vien int primary key,
    ho_ten varchar(45),
    vi_tri_id int,
    trinh_do_id int,
    bo_phan_id int,
    ngay_sinh date,
    so_cmnd varchar(45),
    luong varchar(45),
    sdt varchar(45),
    email varchar(45),
    dia_chi varchar(45),
    foreign key (vi_tri_id) references vitri(id_vi_tri),
    foreign key (trinh_do_id) references trinhdo(id_trinh_do),
    foreign key (bo_phan_id) references bophan(id_bo_phan)
);

create table loaikhach(
	id_loai_khach int primary key,
    ten_loai_khach varchar(45)
);

create table khachhang(
	id_khach_hang int primary key,
    id_loai_khach int,
    ho_ten varchar(45),
    ngay_sinh date,
    so_cmnd varchar(45),
    sdt varchar(45),
    email varchar(45),
    diachi varchar(45),
    foreign key (id_loai_khach) references loaikhach(id_loai_khach)
);

create table kieuthue(
	id_kieu_thue int primary key,
    ten_kieu_thue varchar(45),
    gia int
);

create table loaidichvu(
	id_loai_dich_vu int primary key,
    ten_loai_dich_vu varchar(45)
);

create table dichvu(
	id_dich_vu int primary key,
    ten_dich_vu varchar(45),
    dien_tich int,
    so_tang int,
    so_nguoi_toi_da varchar(45),
    chi_phi_thue varchar(45),
    id_kieu_thue int,
    id_loai_dich_vu int,
    trang_thai varchar(45),
    foreign key (id_kieu_thue) references kieuthue(id_kieu_thue),
    foreign key (id_loai_dich_vu) references loaidichvu(id_loai_dich_vu)
);

create table hopdong(
	id_hop_dong int primary key,
    id_nhan_vien int,
    id_khach_hang int,
    id_dich_vu int,
	ngay_lam_hop_dong date,
    ngay_ket_thuc date,
    tien_da_coc int,
    tong_tien int,
    foreign key (id_nhan_vien) references nhanvien(id_nhan_vien),
    foreign key (id_khach_hang) references khachhang(id_khach_hang),
    foreign key (id_dich_vu) references dichvu(id_dich_vu)
);
    
create table dichvudikem(
	id_dv_di_kem int primary key,
    ten_dv_di_kem varchar(45),
    gia int,
    donvi int,
    trang_thai_kha_dung varchar(45)
);

create table hopdongchitiet(
	id_hd_chi_tiet int primary key,
    id_hop_dong int,
    id_dv_di_kem int,
    soluong int,
    foreign key (id_hop_dong) references hopdong(id_hop_dong),
    foreign key (id_dv_di_kem) references dichvudikem(id_dv_di_kem)
)