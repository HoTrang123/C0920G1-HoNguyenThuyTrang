package _02_loop_in_java.hien_thi_20_so_nguyen_to;

import java.util.Scanner;

public class HienThiSoNguyenTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers, count;
        System.out.println("Enter a number:");
        numbers = Integer.valueOf(scanner.nextLine());
        count = 0;
        int N = 2;
        boolean check = false;
        while (count < numbers) {
            for (int i = 2; i <= Math.sqrt(N); i++){
                check = false;
                if (N % i == 0){
                    check = true;
                    break;
                }
            }
            if (!check){
                System.out.println( N + " la so nguyen to");
                count++;
            }
            N++;
        }
    }
}
