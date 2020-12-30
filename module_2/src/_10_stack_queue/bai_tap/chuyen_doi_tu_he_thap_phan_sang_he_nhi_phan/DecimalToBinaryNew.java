package _10_stack_queue.bai_tap.chuyen_doi_tu_he_thap_phan_sang_he_nhi_phan;

import java.util.Stack;

public class DecimalToBinaryNew {
    public void convert (int a){
        Stack<Integer> stack = new Stack();
        while (a != 0){
            int b = a%2;
            stack.push(b);
            a /= 2;
        }
        while(!(stack.isEmpty())){

            System.out.print(stack.pop());

        }
    }

    public static void main(String[] args) {
        DecimalToBinaryNew decimal = new DecimalToBinaryNew();
        decimal.convert(123456789);
    }
}
