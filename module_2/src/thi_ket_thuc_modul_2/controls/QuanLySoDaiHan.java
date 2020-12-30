package thi_ket_thuc_modul_2.controls;

import test.quan_ly_san_phan.commons.NotFoundProductException;
import test.quan_ly_san_phan.commons.ReadWriteFileUntil;
import test.quan_ly_san_phan.commons.Validate;
import test.quan_ly_san_phan.controls.MainController;
import test.quan_ly_san_phan.controls.ManagerProductImport;
import test.quan_ly_san_phan.models.ExportProduct;
import test.quan_ly_san_phan.models.ImportProduct;
import test.quan_ly_san_phan.models.Product;
import thi_ket_thuc_modul_2.commons.ReadWriteFile;
import thi_ket_thuc_modul_2.models.SoDaiHan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLySoDaiHan {
    public static void themSoDaiHan(){
        Scanner scanner = new Scanner(System.in);
        SoDaiHan soDaiHan = new SoDaiHan();

        System.out.println("Nhap ma so tiet kiem:");
        soDaiHan.setMaSoSo(scanner.nextLine());
        System.out.println("nhap ma khach hang:");
        soDaiHan.setMaKhachHang(scanner.nextLine());
        System.out.println("nhap ngay mo so:");
        soDaiHan.setNgayMoSo(scanner.nextLine());
        System.out.println("nhap thoi gian bat dau goi");
        soDaiHan.setThoiGianBatdauGoi(scanner.nextLine());
        System.out.println("nhap ky han");
        soDaiHan.setKyHan(scanner.nextLine());
        System.out.println("nhap so tien gui");
        soDaiHan.setSoTienGui(scanner.nextLine());
        System.out.println("nhap lai xuat");
        soDaiHan.setLaiXuat(scanner.nextLine());
        System.out.println("nhap uu dai");
        soDaiHan.setUuDai(scanner.nextLine());

        String line = soDaiHan.getMaSoSo() + "," + soDaiHan.getMaKhachHang()+','+ soDaiHan.getNgayMoSo()
                +',' +soDaiHan.getThoiGianBatdauGoi()+','+ soDaiHan.getKyHan() + ','+ soDaiHan.getSoTienGui()
                +','+ soDaiHan.getLaiXuat() +','+ soDaiHan.getUuDai();
        ReadWriteFile.writeFile("src/thi_ket_thuc_modul_2/datas/soDaiHan.csv", line);
    }

    public static List<SoDaiHan> docSoDaiHan() {
        List<SoDaiHan> soDaiHans = new ArrayList<>();
        List<String[]> listStr = ReadWriteFile.readFile("src/thi_ket_thuc_modul_2/datas/soDaiHan.csv");

        for (String[] str : listStr) {
                SoDaiHan soDaiHan = new SoDaiHan(str[0], str[1], str[2], str[3], str[4], str[5], str[6], str[7]);
                soDaiHans.add(soDaiHan);
            }
        return soDaiHans;
    }

//    public static void display(List<SoDaiHan> soDaiHans) {
//        if (soDaiHans.isEmpty()) {
//            System.out.println("Product Export is empty");
//            MainController.displayMainMenu();
//        } else {
//            for (SoDaiHan p : soDaiHans) {
//                p.showInFor();
//            }
//        }
//    }

    public static void displayProduct() {
        List<SoDaiHan> soDaiHans = docSoDaiHan();
        if (soDaiHans.isEmpty()) {
            System.out.println("Product is empty");
            MainController.displayMainMenu();
        } else {
            for (SoDaiHan p : soDaiHans) {
                p.showInFor();
            }
        }
    }


    public static void findDaiHan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap ma so tiet kiem de tim kiem");
        String maSO = scanner.nextLine();
        boolean isHas = false;
        List<SoDaiHan> soDaiHans = docSoDaiHan();
        for (SoDaiHan p : soDaiHans) {
            if (maSO.equals(p.getMaSoSo())) {
                p.showInFor();
                isHas = true;
            }
        }
        if (!isHas) {
            System.out.println("khong tim thay");
            MainController.displayMainMenu();
        }

    }


    public static void deleteSoDaiHan() {
        Scanner scanner = new Scanner(System.in);
        List<SoDaiHan> soDaiHans = docSoDaiHan();
        displayProduct();
        System.out.println("nhap ma so de xoa");
        String maSo = scanner.nextLine();
        boolean isHas = false;
        try {
            for (SoDaiHan p : soDaiHans) {
                if (maSo.equals(p.getMaSoSo())) {
                    soDaiHans.remove(p);
                    isYesNo(soDaiHans);
                    isHas = true;
                    break;
                }
            }
            if (!isHas) {
                throw new NotFoundProductException("Doesn't exist!");
            }
        } catch (NotFoundProductException e) {
            e.printStackTrace();
            MainController.displayMainMenu();
        }
    }

    public static void isYesNo(List<SoDaiHan> soDaiHans) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("1.\tYes\n" + "2.\tNo\n" + "Ban muon xoa khong?");
        int c = scanner1.nextInt();
        switch (c) {
            case 1:
                String line = "";
                for (SoDaiHan p : soDaiHans) {
                    line += p.getMaSoSo() + "," + p.getMaKhachHang() + ',' + p.getNgayMoSo()
                            + ',' + p.getThoiGianBatdauGoi() + ',' + p.getKyHan() + ',' + p.getSoTienGui()
                            + ',' + p.getLaiXuat() + ',' + p.getUuDai();
                }
                ReadWriteFileUntil.writeFileInNewFile("src/test/quan_ly_san_phan/datas/ProductFile.csv", line);
                break;
            default:
                MainController.displayMainMenu();
        }
    }
}
