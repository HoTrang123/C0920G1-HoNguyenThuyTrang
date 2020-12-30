package thi_ket_thuc_modul_2.models;

public class SoVoThoiHan extends SoNganHan{

    public SoVoThoiHan(String soTienGui, String laiXuat) {
        super(soTienGui, laiXuat);
    }

    public SoVoThoiHan(String maSoSo, String maKhachHang, String ngayMoSo, String thoiGianBatdauGoi, String soTienGui, String laiXuat) {
        super(maSoSo, maKhachHang, ngayMoSo, thoiGianBatdauGoi, soTienGui, laiXuat);
    }

    public SoVoThoiHan() {
        super();
    }

    @Override
    public String toString() {
        return "SoVoThoiHan{" +
                "soTienGui='" + soTienGui + '\'' +
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
