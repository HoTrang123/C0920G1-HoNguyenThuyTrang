package _06_ke_thua.bai_tap.circle_va_lop_cylinder;

public class Circle {
    private double radius ;
    private String color ;

    Circle(){

    }
    Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getAria() {
        return Math.pow(radius,2)*Math.PI;
    }
    public String toString() {
            return "A Circle with radius: "
                    + getRadius()
                    + " and color:"
                    + getColor();
    }
}
class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle = new Circle(3, "red");
        System.out.println(circle.toString());
    }
}
