package _06_ke_thua.bai_tap.point_va_moveable_point;

import java.util.Arrays;

public class Point {
    private float x;
    private float y;

    public Point(){

    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public float[] getXY() {
        float[] arr = new float[2];
        arr[0] = getX();
        arr[1] = getY();
        return arr;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public String toString() {
        return '('  + Arrays.toString(getXY()) + ')';
    }
}
