package _03_array_method_in_java.array.thuc_hanh.tim_gtri_lon_nhat_trong_mang;

import java.util.Scanner;

public class GiaTrilonNhat {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20){
                System.out.println("Size should not exceed 20");
            }
            else {
                array = new int[size];
                int i = 0;
                while (i < array.length) {
                    System.out.print("Enter element" + (i + 1) + " : ");
                    array[i] = scanner.nextInt();
                    i++;
                }
                System.out.print("Property list: ");
                for (int j = 0; j < array.length; j++) {
                    System.out.print(array[j] + "\t");
                }
                int max = array[0];
                int index = 0;
                for (int j = 0; j < array.length; j++) {
                    if (array[j] > max) {
                        max = array[j];
                        index = j + 1;
                    }
                }
                System.out.println("The largest property value in the list is " + max + " ,at position " + index);
            }
        } while (size > 20);
    }
}
