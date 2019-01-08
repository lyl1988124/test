package com.lyl.annotation;

/**
 * Created by lyl
 * Date 2019/1/7 16:24
 */
@ColorAnnotation(color="blue")
public class ColorAnnotationUse {
    public static void main(String[] args) {
        ColorAnnotation colorAnnotation = ColorAnnotationUse.class.getAnnotation(ColorAnnotation.class);
        System.out.println(colorAnnotation.color());
    }
}
