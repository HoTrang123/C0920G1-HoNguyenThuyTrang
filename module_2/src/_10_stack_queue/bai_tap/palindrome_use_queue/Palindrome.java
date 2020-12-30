package _10_stack_queue.bai_tap.palindrome_use_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public boolean test(String str) {
        Stack<String> stack = new Stack();
        Queue<String> queue = new LinkedList();
        boolean check = false;
        for (int i = 0; i < str.length(); i++) {
            stack.push("" + str.charAt(i));
            queue.add("" + str.charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            if (stack.pop().equals(queue.remove())) {
                check = true;
            } else {
                check = false;
                break;
            }
        }
        return check;
        }



    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.test("abcba"));
    }
}
