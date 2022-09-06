package com.lyl.learn.designPattern.factory;

/**
 * Created by lyl
 * Date 2019/5/28 19:55
 */
public class AddFactory implements IFactory {

    @Override
    public Operation createOperation() {
        return new AddOperation();
    }
}
