package com.lyl.test.xstream;

/**
 * <p> Licence     : (C) Copyright 2019-2021, ZettaCloud Xi'an
 * <p> Description :
 *
 * @author : liuyuanlong
 * @date : 2022/1/18 14:06
 */
public class XmlFile {

    private Doc doc;

    public Doc getDoc() {
        return doc;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }
}

class Doc{
    private String path;
    private String time_labeled;
    private Boolean labeled;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTime_labeled() {
        return time_labeled;
    }

    public void setTime_labeled(String time_labeled) {
        this.time_labeled = time_labeled;
    }

    public Boolean getLabeled() {
        return labeled;
    }

    public void setLabeled(Boolean labeled) {
        this.labeled = labeled;
    }
}