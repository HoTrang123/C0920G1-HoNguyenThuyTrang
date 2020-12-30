package _03_array_method_in_java.array.bai_tap.xoa_phan_tu_khoi_mang;

import java.util.Scanner;

public class XoaPhanTu {
    public static void main(String[] args) {
        int size;
        int[] array;
        int x;
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
        System.out.print("Elements in array: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        int[] array2 = new int[array.length - 1];
        for (int j = 0; j < array.length; j++) {
            if (array[j] == x) {
//                System.out.println("\n" + "Variable " + x + " in index " + j);
                for (int z = 0; z < j; z++) {
                    array2[z] = array[z];
                }
                for (int k = j; k < array.length - 1; k++) {
                    array2[k] = array[k + 1];
                }
            }
        }
        System.out.print("New array: ");
        for (int j = 0; j < array2.length; j++) {
            System.out.print(array2[j] + "\t");
        }
    }
}
