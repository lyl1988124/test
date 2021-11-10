package com.lyl.test.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

/**
 * <p> Licence     : (C) Copyright 2019-2021, ZettaCloud Xi'an
 * <p> Description :
 *
 * @author : liuyuanlong
 * @date : 2021/11/9 15:56
 */
public class TestXStream {

    public static void main(String[] args) {
        User user = new User("lanweihong", "lwhhhp@gmail.com");

        //创建解析XML对象
        XStream xStream = new XStream();
        //设置别名, 默认会输出全路径
        xStream.alias("User", User.class);
        //转为xml
        String xml = xStream.toXML(user);
        System.out.println(xml);

        xStream.addPermission(AnyTypePermission.ANY);

        User user2 = (User)xStream.fromXML(xml);
        System.out.println(user2.toString());
    }
}
