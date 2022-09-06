package com.lyl.learn.designPattern.prototype;

/**
 * Created by lyl
 * Date 2018/12/18 21:27
 */
public class PrototypePatternDemo {

    public static void main(String[] args) {
        ShapeCache.loadCache();
        Shape clonedShape = (Shape) ShapeCache.getShape("1");
        Shape clonedShape2 = (Shape) ShapeCache.getShape("1");
        System.out.println(clonedShape.getClass()==clonedShape2.getClass());
        System.out.println("Shape : " + clonedShape.getType());

        MyPrototype myPrototype = new MyPrototype();
        myPrototype.setName(" aaa");

        myPrototype.dosplay();
    }
}
