package _10_stack_queue.bai_tap.treemap;

import java.util.TreeMap;

public class TreeMapEx {
    public static void main(String args[]) {
        String str = "ABCDEF";
        TreeMap<String, Integer> map = new TreeMap<>();

        map.put("A", 1);
        map.put("B", 1);
        map.put("C", 2);

//
//        for (int i = 0; i < str.length(); i++) {
//
//            boolean check = true;
//
//            for (Map.Entry<String, Integer> entry : map.entrySet()) {
//                if (entry.getKey().charAt(0) == str.charAt(i)) {
//                    entry.setValue(entry.getValue() + 1);
//                    check = false;
//                }
//            }
//
//            if (check) {
//                map.put(str.charAt(i) + "", 1);
//            }
//            check = true;
//        }
        for (int i = 0; i < str.length(); i++){
            if (map.containsKey(str.charAt(i)+"")){
                map.replace(str.charAt(i)+"", map.get(str.charAt(i)+"")+1);
            }else {
                map.put(str.charAt(i)+"", 1);
            }
        }
        System.out.println(map);
        
    }
}
