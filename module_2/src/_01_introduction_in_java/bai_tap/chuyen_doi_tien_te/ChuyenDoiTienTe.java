package _01_introduction_in_java.bai_tap.chuyen_doi_tien_te;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input USD: ");
        int input = scanner.nextInt();
        final int HANG = 23000;
        int result = input*HANG;
        System.out.println(result);
    }
}
