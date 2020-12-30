package thi_ket_thuc_modul_2.controls;

import thi_ket_thuc_modul_2.commons.ReadWriteFile;
import thi_ket_thuc_modul_2.commons.Validate;
import thi_ket_thuc_modul_2.models.SoCoThoiHan;
import thi_ket_thuc_modul_2.models.SoDaiHan;

import java.util.Scanner;

public class QuanLyCoThoiHan {

    public static void themSoCoThoiHan(){
        Scanner scanner = new Scanner(System.in);
        SoCoThoiHan soCoThoiHan = new SoCoThoiHan();

        System.out.println("Nhap ma so tiet kiem:");
        soCoThoiHan.setMaSoSo(scanner.nextLine());
        System.out.println("nhap ma khach hang:");
        soCoThoiHan.setMaKhachHang(scanner.nextLine());
        System.out.println("nhap ngay mo so:");
        soCoThoiHan.setNgayMoSo(scanner.nextLine());
        System.out.println("nhap thoi gian bat dau goi");
        soCoThoiHan.setThoiGianBatdauGoi(scanner.nextLine());
        System.out.println("nhap ky han");
        soCoThoiHan.setKyHan(scanner.nextLine());
        System.out.println("nhap so tien gui");
        soCoThoiHan.setSoTienGui(scanner.nextLine());
        System.out.println("nhap lai xuat");
        soCoThoiHan.setLaiXuat(scanner.nextLine());

        String line = soCoThoiHan.getMaSoSo() + "," + soCoThoiHan.getMaKhachHang()+','+ soCoThoiHan.getNgayMoSo()
                +',' +soCoThoiHan.getThoiGianBatdauGoi()+','+ soCoThoiHan.getKyHan() + ','+ soCoThoiHan.getSoTienGui()
                +','+ soCoThoiHan.getLaiXuat();
        ReadWriteFile.writeFile("src/thi_ket_thuc_modul_2/datas/soNganHan.csv", line);
    }
}
