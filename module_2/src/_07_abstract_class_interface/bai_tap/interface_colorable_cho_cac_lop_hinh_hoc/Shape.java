package _07_abstract_class_interface.bai_tap.interface_colorable_cho_cac_lop_hinh_hoc;

public class Shape implements Colorable{
    private String color = "red";

    Shape(){

    }

    Shape(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                '}';
    }

    @Override
    public void howToColor() {

    }
}