package com.lyl.learn.designPattern.visitor.iface;

import com.lyl.learn.designPattern.visitor.iface.impl.IncomeBill;
import com.lyl.learn.designPattern.visitor.iface.impl.ConsumeBill;

/**
 * Created by lyl on 2017/4/25.
 */
public interface AccountBookViewer {
    //查看消费单子
    void view(ConsumeBill bill);

    //查看收入单子
    void view(IncomeBill bill);
}
