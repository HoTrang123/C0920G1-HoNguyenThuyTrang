package thi_ket_thuc_modul_2.models;

public abstract class SoTietKiem {
    protected String maSoSo;
    protected String maKhachHang;
    protected String ngayMoSo;
    protected String thoiGianBatdauGoi;

    public SoTietKiem() {
    }

    public SoTietKiem(String maSoSo, String maKhachHang, String ngayMoSo, String thoiGianBatdauGoi) {
        this.maSoSo = maSoSo;
        this.maKhachHang = maKhachHang;
        this.ngayMoSo = ngayMoSo;
        this.thoiGianBatdauGoi = thoiGianBatdauGoi;
    }

    public String getMaSoSo() {
        return maSoSo;
    }

    public void setMaSoSo(String maSoSo) {
        this.maSoSo = maSoSo;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getNgayMoSo() {
        return ngayMoSo;
    }

    public void setNgayMoSo(String ngayMoSo) {
        this.ngayMoSo = ngayMoSo;
    }

    public String getThoiGianBatdauGoi() {
        return thoiGianBatdauGoi;
    }

    public void setThoiGianBatdauGoi(String thoiGianBatdauGoi) {
        this.thoiGianBatdauGoi = thoiGianBatdauGoi;
    }

    @Override
    public String toString() {
        return "SoTietKiem{" +
                "maSoSo='" + maSoSo + '\'' +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", ngayMoSo='" + ngayMoSo + '\'' +
                ", thoiGianBatdauGoi='" + thoiGianBatdauGoi + '\'' +
                '}';
    }

    public abstract void showInFor();
}
