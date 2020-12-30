package _05_access_modifier_static.thuc_hanh.acces_modifier._default.mypack;
import _05_access_modifier_static.thuc_hanh.acces_modifier._default.pack.A;
public class B {
    public static void main(String args[]){

        A obj = new A();//Compile Time Error

        obj.msg();//Compile Time Error

    }
}
