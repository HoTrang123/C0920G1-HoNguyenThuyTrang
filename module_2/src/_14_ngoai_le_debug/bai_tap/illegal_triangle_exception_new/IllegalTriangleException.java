package _14_ngoai_le_debug.bai_tap.illegal_triangle_exception_new;

public class IllegalTriangleException extends Exception{
    public IllegalTriangleException(double side) {
        super(side + " Lỗi tổng 2 cạnh bé hơn cạnh còn lại");
    }
    public IllegalTriangleException(){
        super("Cạnh bé hơn 0");
    }
}