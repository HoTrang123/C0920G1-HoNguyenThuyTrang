package _06_ke_thua.bai_tap.point2D_va_point3D;

import java.util.Arrays;

public class Point3D extends Point2D {
    private double z;
    Point3D(){

    }
    Point3D(double z){
       this.z = z;
    }
    Point3D(double x, double y, double z){
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    public double[] getXYZ(){
        double[] arr2 = new double[3];
        arr2[0] = getX();
        arr2[1] = getY();
        arr2[2] = getZ();
        return arr2;
    }
    public String toString() {
        return "Point3D{" +
                "z=" + z +
                ", arr2=" + Arrays.toString(getXYZ()) +
                '}';
    }
}
class Point3DTest {
    public static void main(String[] args) {
        Point3D point3D = new Point3D();
        point3D = new Point3D(3,4,5);
        System.out.println(point3D.toString());
    }
}
