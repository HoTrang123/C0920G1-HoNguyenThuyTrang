package _06_ke_thua.bai_tap.circle_va_lop_cylinder;

public class Cylinder extends Circle{
    private double height;
     Cylinder (){

     }
     Cylinder(double height){
         this.height = height;

     }
     Cylinder (double height, double radius, String color){
         super(radius,color);
         this.height = height;
     }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return getAria()*height;
    }
    public String toString() {
        return "A Cylinder with height="
                + getHeight()
                + ", which is a subclass of "
                + super.toString()
                +", volume is: "
                + getVolume();
    }
}
class CylinderTest {
    public static void main(String[] args) {
    Cylinder cylinder= new  Cylinder();
        cylinder = new Cylinder(6, 5, "blue");
        System.out.println(cylinder.toString());
    }
}
