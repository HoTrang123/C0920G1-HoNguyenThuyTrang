package _13_sap_xep.bai_tap.sx_chen;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {


        int[] a = {2, 7, 8, 9, 1, -5};

        // len^2 => O(n^2)
        for (int i = 1; i < a.length; i++) { // n

            int curElement = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) { // n
                if (curElement < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = curElement;
        }

        System.out.println(Arrays.toString(a));
    }
}
