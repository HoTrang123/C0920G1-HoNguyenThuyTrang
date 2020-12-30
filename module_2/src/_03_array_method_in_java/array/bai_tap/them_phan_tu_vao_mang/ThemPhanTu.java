package _03_array_method_in_java.array.bai_tap.them_phan_tu_vao_mang;

import java.util.Scanner;

public class ThemPhanTu {
    public static void main(String[] args) {
        int size;
        int[] array;
        int x;
        int index;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a size:");
        size = scanner.nextInt();
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.print("Enter X: ");
        x = scanner.nextInt();
        System.out.print("Enter index: ");
        index = scanner.nextInt();
        System.out.print("Elements in array: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        int[] array2 = new int[array.length + 1];
        for (int j = 0; j < array.length; j++) {
                for (int z = 0; z < index; z++) {
                    array2[z] = array[z];
                }
            for (int k = index; k < array.length; k++) {
                    array2[k+1] = array[k];
            }
            array2[index] = x;
        }
        System.out.print("New array: ");
        for (int j = 0; j < array2.length; j++) {
            System.out.print(array2[j] + "\t");
        }
    }
}
