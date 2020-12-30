package thi_ket_thuc_modul_2.controls;

import test.quan_ly_san_phan.controls.ManagerProductExport;
import test.quan_ly_san_phan.controls.ManagerProductImport;
import thi_ket_thuc_modul_2.models.SoDaiHan;

import java.util.Scanner;

public class QuanLy {
    public static void themMoi() {
        Scanner scanner = new Scanner(System.in);
        boolean checkRun = true;
        while (checkRun) {
            System.out.println("1.\tthem so tiet kiem dai han\n" +
                    "2.\tthem so tiet kiem ngan han\n" +
                    "3.\tquay lai menu chinh\n" +
                    "4.\tthoat\n");
            System.out.println("Enter a number:");
            int c = scanner.nextInt();
            switch (c) {
                case 1:
                    QuanLySoDaiHan.themSoDaiHan();
                    break;
                case 2:
                    QuanLySoNganHan.themSoNganHan();
                    break;
                case 3:
                    MainController.displayMainMenu();
                case 4:
                    checkRun = false;
                    break;
                default:
                    System.out.println("Enter again");
                    themMoi();
            }
        }
    }



    public static void hienThi() {
        Scanner scanner = new Scanner(System.in);
        boolean checkRun = true;
        while (checkRun) {
            System.out.println("1.\txem so tiet kiem dai han\n" +
                    "2.\txem so tiet kiem ngan han\n" +
                    "3.\tquay lai menu chinh\n" +
                    "4.\tthoat\n");
            System.out.println("Enter a number:");
            int c = scanner.nextInt();
            switch (c) {
                case 1:
                    QuanLySoDaiHan.displayProduct();
                    break;
                case 2:
                    QuanLySoNganHan.displayProduct();
                    break;
                case 3:
                    MainController.displayMainMenu();
                case 4:
                    checkRun = false;
                    break;
                default:
                    System.out.println("Enter again");
                    themMoi();
            }
        }
    }


    public static void timKiem() {
        Scanner scanner = new Scanner(System.in);
        boolean checkRun = true;
        while (checkRun) {
            System.out.println("1.\ttim kiem so tiet kiem dai han\n" +
                    "2.\ttim kiem so tiet kiem ngan han\n" +
                    "3.\tquay lai menu chinh\n" +
                    "4.\tthoat\n");
            System.out.println("Enter a number:");
            int c = scanner.nextInt();
            switch (c) {
                case 1:
                    QuanLySoDaiHan.findDaiHan();
                    break;
                case 2:
                    QuanLySoNganHan.findNganHan();
                    break;
                case 3:
                    MainController.displayMainMenu();
                case 4:
                    checkRun = false;
                    break;
                default:
                    System.out.println("Enter again");
                    themMoi();
            }
        }
    }


    public static void deleteSo() {
        Scanner scanner = new Scanner(System.in);
        boolean checkRun = true;
        while (checkRun) {
            System.out.println("1.\txoa so dai han\n" +
                    "2.\tXoa so ngan han\n" +
                    "3.\tShow main menu\n" +
                    "4.\tExit\n");
            System.out.println("Enter a number:");
            int c = scanner.nextInt();
            switch (c) {
                case 1:
                    QuanLySoDaiHan.deleteSoDaiHan();
                    break;
                case 2:

                    break;
                case 3:
                    test.quan_ly_san_phan.controls.MainController.displayMainMenu();
                case 4:
                    checkRun = false;
                    break;
                default:
                    System.out.println("Enter again");
                    deleteSo();
            }

        }
    }
}
