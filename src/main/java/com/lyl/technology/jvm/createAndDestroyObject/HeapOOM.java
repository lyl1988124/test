package com.lyl.technology.jvm.createAndDestroyObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyl
 * Date 2019/12/11 19:47
 *
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 * -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
 *
 * 1. -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
