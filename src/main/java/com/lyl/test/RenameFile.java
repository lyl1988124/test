package com.lyl.test;

import java.io.*;

public class RenameFile {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\lyl\\Desktop\\test\\note.txt");

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String line;

            while ((line=bufferedReader.readLine())!=null){
                System.out.println(line);
                int idx = line.indexOf(":")+1;

                if(idx>-1){
                    System.out.println("idx:"+idx);
                    line = line.substring(idx);
                    String[] versions = line.split(",");

                    for(String str : versions){
                        System.out.println(str);



                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        File reFile = new File("C:\\Users\\lyl\\Desktop\\rename");
//        Path path = reFile.toPath();
//
//        file.renameTo(reFile);
//
//        File targetFile = new File("C:\\Users\\lyl\\Desktop\\testNew");
       // Path targetPath = targetFile.toPath();

//        try {
//            file.renameTo(reFile);
//            Files.move(path,targetPath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



    }
}
