package _06_ke_thua.bai_tap.point_va_moveable_point;

import java.util.Arrays;

public class MoveablePoint extends Point {
    private float xSpeed;
    private float ySpeed;

    public MoveablePoint (){

    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public float[] getSpeed() {
        float[] arr2 = new float[2];
        arr2[0] = getxSpeed();
        arr2[1] = getySpeed();
        return arr2;
    }

    public void setSpeed(float xSpeed,float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return Arrays.toString(getXY()) + ", speed = "  + Arrays.toString(getSpeed()) ;
    }

    MoveablePoint move(){
        super.setX(getX() + getxSpeed());
        super.setY(getY() + getySpeed());
        return this;
    }
}
