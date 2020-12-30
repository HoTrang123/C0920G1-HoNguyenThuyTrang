package thi_ket_thuc_modul_2.models;

public class SoCoThoiHan extends SoNganHan {
    private String kyHan;

    public SoCoThoiHan(String soTienGui, String laiXuat, String kyHan) {
        super(soTienGui, laiXuat);
        this.kyHan = kyHan;
    }

    public SoCoThoiHan(String maSoSo, String maKhachHang, String ngayMoSo, String thoiGianBatdauGoi, String soTienGui,
                       String laiXuat, String kyHan) {
        super(maSoSo, maKhachHang, ngayMoSo, thoiGianBatdauGoi, soTienGui, laiXuat);
        this.kyHan = kyHan;
    }

    public SoCoThoiHan() {

    }

    public String getKyHan() {
        return kyHan;
    }

    public void setKyHan(String kyHan) {
        this.kyHan = kyHan;
    }

    @Override
    public String toString() {
        return "SoCoThoiHan{" +
                "kyHan='" + kyHan + '\'' +
                ", soTienGui='" + soTienGui + '\'' +
                ", laiXuat='" + laiXuat + '\'' +
                ", maSoSo='" + maSoSo + '\'' +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", ngayMoSo='" + ngayMoSo + '\'' +
                ", thoiGianBatdauGoi='" + thoiGianBatdauGoi + '\'' +
                '}';
    }

    @Override
    public void showInFor() {
        System.out.println(this.toString());
    }
}
