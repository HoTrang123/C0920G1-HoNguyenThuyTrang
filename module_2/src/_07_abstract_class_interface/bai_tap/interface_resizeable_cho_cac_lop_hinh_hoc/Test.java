package _07_abstract_class_interface.bai_tap.interface_resizeable_cho_cac_lop_hinh_hoc;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(1);
        shapes[1] = new Rectangle();
        shapes[2] = new Square();

        for (Shape shape: shapes){
            shape.resize(100);
        }

        System.out.println(Arrays.toString(shapes));
    }
}
