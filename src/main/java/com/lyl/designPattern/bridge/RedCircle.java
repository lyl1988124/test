package com.lyl.designPattern.bridge;

/**
 * Created by lyl
 * Date 2019/1/6 13:46
 */
public class RedCircle implements DrawAPI{
    @Override
    public void drawCircle() {
        System.out.println("Draw red circle");
    }
}