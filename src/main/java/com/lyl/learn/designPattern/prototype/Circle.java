package com.lyl.learn.designPattern.prototype;

/**
 * Created by lyl
 * Date 2018/12/18 10:04
 */
public class Circle extends Shape {

    public Circle() {
        type="Circle";
    }

    @Override
    void draw() {
        System.out.println("draw Circle()");
    }
}
