package _03_array_method_in_java.array.bai_tap.tim_gia_tri_lon_nhat_mang_2_chieu;

import java.util.Scanner;

public class FindMaxArr2 {
    public static void main(String[] args) {
        int sizei;
        int sizej;
        int[][] array;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a size arr:");
        sizei = scanner.nextInt();
        System.out.print("Enter a size arr[0]:");
        sizej = scanner.nextInt();
        array = new int[sizei][sizej];
        for (int i = 0; i<array.length; i++){
            for (int j = 0; j<array[0].length; j++){
                System.out.print("Enter element " + i + "," + j + ": ");
                array[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Elements in array: \n");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j<array[0].length; j++){
                System.out.print(array[i][j] + "\t");
            }
            System.out.print("\n");
        }
        int max = array[0][0];
        for (int i = 0; i<array.length; i++){
            for (int j = 0; j<array[0].length;j++){
                if (array[i][j]> max){
                    max = array[i][j];
                }
            }
        }
        System.out.println("Elements max in array: " + max);
    }
}
