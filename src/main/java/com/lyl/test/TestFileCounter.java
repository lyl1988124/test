package com.lyl.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**

 * <p> Description :
 *
 * @author : liuyuanlong
 * @date : 2021/12/7 19:38
 */
public class TestFileCounter {

    public static void main(String[] args) throws JsonProcessingException {
        String path = "C:\\Users\\lyl\\Desktop\\test\\idps-test.tif";
        File file = new File(path);
        Long size = FileUtils.sizeOfDirectory(file);
        System.out.println(size);
        System.out.println(size/1024/1024);
    }

    void start(){
        threadPoolExecutor.submit(this::dirFileNum3);
        threadPoolExecutor.submit(this::dirFileNum3);
        while (true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(count);
        }
    }


    public Long dirFileNum(String path) {
        return dirFileNum(path, 0);
    }

    public static Long dirFileNum(String path,long cnt) {
        long count = cnt;
        File file = new File(path);
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                count= dirFileNum(f.getPath(),count);
            }
        } else {
            count += 1;
        }
        return count;
    }


    private final ExecutorService threadPoolExecutor =
        new ThreadPoolExecutor(
            4,
            4,
            10,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(1),
            new ThreadFactoryBuilder().setNameFormat("Test-%s").build());

    long count = 0;
    public void dirFileNum3() {

            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        String path = "C:\\Users\\lyl\\Desktop\\test";
        File file = new File(path);
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                count= dirFileNum(f.getPath(),count);
            }
        } else {
            count += 1;
        }
       // return count;
    }
}
