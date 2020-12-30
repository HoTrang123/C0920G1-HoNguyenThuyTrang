package _14_ngoai_le_debug.bai_tap.illegal_triangle_exception_new;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) throws IllegalTriangleException {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập 3 cạnh! ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        Triangle triangle = new Triangle(a,b,c) ;
        System.out.println("Finally");
    }
}