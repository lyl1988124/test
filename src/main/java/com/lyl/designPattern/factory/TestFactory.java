package com.lyl.designPattern.factory;

/**
 * Created by lyl
 * Date 2019/5/28 20:08
 */
public class TestFactory {
    public static void main(String[] args) {
        AddFactory factory  = new AddFactory();
        Operation operation = factory.createOperation();
        operation.setValue1(1);
        operation.setValue2(2);
        System.out.println(operation.getResule());

    }
}
