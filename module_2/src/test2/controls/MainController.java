package test2.controls;

import test.quan_ly_san_phan.controls.ManagerProduct;

import java.util.Scanner;

public class MainController {
    public static void displayMainMenu(){
        Scanner scanner = new Scanner(System.in);
        boolean checkRun = true;
        while (checkRun){
            System.out.println("1.\tDisplay Menu\n" +
                    "2.\tAdd New\n" +
                    "3.\tUpdate\n" +
                    "4.\tDelete\n" +
                    "5.\tFind\n" +
                    "6.\tRead from file\n" +
                    "7.\tWrite to file\n" +
                    "8.\tExit\n" +
                    "\tEnter number\n");
            int c = scanner.nextInt();
            switch (c){
                case 1:
                    ManagerContact.showContact();
                    break;
                case 2:
                    ManagerContact.addContact();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    checkRun = false;
                    break;
                default:
                    System.out.println("Enter again");
                    displayMainMenu();
            }
        }
    }
}
