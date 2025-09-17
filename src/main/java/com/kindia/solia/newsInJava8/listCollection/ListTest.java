package com.kindia.solia.newsInJava8.listCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListTest {

    public static void newInListCollection(){
        // forEach

        // removeIf
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        List<Integer> list = new ArrayList<>(integerList);
        boolean b = list.removeIf( i -> i > 3);
        System.out.println(list);

        List<String> strList = Arrays.asList("zzz","aaaaa","fff","dd","q");
        List<String> strListmod = new ArrayList<>(strList);
        strListmod.sort(Comparator.naturalOrder());
        System.out.println(strListmod);
    }
}
