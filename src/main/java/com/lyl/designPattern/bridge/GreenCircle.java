package com.lyl.designPattern.bridge;

/**
 * Created by lyl
 * Date 2019/1/6 13:47
 */
public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle() {
        System.out.println("draw green circle");
    }
}
