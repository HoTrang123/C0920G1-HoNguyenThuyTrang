package com.codegym.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;

import javax.validation.ValidationProviderResolver;
import javax.validation.constraints.*;
import java.util.Date;

@Entity(name = "giaoDich")
public class GiaoDich implements Validator {
    @Id
    @GeneratedValue(generator = "my_generator")
    @GenericGenerator(name = "my_generator", strategy = "com.codegym.common.MyGenerator")
    private String idGiaoDich;
    private String tenGiaoDich;
    private String loaiGiaoDich;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @PastOrPresent
    private Date ngayGiaoDich;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date ngayKetThuc;

    @Min(value = 1, message = "Đơn giá phải lớn hơn 0")
    private int donGia;
    @ManyToOne
    @JoinColumn(name = "ma_khach_hang", nullable = false)
    private KhachHang khachHang;

    public GiaoDich() {
    }

    public String getIdGiaoDich() {
        return idGiaoDich;
    }

    public void setIdGiaoDich(String idGiaoDich) {
        this.idGiaoDich = idGiaoDich;
    }

    public String getTenGiaoDich() {
        return tenGiaoDich;
    }

    public void setTenGiaoDich(String tenGiaoDich) {
        this.tenGiaoDich = tenGiaoDich;
    }

    public String getLoaiGiaoDich() {
        return loaiGiaoDich;
    }

    public void setLoaiGiaoDich(String loaiGiaoDich) {
        this.loaiGiaoDich = loaiGiaoDich;
    }

    public Date getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(Date ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        GiaoDich giaoDich = (GiaoDich) target;

        Date inputDate1 = giaoDich.getNgayGiaoDich();
        Date inputDate2 = giaoDich.getNgayKetThuc();

        if (inputDate1 == null){
            errors.rejectValue("ngayGiaoDich","errorInput");
        }
        if (inputDate2 == null) {
            errors.rejectValue("ngayKetThuc", "errorInput");
        }
        if (inputDate1 != null && inputDate2!= null && inputDate2.before(inputDate1)) {
            errors.rejectValue("ngayKetThuc", "errorEndDate");
        }
    }
}

