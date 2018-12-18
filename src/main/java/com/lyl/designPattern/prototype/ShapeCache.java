package com.lyl.designPattern.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyl
 * Date 2018/12/18 21:20
 */
public class ShapeCache {

    private static  Map<String,Shape> shapeMap= new HashMap<>();

    public static Shape getShape(String shapeId){
        Shape shape = shapeMap.get(shapeId);
        try {
            return (Shape) shape.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void loadCache() {
        Rectangle rectangle = new Rectangle();
        rectangle.setId("1");
        shapeMap.put(rectangle.getId(),rectangle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(),square);

        Circle circle = new Circle();
        circle.setId("3");
        shapeMap.put(circle.getId(),circle);
    }
}
