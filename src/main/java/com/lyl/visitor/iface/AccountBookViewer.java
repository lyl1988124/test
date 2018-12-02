package com.lyl.visitor.iface;

import com.lyl.visitor.iface.impl.ConsumeBill;
import com.lyl.visitor.iface.impl.IncomeBill;

/**
 * Created by lyl on 2017/4/25.
 */
public interface AccountBookViewer {
    //查看消费单子
    void view(ConsumeBill bill);

    //查看收入单子
    void view(IncomeBill bill);
}
