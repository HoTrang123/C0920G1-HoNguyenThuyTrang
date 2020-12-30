package thi_ket_thuc_modul_2.controls;

import thi_ket_thuc_modul_2.commons.ReadWriteFile;
import thi_ket_thuc_modul_2.models.SoDaiHan;
import thi_ket_thuc_modul_2.models.SoVoThoiHan;

import java.util.Scanner;

public class QuanLyVoThoiHan {
    public static void themSoVoThoiHan(){
        Scanner scanner = new Scanner(System.in);
        SoVoThoiHan soVoThoiHan = new SoVoThoiHan();

        System.out.println("Nhap ma so tiet kiem:");
        soVoThoiHan.setMaSoSo(scanner.nextLine());
        System.out.println("nhap ma khach hang:");
        soVoThoiHan.setMaKhachHang(scanner.nextLine());
        System.out.println("nhap ngay mo so:");
        soVoThoiHan.setNgayMoSo(scanner.nextLine());
        System.out.println("nhap thoi gian bat dau goi");
        soVoThoiHan.setThoiGianBatdauGoi(scanner.nextLine());
        System.out.println("nhap so tien gui");
        soVoThoiHan.setSoTienGui(scanner.nextLine());
        System.out.println("nhap lai xuat");
        soVoThoiHan.setLaiXuat(scanner.nextLine());

        String line = soVoThoiHan.getMaSoSo() + "," + soVoThoiHan.getMaKhachHang()+','+ soVoThoiHan.getNgayMoSo()
                +',' +soVoThoiHan.getThoiGianBatdauGoi()+',' + soVoThoiHan.getSoTienGui()
                +','+ soVoThoiHan.getLaiXuat();
        ReadWriteFile.writeFile("src/thi_ket_thuc_modul_2/datas/soNganHan.csv", line);
    }
}
