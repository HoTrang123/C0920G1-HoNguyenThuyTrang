package _05_access_modifier_static.thuc_hanh.acces_modifier._private;

public class Private {

    public static void main(String args[]) {

        A obj = new A();

        System.out.println(obj.data);//Compile Time Error

        obj.msg();//Compile Time Error

    }
}

class A {

    protected int data = 40;

    protected void msg() {
        System.out.println("Hello java");
    }

}
