package com.lyl.learn.designPattern.prototype;

/**
 * Created by lyl
 * Date 2018/12/18 10:04
 */
public class Rectangle extends Shape {

    public Rectangle() {
        type="Rectangle";
    }

    @Override
    void draw() {
        System.out.println("draw Rectangle()");
    }
}
