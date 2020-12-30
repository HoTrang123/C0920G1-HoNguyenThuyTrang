package thi_ket_thuc_modul_2.controls;

import test.quan_ly_san_phan.controls.ManagerProduct;

import java.util.Scanner;

public class MainController {
    public static void displayMainMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean checkRun = true;
        while (checkRun){
            System.out.println("1.\tthem moi so tiet kiem\n" +
                    "2.\txoa so tiet kiem\n" +
                    "3.\txem danh sach so tiet kiem\n" +
                    "4.\txem thong tin khach hang\n" +
                    "5.\ttim kiem so tiet kiem\n" +
                    "6.\tthoat\n");
            System.out.println("hay chon so de tiep tuc:");
            int c = scanner.nextInt();
            switch (c){
                case 1:
                    QuanLy.themMoi();
                    break;
                case 2:
                    QuanLy.deleteSo();
                    break;
                case 3:
                    QuanLy.hienThi();
                    break;
                case 4:
                    QuanLy.timKiem();
                    break;
                case 5:

                    checkRun = false;
                    break;
                default:
                    System.out.println("nhap lai");
                    displayMainMenu();
            }
        }
    }
}
