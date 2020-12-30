package _10_stack_queue.bai_tap.dao_nguoc_mang;

import java.util.ArrayList;
import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        Stack <Integer> stack = new Stack<>();
        for (int i = 0; i<arrayList.size(); i++){
            stack.push(arrayList.get(i));
        }
        for (int i = 0; i < arrayList.size(); i++){
            arrayList.set(i,stack.pop());
        }
        System.out.println(arrayList);
    }
}
