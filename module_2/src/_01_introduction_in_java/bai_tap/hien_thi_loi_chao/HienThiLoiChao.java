package _01_introduction_in_java.bai_tap.hien_thi_loi_chao;

import java.util.Scanner;

public class HienThiLoiChao {
    public static void main(String[] args) {
        Scanner name = new Scanner(System.in);
        System.out.println("Input your name: ");
        String yourName = name.nextLine();
        System.out.println("Hello " +yourName);
    }
}
