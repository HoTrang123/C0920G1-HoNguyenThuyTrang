package _02_loop_in_java.thuc_hanh.uoc_chung_lon_nhat;

import java.util.Scanner;

public class UocChungLonNhat {
    public static void main(String[] args) {
        int a;
        int b;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a: ");
        a = input.nextInt();
        System.out.println("Enter b: ");
        b = input.nextInt();
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0) {
            System.out.println("No greatest common factor");
        }
        else {
            int x = 0;
            for (int i =1; i<=a && i<=b; i++){
                    if (a%i==0 && b%i==0){
                        x = i;
                    }
                }
            System.out.println("Greatest common factor: " + x);
        }
    }
}
