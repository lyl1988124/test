package com.lyl.work.sensitiveInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p> Licence     : (C) Copyright 2019-2022, RSSZ Xi'an
 * <p> Description : JavaBeanA
 *
 * @author : liuyuanlong
 * @date : 2022/6/23 15:07
 */
public class JavaBeanA {

    public JavaBeanA() {
    }

    public JavaBeanA(String name, JavaBeanB b) {
        this.name = name;
        this.b = b;
    }

    @SensitiveInfo(type= SensitiveInfoUtils.SensitiveType.CHINESE_NAME)
    private String name = "A先生";

    private JavaBeanB b;

    private Date date;

    private List<JavaBeanB> list;

    private Map<String,JavaBeanB> map;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JavaBeanB getB() {
        return b;
    }

    public void setB(JavaBeanB b) {
        this.b = b;
    }

    public List<JavaBeanB> getList() {
        return list;
    }

    public void setList(List<JavaBeanB> list) {
        this.list = list;
    }

    public Map<String, JavaBeanB> getMap() {
        return map;
    }

    public void setMap(Map<String, JavaBeanB> map) {
        this.map = map;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
