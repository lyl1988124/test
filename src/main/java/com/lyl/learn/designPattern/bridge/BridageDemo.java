package com.lyl.learn.designPattern.bridge;

/**
 * Created by lyl
 * Date 2019/1/6 14:16
 */
public class BridageDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(1,2,3,new RedCircle());
        redCircle.draw();
    }
}
