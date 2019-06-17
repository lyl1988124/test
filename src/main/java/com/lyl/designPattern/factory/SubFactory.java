package com.lyl.designPattern.factory;

import com.lyl.designPattern.factory.IFactory;
import com.lyl.designPattern.factory.Operation;
import com.lyl.designPattern.factory.OperationSub;

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
