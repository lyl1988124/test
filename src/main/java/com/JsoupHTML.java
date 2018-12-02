package com;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * Created by lyl on 2017/4/25.
 */
public class JsoupHTML {
    public static void main(String[] args) {
        //获取页面对象
        String startPage="https://www.baidu.com";

        Document document = null;
        try {
            document = Jsoup.connect(startPage).userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

//定位元素父级
        Element parentElement = document.getElementById("u");

//定位具体元素
        Element titleElement = parentElement.getElementsByTag("a").get(2);

//获取所需数据
        String title = titleElement.text();

        System.out.println(title);
    }
}

