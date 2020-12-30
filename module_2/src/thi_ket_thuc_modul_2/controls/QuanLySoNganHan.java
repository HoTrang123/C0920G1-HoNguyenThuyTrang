package thi_ket_thuc_modul_2.controls;

import thi_ket_thuc_modul_2.commons.ReadWriteFile;
import thi_ket_thuc_modul_2.models.SoDaiHan;
import thi_ket_thuc_modul_2.models.SoNganHan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLySoNganHan {

    public static void themSoNganHan() {
        Scanner scanner = new Scanner(System.in);
        boolean checkRun = true;
        while (checkRun) {
            System.out.println("1.\tthem so vo thoi han\n" +
                    "2.\tthem so co thoi han\n" +
                    "3.\tquay lai menu chinh\n" +
                    "4.\tthoat\n");
            System.out.println("Enter a number:");
            int c = scanner.nextInt();
            switch (c) {
                case 1:
                   QuanLyVoThoiHan.themSoVoThoiHan();
                    break;
                case 2:
                    QuanLyCoThoiHan.themSoCoThoiHan();
                    break;
                case 3:
                    MainController.displayMainMenu();
                case 4:
                    checkRun = false;
                    break;
                default:
                    System.out.println("Enter again");
                    themSoNganHan();
            }
        }
    }

    public static List<SoNganHan> docSoNganHan() {
        List<SoNganHan> soNganHans = new ArrayList<>();
        List<String[]> listStr = ReadWriteFile.readFile("src/thi_ket_thuc_modul_2/datas/soNganHan.csv");

        for (String[] str : listStr) {
            SoNganHan soNganHan= new SoNganHan(str[0], str[1], str[2], str[3], str[4], str[5]) {
                @Override
                public void showInFor() {

                }
            };
            soNganHans.add(soNganHan);
        }
        return soNganHans;
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
        List<SoNganHan> soNganHans = docSoNganHan();
        if (soNganHans.isEmpty()) {
            System.out.println("Product is empty");
            test.quan_ly_san_phan.controls.MainController.displayMainMenu();
        } else {
            for (SoNganHan p : soNganHans) {
                p.showInFor();
            }
        }
    }


    public static void findNganHan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap ma so tiet kiem de tim kiem");
        String maSO = scanner.nextLine();
        boolean isHas = false;
        List<SoNganHan> soNganHans = docSoNganHan();
        for (SoNganHan p : soNganHans) {
            if (maSO.equals(p.getMaSoSo())) {
                p.showInFor();
                isHas = true;
            }
        }
        if (!isHas) {
            System.out.println("khong tim thay");
            test.quan_ly_san_phan.controls.MainController.displayMainMenu();
        }
    }
}
