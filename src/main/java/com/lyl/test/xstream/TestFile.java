package com.lyl.test.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import org.apache.commons.io.FileUtils;

import java.io.IOException;

/**
 * <p> Licence     : (C) Copyright 2019-2021, ZettaCloud Xi'an
 * <p> Description :
 *
 * @author : liuyuanlong
 * @date : 2022/1/18 14:04
 */
public class TestFile {

    public static void main(String[] args) throws IOException {

        java.io.File file =  new java.io.File("D:\\working\\Function-Test-Data\\detect\\jpg-xml@bzjl\\labels\\first.TIF_6400_20000.xml");
        String content = FileUtils.readFileToString(file);
        System.out.println(content);

        XStream xStream = new XStream();
        xStream.alias("doc",Doc.class);
        xStream.addPermission(AnyTypePermission.ANY);
        Doc doc = (Doc) xStream.fromXML(content);
        System.out.println(doc.getLabeled());
       // xStream.alias("doc",XmlFile.class);


    }
}
