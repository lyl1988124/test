package com;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws IOException {
        String path = "E:\\tools\\ftp\\遥感影像智能解译平台-2.1容器化-部署手册.pdf";

        String newName = new String("新遥感影像智能解译平台-2.1容器化-部署手册.pdf".getBytes(),"UTF-8");
        System.out.println(newName);

        File oldFile =new File(path);
        File newfile=new File(oldFile.getParent()+File.separator+newName);//创建新名字的抽象文件

        FileUtils.copyFile(oldFile,newfile);

        System.out.println(newfile.getPath());
    }
}
