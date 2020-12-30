package _07_abstract_class_interface.bai_tap.interface_colorable_cho_cac_lop_hinh_hoc;

public class SquareTest {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new Square(3, "Red");
        shapes[1] = new Rectangle(3, 3, "Blue");

        for (Shape shape : shapes){
            if (shape instanceof Square){
                System.out.println(shape.toString());
                shape.howToColor();
            }else {
                System.out.println(shape.toString());
            }
        }
    }
}