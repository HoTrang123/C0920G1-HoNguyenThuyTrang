package thi_ket_thuc_modul_2.models;

public class SoDaiHan extends SoTietKiem{
    private String kyHan;
    private String soTienGui;
    private String laiXuat;
    private String uuDai;

    public SoDaiHan() {
    }

    public SoDaiHan(String kyHan, String soTienGui, String laiXuat, String uuDai) {
        this.kyHan = kyHan;
        this.soTienGui = soTienGui;
        this.laiXuat = laiXuat;
        this.uuDai = uuDai;
    }

    public SoDaiHan(String maSoSo, String maKhachHang, String ngayMoSo, String thoiGianBatdauGoi, String kyHan,
                    String soTienGui, String laiXuat, String uuDai) {
        super(maSoSo, maKhachHang, ngayMoSo, thoiGianBatdauGoi);
        this.kyHan = kyHan;
        this.soTienGui = soTienGui;
        this.laiXuat = laiXuat;
        this.uuDai = uuDai;
    }

    public String getKyHan() {
        return kyHan;
    }

    public void setKyHan(String kyHan) {
        this.kyHan = kyHan;
    }

    public String getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(String soTienGui) {
        this.soTienGui = soTienGui;
    }

    public String getLaiXuat() {
        return laiXuat;
    }

    public void setLaiXuat(String laiXuat) {
        this.laiXuat = laiXuat;
    }

    public String getUuDai() {
        return uuDai;
    }

    public void setUuDai(String uuDai) {
        this.uuDai = uuDai;
    }

    @Override
    public String toString() {
        return super.toString() + "SoDaiHan{" +
                "kyHan='" + kyHan + '\'' +
                ", soTienGui='" + soTienGui + '\'' +
                ", laiXuat='" + laiXuat + '\'' +
                ", uuDai='" + uuDai + '\'' +
                '}';
    }

    @Override
    public void showInFor() {
        System.out.println(this.toString());
    }


}
