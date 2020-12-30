package _01_introduction_in_java.thuc_hanh;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args){
        float sum = 0;
        int count = 0, subjects = 3;
        Scanner input = new Scanner(System.in);
        System.out.print( "Enter the marks for " + subjects + " subjects: ");
        while (count < subjects) {
            System.out.print("#" + (count+1) + ": ");
            float mark = input.nextFloat();
            if (mark < 0) {
                System.out.println(mark + " ignored");
                continue;
            }
            sum += mark;
            count++;
        }
        System.out.print("Average mark = "+sum/subjects);
    }
}
