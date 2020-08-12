package com.lyl.technology.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by lyl
 * Date 2019/1/7 16:47
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IntergrationAnnotation {
    String color() default "blue";
    String value() default "vallue";

    int[] arrayAttr() default {1,2,4};
    EnumTrafficLamp lamp() default EnumTrafficLamp.YELLOW;
    MetaAnnotation annotationAttr() default @MetaAnnotation("xiaoju");
}
