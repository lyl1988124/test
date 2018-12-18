package com.lyl.designPattern.prototype;

/**
 * Created by lyl
 * Date 2018/12/17 20:51
 */
public abstract class Shape implements Cloneable{

    private String id;
    protected String type;

    abstract void draw();

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
