package com.lyl.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**

 * <p> Description : 遍历文件夹
 *
 * @author : liuyuanlong
 * @date : 2021/12/20 13:23
 */
public class TestTraverseFolder {

    public static void main(String[] args) {
        TestTraverseFolder traverseFolder = new TestTraverseFolder();
        List<String> lis = new ArrayList<>();
        traverseFolder.traverseFolder("C:\\Users\\lyl\\Desktop\\test","C:\\Users\\lyl\\Desktop\\test",lis);
        //System.out.println(lis);
    }

    private void traverseFolder(String path, String parent, List<String> list){
        String thisParent = parent;
        File file = new File(path);

        if(file.isDirectory()){
            System.out.println("parent:"+ thisParent + "  thisParent: "+file.getPath());
            thisParent = file.getPath();
            for(File file1: file.listFiles()){
                traverseFolder(file1.getPath(),thisParent,list);
            }
        }else {
            System.out.println("thisParent:="+thisParent + " | old file: "+file.getPath());
            list.add("thisParent:="+thisParent + " | old file: "+file.getPath());
        }
//        if(10 ==list.size()){
//            System.out.println(list);
//            System.out.println("clean list ");
//            list.clear();
//        }
    }
}
