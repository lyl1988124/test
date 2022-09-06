package com.lyl.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lyl on 2018/11/6.
 */
public class Lambda {

    public static void main(String[] args) {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};

        List<Object> players = Arrays.asList(atp);

        //players.forEach((player) -> System.out.println(player));




        players.forEach(System.out::println);

    }
}
