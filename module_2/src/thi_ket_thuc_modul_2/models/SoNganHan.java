package thi_ket_thuc_modul_2.models;

public abstract class SoNganHan extends SoTietKiem {
    protected String soTienGui;
    protected String laiXuat;

    public SoNganHan(String soTienGui, String laiXuat) {
        this.soTienGui = soTienGui;
        this.laiXuat = laiXuat;
    }

    public SoNganHan(String maSoSo, String maKhachHang, String ngayMoSo, String thoiGianBatdauGoi, String soTienGui, String laiXuat) {
        super(maSoSo, maKhachHang, ngayMoSo, thoiGianBatdauGoi);
        this.soTienGui = soTienGui;
        this.laiXuat = laiXuat;
    }

    public SoNganHan() {

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

    @Override
    public String toString() {
        return super.toString()  +  "SoNganHan{" +
                "soTienGui='" + soTienGui + '\'' +
                ", laiXuat='" + laiXuat + '\'' +
                '}';
    }


}
