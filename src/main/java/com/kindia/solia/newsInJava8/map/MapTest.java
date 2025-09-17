package com.kindia.solia.newsInJava8.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void mapManage (){
        Map<String, String> map = new HashMap<>();
        map.forEach((k, v) -> System.out.println(k + "->" + v));
        map.replace("", "");
        // map.merge() test
        // map.computeIfAbsent() test
        // map.computeIfPresent() test
        // map.putIfAbsent()
        // map.replaceAll();
    }
}
