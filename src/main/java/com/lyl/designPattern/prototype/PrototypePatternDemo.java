package com.lyl.designPattern.prototype;

/**
 * Created by lyl
 * Date 2018/12/18 21:27
 */
public class PrototypePatternDemo {

    public static void main(String[] args) {
        ShapeCache.loadCache();
        Shape clonedShape = (Shape) ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());
    }
}
