package _04_OOP_java.thuc_hanh.phuong_trinh_bac_hai;

import _04_OOP_java.thuc_hanh.hinh_chu_nhat.Rectangle;

import java.sql.SQLOutput;
import java.util.Scanner;

public class QuadraticEquation {
    double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        double delta = this.b * this.b - 4*this.a*this.c;
        return delta;
    }
    public double getRoot1(){
        double r1 = (-this.b + Math.sqrt(getDiscriminant()))/(2*this.a);
        return r1;
    }
    public double getRoot2(){
        double r2 = (-this.b - Math.sqrt(getDiscriminant()))/(2*this.a);
        return r2;
    }
    public void getDisplayRoot(){
        double delta = getDiscriminant();
        if (delta > 0 ){
            System.out.printf("The equation has two roots: %f and %f ",getRoot1(),getRoot2());
        } else if (delta == 0){
            System.out.printf("The equation has one root: %f ", getRoot1());
        } else {
            System.out.println("The equation has no real roots ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the a:");
        double a = scanner.nextDouble();
        System.out.print("Enter the b:");
        double b = scanner.nextDouble();
        System.out.print("Enter the c:");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        quadraticEquation.getDisplayRoot();
    }
}

