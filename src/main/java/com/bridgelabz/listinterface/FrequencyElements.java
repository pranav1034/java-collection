package com.bridgelabz.listinterface;
import java.util.*;

public class FrequencyElements {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>(Arrays.asList("apple","banana","apple","orange","banana","apple"));
        System.out.println("List of elements:");
        System.out.println(list);

        LinkedHashMap<String, Integer> map=new LinkedHashMap<>();
        for (String s : list) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        System.out.println(map);

    }
}
