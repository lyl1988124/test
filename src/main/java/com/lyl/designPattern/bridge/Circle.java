package com.lyl.designPattern.bridge;

/**
 * Created by lyl
 * Date 2019/1/6 14:01
 */
public class Circle extends Shape{
    private int x, y, radius;

    public Circle(int x, int y, int radius,DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle();
    }
}
