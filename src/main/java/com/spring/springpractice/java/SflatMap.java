package com.spring.springpractice.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SflatMap
 * Study Stream FlatMap
 */
public class SflatMap {


    public static void main(String[] args) {
        String[][] nested = new String[][]{ {"Apple", "Cherry"}, {"Mango", "Orange"}, {"Grape", "BlueBerry"}};

        List<String> fruits = new ArrayList<>();

        for (String[] fs : nested) {
            for (String f : fs) {
                if(!f.equals("Apple")) fruits.add(f);
            }
        }

        String[] exclude = fruits.toArray(new String[0]);
        System.out.println(Arrays.toString(exclude));


        List<String> fruits1 = Arrays.stream(nested)
                .flatMap(Arrays::stream) //<- Stream 타입을 리턴
                .filter(f -> !f.equals("Apple"))
                .toList();

        fruits1.forEach(System.out::println);
    }
}
