package com.lyl.designPattern.bridge;

/**
 * Created by lyl
 * Date 2019/1/6 13:48
 */
public abstract class Shape {
    protected  DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI){
        this.drawAPI=drawAPI;
    }
    public abstract void draw();
}
