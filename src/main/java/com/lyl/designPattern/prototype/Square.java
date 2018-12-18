package com.lyl.designPattern.prototype;

/**
 * Created by lyl
 * Date 2018/12/18 10:04
 */
public class Square extends Shape {

    public Square() {
        type="Square";
    }

    @Override
    void draw() {
        System.out.println("draw Square()");
    }
}
