package com.lyl.test.listpage;

import org.python.google.common.collect.Lists;
import org.python.google.common.collect.Maps;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p> Licence     : (C) Copyright 2019-2021, ZettaCloud Xi'an
 * <p> Description :
 *
 * @author : liuyuanlong
 * @date : 2022/1/27 13:40
 */
public class ListToPage {

    public static void main(String[] args) {

        File rootDir = new File("C:\\Users\\lyl\\Desktop\\test");

        File[] files = rootDir.listFiles();

        List<FileResource> fileResourceList = Lists.newArrayList();

        Pattern r = Pattern.compile("shp|shx|prj|dbf|sbx|sbn|cpg");

        Map<String, List<String>> fileMap = Maps.newHashMap();
        for (File file : files) {

            String name = file.getName();
            if (!name.contains(".")) {
//
//                FileResource fileResource = new FileResource();
//                fileResource.setFileName(file.getName());
//                fileResource.setFilePath(file.getPath());
//                fileResource.setType("dir");
//                fileResourceList.add(fileResource);

                continue;
            }
            String fileName = name.substring(0, name.lastIndexOf("."));
            String fileExt = name.substring(name.lastIndexOf(".") + 1);

            Matcher m = r.matcher(fileExt);

            if (m.find()) {
                 System.out.println("match:" + fileExt);

                if (null == fileMap.get(fileName)) {
                    List<String> fileGroup = Lists.newArrayList();
                    fileGroup.add(file.getPath());
                    fileMap.put(fileName, fileGroup);

                } else {
                    fileMap.get(fileName).add(file.getPath());
                }

                if (!"shp".equals(fileExt)) {
                    continue;
                }
            }

            //System.out.println();
            FileResource fileResource = new FileResource();
            fileResource.setFileName(fileName);
            fileResource.setFilePath(file.getPath());
            fileResource.setType("file");
            fileResourceList.add(fileResource);
        }

        for(FileResource fileResource : fileResourceList){
            if(null != fileMap.get(fileResource.getFileName())){
                fileResource.setFileGroup(fileMap.get(fileResource.getFileName()));
                fileResource.setType("group");
            }

            System.out.println(fileResource.getFilePath()+" "+fileResource.getType());
            System.out.println(fileResource.getFileGroup());
        }


        List<String> testList = Lists.newArrayList();

        for (int i = 1; i <= 7; i++) {
            testList.add(i + "");
        }

        int pageNum = 3;
        int pageSize = 3;
        int totalCount = testList.size();

        int fromIndex = (pageNum - 1) * pageSize;
        int toIndex = pageNum * pageSize;

        //System.out.println(testList);

//        if (totalCount < toIndex) {
//            toIndex = totalCount;
//        }
        toIndex = Math.min(toIndex, totalCount);

        testList = testList.subList(fromIndex, toIndex);

        //System.out.println("fromIndex:" + fromIndex + " " + "toIndex:" + toIndex);
        //System.out.println(testList);

    }
}
