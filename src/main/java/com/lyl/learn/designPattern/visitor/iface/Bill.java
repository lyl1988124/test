package com.lyl.learn.designPattern.visitor.iface;

/**
 * Created by lyl on 2017/4/25.
 */
public interface Bill {
    void accept(AccountBookViewer viewer);
}
