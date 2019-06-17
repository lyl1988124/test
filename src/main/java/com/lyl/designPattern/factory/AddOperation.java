package com.lyl.designPattern.factory;

import org.python.antlr.ast.If;

/**
 * Created by lyl
 * Date 2019/5/28 20:01
 */
public class AddOperation extends Operation {
    @Override
    protected double getResule() {
        return getValue1()+getValue2();
    }
}
