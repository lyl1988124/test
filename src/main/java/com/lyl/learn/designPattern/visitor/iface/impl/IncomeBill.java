package com.lyl.learn.designPattern.visitor.iface.impl;

import com.lyl.learn.designPattern.visitor.iface.AccountBookViewer;
import com.lyl.learn.designPattern.visitor.iface.Bill;

/**
 * Created by lyl on 2017/4/25.
 */
public class IncomeBill implements Bill {

    private double amount;
    private String item;

    public IncomeBill(double amount, String item) {
        super();
        this.amount = amount;
        this.item = item;
    }

    public void accept(AccountBookViewer viewer) {
        viewer.view(this);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
