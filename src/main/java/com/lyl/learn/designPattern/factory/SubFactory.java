package com.lyl.learn.designPattern.factory;

/**
 * Created by lyl
 * Date 2019/5/28 20:08
 */
public class SubFactory implements IFactory {

    @Override
    public Operation createOperation() {
        return new OperationSub();
    }
}
