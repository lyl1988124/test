package com.lyl.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**

 * <p> Description : FileApp.java
 *
 * @author : liuyuanlong
 * @date : 2020/10/20 11:44
 */
public class FileApp {

    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("stop");
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File("stop");

        if(file.exists()){
            System.out.println("get file");
        }else {
            System.out.println("no file");
        }
    }
}
