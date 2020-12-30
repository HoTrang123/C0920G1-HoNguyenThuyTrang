package test.quan_ly_san_phan.controls;

import test.quan_ly_san_phan.models.ImportProduct;

import java.util.Scanner;

public class MainController {
    public static void displayMainMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean checkRun = true;
        while (checkRun){
            System.out.println("1.\t Add Product\n" +
                    "2.\tDelete Product\n" +
                    "3.\tShow Product\n" +
                    "4.\tFind Product\n" +
                    "5.\tExit\n" +
                    "6.\tEdit Product\n");
            System.out.println("Enter a number:");
            int c = scanner.nextInt();
            switch (c){
                case 1:
                    ManagerProduct.addProduct();
                break;
                case 2:
                    ManagerProduct.deleteProduct();
                    break;
                case 3:
                    ManagerProduct.displayProduct();
                    break;
                case 4:
                    ManagerProduct.findProduct();
                    break;
                case 5:
                    checkRun = false;
                    break;
                case 6:
                    ManagerProduct.editProduct();
                    break;
                default:
                    System.out.println("Enter again");
                    displayMainMenu();
            }
        }
    }
}
