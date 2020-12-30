package _07_abstract_class_interface.bai_tap.interface_colorable_cho_cac_lop_hinh_hoc;

public class Square extends Rectangle implements Colorable{
    private double side = 1;

    Square(){

    }

    Square(double side, String color){
        super(side,side,color);
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        double area = getSide() * getSide();
        return area;
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                ", area=" + getArea() +
                ", color=" + super.getColor() +
                "} ";
    }

    @Override
    public void howToColor() {
        System.out.println(">>>Color all four sides");
    }
}