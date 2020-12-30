package _01_introduction_in_java.bai_tap.doc_so_thanh_chu;

import java.util.Scanner;

public class DocSoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number: ");
        int a = scanner.nextInt();
        if (a > 0 && a < 9) {
            DonVi(a);
        } else if (a >= 10 && a < 100) {
            HangChuc(a);
        } else if (a >= 100 && a < 1000) {
            HangTram(a);
        } else {
            System.out.print("nhap lai");
        }
    }
    public static void DonVi(int a) {
        switch (a){
            case 1:
                System.out.print("one");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            case 4:
                System.out.println("Four");
                break;
            case 5:
                System.out.println("Five");
                break;
            case 6:
                System.out.println("Six");
                break;
            case 7:
                System.out.println("Seven");
                break;
            case 8:
                System.out.println("Eight");
                break;
            case 9:
                System.out.println("Night");
                break;
        }
    }
    public static void HangChuc(int a) {
        if (a<20){
            switch (a){
                case 10:
                    System.out.println("Ten");
                    break;
                case 11:
                    System.out.println("Eleven");
                    break;
                case 12:
                    System.out.println("Twelfth");
                    break;
                case 13:
                    System.out.println("thirteen");
                    break;
                case 14:
                    System.out.println("Fourteen");
                    break;
                case 15:
                    System.out.println("Fifteen");
                    break;
                case 16:
                    System.out.println("Sixteen");
                    break;
                case 17:
                    System.out.println("Seventeen");
                    break;
                case 18:
                    System.out.println("Eighteen");
                    break;
                case 19:
                    System.out.println("Nineteen");
                    break;
            }
        }
       else if (a>=20){
           int b = a/10;
           int c = a%10;
            switch (b){
                case 2:
                    System.out.print("Twenty ");
                    break;
                case 3:
                    System.out.print("thirty ");
                    break;
                case 4:
                    System.out.print("Forty ");
                    break;
                case 5:
                    System.out.print("Fifty ");
                    break;
                case 6:
                    System.out.print("Sixty ");
                    break;
                case 7:
                    System.out.print("Seventy ");
                    break;
                case 8:
                    System.out.print("Eighty ");
                    break;
                case 9:
                    System.out.print("Ninety ");
                    break;
            }
            DonVi(c);
        }
    }
    public static void HangTram(int a) {
        int b = a / 100;
        int c = a % 100;
        switch (b){
            case 1:
                System.out.print("One hundred ");
                break;
            case 2:
                System.out.print("Two hundred ");
                break;
            case 3:
                System.out.print("Three hundred ");
                break;
            case 4:
                System.out.print("Four hundred ");
                break;
            case 5:
                System.out.print("Five hundred ");
                break;
            case 6:
                System.out.print("Six hundred ");
                break;
            case 7:
                System.out.print("Seven hundred ");
                break;
            case 8:
                System.out.print("Eight hundred ");
                break;
            case 9:
                System.out.print("Night hundred ");
                break;
        }
        HangChuc(c);
    }
    }
