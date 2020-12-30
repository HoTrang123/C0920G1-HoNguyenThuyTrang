package _10_stack_queue.bai_tap.chuyen_doi_tu_he_thap_phan_sang_he_nhi_phan;

import java.util.Stack;

public class DecimalToBinary {

    public void convertBinary(int num){

        Stack<Integer> stack = new Stack<Integer>();

        while(num != 0){

            //thực hiện phép chia lấy phần dư cho 2.

            int d = num%2;

            // thêm vào stack.

            stack.push(d);

            num/=2;

        }

        while(!(stack.isEmpty())){

            System.out.print(stack.pop());

        }


    }


    public static void main(String[]args){

        DecimalToBinary a = new DecimalToBinary();
        a.convertBinary(315);

    }
}