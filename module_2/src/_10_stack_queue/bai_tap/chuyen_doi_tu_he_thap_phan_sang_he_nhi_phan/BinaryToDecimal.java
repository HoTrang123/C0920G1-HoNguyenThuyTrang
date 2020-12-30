package _10_stack_queue.bai_tap.chuyen_doi_tu_he_thap_phan_sang_he_nhi_phan;

import java.sql.Array;
import java.util.Arrays;
import java.util.Stack;

public class BinaryToDecimal {
    public double covert(String a) {
        Stack<String> myStack = new Stack<>();
        double result = 0;
        String b = "0";
        boolean check = false;
        String[] arrA = a.split("");
        for (String str : arrA){
            myStack.push(str);
        }
        for (int i = 0; i < arrA.length; i++){
            arrA[i] = myStack.pop();
        }
        System.out.println(Arrays.toString(arrA));
        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i].charAt(0) != b.charAt(0)) {
                check = true;
            }

            if (check) {
                result += Math.pow(2, i );
            }
            check=false;
        }

        return result;
    }


    public static void main(String[] args) {
        BinaryToDecimal binary = new BinaryToDecimal();

        System.out.println( binary.covert("100111011"));
    }
}
