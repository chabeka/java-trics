package com.kindia.solia.newsInJava8.string;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class StringTest {

    public static void strManagement(){

        String str = "bonjour";

        IntStream strStream = str.chars();
        //strStream.map(String::toUpperCase).forEach(System.out::print);
        StringJoiner stringJoiner = new StringJoiner(",");
        stringJoiner.add("aaa").add("bbb").add("ccc");
        System.out.println(stringJoiner.toString());
        List<String> stringList = Arrays.asList("1", "2", "3", "4");
        String join = String.join("...", stringList);
        System.out.println(join);
    }
}
