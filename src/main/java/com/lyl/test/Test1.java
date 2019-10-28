package com.lyl.test;



import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Test1 {

    public static void main(String[] args) throws InterruptedException {

        LocalDate today = LocalDate.now();

        System.out.println(LocalDate.now());



        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
    }
}
