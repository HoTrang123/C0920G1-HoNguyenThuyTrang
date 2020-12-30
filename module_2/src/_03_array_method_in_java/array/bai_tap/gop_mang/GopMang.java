package _03_array_method_in_java.array.bai_tap.gop_mang;

import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        int size1;
        int size2;
        int[] array1;
        int[] array2;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a size arr1:");
        size1 = scanner.nextInt();
        array1 = new int[size1];
        System.out.print("Enter a size arr2:");
        size2 = scanner.nextInt();
        array2 = new int[size2];
        int i = 0;
        while (i < array1.length) {
            System.out.print("Enter arr1 element " + (i + 1) + ": ");
            array1[i] = scanner.nextInt();
            i++;
        }
        i=0;
        while (i < array2.length) {
            System.out.print("Enter arr2 element " + (i + 1) + ": ");
            array2[i] = scanner.nextInt();
            i++;
        }
        System.out.print("Elements in array1: ");
        for (int j = 0; j < array1.length; j++) {
            System.out.print(array1[j] + "\t");
        }
        System.out.print("Elements in array2: ");
        for (int t = 0; t < array2.length; t++) {
            System.out.print(array2[t] + "\t");
        }
        int[] array = new int[array1.length + array2.length];
        for (int m = 0; m < array1.length; m++) {
           array[m]= array1[m];
        }
        for (int m = 0; m < array2.length; m++) {
            array[array1.length + m]= array2[m];
        }
        System.out.print("New array: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}
