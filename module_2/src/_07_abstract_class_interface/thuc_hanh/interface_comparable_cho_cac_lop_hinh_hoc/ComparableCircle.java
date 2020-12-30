package _07_abstract_class_interface.thuc_hanh.interface_comparable_cho_cac_lop_hinh_hoc;
import _06_ke_thua.thuc_hanh.he_cac_doi_tuong_hinh_hoc.Circle;

public class ComparableCircle extends Circle
        implements Comparable<ComparableCircle> {

    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    public double getArea(){
        double area = getRadius()*Math.PI;
        return area;
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (getArea() > o.getArea()) return 1;
        else if (getArea() < o.getArea()) return -1;
        else return 1;
    }
}
