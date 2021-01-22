package com;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <p> Licence     : (C) Copyright 2019-2020, ZettaCloud Xi'an
 * <p> Description : AppCtl.java
 *
 * @author : liuyuanlong
 * @date : 2020/11/3 17:49
 */
public class AppCtl {

    public static void main(String[] args) {
        File file = new File("STOP");
        String content = null;

        while (StringUtils.isBlank(content)){
            try {
                content = FileUtils.readFileToString(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("sleep");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
