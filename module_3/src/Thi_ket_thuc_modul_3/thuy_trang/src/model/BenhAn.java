package model;

public class BenhAn {
    private int id;
    private BenhNhan benhNhanId;
    private String ngayNhapVien;
    private String ngayRaVien;
    private String lyDoNhapVien;

    public BenhAn() {
    }

    public BenhAn(BenhNhan benhNhanId, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien) {
        this.benhNhanId = benhNhanId;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.lyDoNhapVien = lyDoNhapVien;
    }

    public BenhAn(int id, BenhNhan benhNhanId, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien) {
        this.id = id;
        this.benhNhanId = benhNhanId;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.lyDoNhapVien = lyDoNhapVien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BenhNhan getBenhNhanId() {
        return benhNhanId;
    }

    public void setBenhNhanId(BenhNhan benhNhanId) {
        this.benhNhanId = benhNhanId;
    }

    public String getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public String getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public String getLyDoNhapVien() {
        return lyDoNhapVien;
    }

    public void setLyDoNhapVien(String lyDoNhapVien) {
        this.lyDoNhapVien = lyDoNhapVien;
    }
}
