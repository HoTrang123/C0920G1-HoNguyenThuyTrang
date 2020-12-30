package _10_stack_queue.bai_tap.kiem_tra_dau_ngoac;

import java.util.Stack;

public class KiemTraDauNgoac {
    public boolean test (String str){
        Stack stack = new Stack();
        boolean check;
        boolean checkNgoac = false;
        for (int i = 0; i < str.length(); i++){
            checkNgoac = true;
            if (str.charAt(i) == '('){
                stack.push(str.charAt(i));
            }
            else if (str.charAt(i) == ')'){

                if (stack.size() == 0){
                    checkNgoac = false;
                    break;
                }
                stack.pop();
            }
        }
        if (checkNgoac && stack.size() == 0){
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    public static void main(String[] args) {
        KiemTraDauNgoac kta = new KiemTraDauNgoac();
        System.out.println(kta.test("a()bncdhg()"));
    }
}
