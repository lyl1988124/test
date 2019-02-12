package com.lyl.test;

import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.math.BigInteger;

/**
 * Created by lylXXXXW
 * Date 2019/1/30 16:00
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Pet {
    @AliasFor("user")
    long owner() default 1;
    @AliasFor("owner")
    long user() default 1;
    int name() default 1;
}
@Pet(user = 34)
class MyPet {}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Pet(owner = 2)
@interface Dog {
    @AliasFor(annotation = Pet.class, attribute = "name")
    int name() default 0;
}
@Dog()
class MyDog {}


public class TestAliasFor {
    public static void main(String[] args) throws Exception {
        AnnotationAttributes attributes1 = AnnotatedElementUtils.getMergedAnnotationAttributes(MyPet.class, Pet.class);
        System.out.println(attributes1);

        AnnotationAttributes attributes = AnnotatedElementUtils.getMergedAnnotationAttributes(MyDog.class, Pet.class);
        System.out.println(attributes);
        attributes = AnnotatedElementUtils.getMergedAnnotationAttributes(MyDog.class, Dog.class);
        System.out.println(attributes);
    }
}
