package com.lyl.attempt.serializble;

import java.io.*;

/**
 * <p> Licence     : (C) Copyright 2019-2021, ZettaCloud Xi'an
 * <p> Description :
 *
 * @author : liuyuanlong
 * @date : 2022/5/25 23:21
 */
public class SerializableTest {

    public static void main(String[] args) {
        A a = new A("a",18);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(a);
            oos.close();
            fileOutputStream.close();

            FileInputStream fileInputStream = new FileInputStream("test.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            B a2 = (B) objectInputStream.readObject();
            System.out.println(a2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
