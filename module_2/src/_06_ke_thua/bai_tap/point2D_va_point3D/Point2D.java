package _06_ke_thua.bai_tap.point2D_va_point3D;

import java.util.Arrays;

public class Point2D {
    private double x;
    private double y;
    Point2D (){

    }
    Point2D (double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    public double[] getXY(){
        double[] arr = new double[2];
        arr[0] = getX();
        arr[1] = getY();
        return arr;
    }
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                ", arr=" + Arrays.toString(getXY()) +
                '}';
    }
}
 class Point2DTest {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        point2D = new Point2D(3,4);
        System.out.println(point2D.toString());
    }
}
