package com.lyl.learn.designPattern.iterator;

/**
 * Created by lyl
 * Date 2018/12/16 20:01
 */
public class IteratorPatternDemo {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();
        while (nameRepository.getIterator().hasNext()){
           // System.out.println(nameRepository.getIterator().next());
            nameRepository.getIterator().next();
        }
        System.out.print("nnn");
    }
}
