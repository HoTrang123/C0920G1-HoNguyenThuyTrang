package _05_access_modifier_static.bai_tap.access_modifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";
    Circle (){

    }
    Circle (double radius){

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getAria() {
        return Math.pow(radius,2)*Math.PI;
    }
}
 class TestCircle{
     public static void main(String[] args) {
         Circle c = new Circle(1);
         System.out.println("Radius circle " + c.getRadius() + " Area cicle " + c.getAria());
     }
 }

