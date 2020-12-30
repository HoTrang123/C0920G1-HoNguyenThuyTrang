package _09_danh_sach.bai_tap.array_list;

public class MyListTest {
    public static void main(String[] args) {
//        String[] arrStr = new String[5];
        MyList<Integer> listInteger = new MyList<>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);
        listInteger.add(5);
        listInteger.display();
        System.out.println("get element 1: "+listInteger.get(1));
        listInteger.display();

        System.out.println( "remove" +
                ""+listInteger.remove(2));
        listInteger.display();


    }
}