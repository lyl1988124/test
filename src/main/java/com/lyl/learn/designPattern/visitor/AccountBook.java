package com.lyl.learn.designPattern.visitor;

import com.lyl.learn.designPattern.visitor.iface.AccountBookViewer;
import com.lyl.learn.designPattern.visitor.iface.Bill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyl on 2017/4/25.
 */
public class AccountBook {
    //单子列表
    private List<Bill> billList = new ArrayList<Bill>();
    //添加单子
    public void addBill(Bill bill){
        billList.add(bill);
    }
    //供账本的查看者查看账本
    public void show(AccountBookViewer viewer){
        for (Bill bill : billList) {
            bill.accept(viewer);
        }
    }
}
