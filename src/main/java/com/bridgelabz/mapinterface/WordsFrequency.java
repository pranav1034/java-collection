package com.bridgelabz.mapinterface;
import java.util.*;

public class WordsFrequency {
    public static void main(String[] args) {
        String str = "to be or not to be";
        String[] words = str.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for(String word:words){
            if(map.containsKey(word)){
                map.put(word, map.get(word)+1);
            }
            else {
                map.put(word, 1);
            }
        }
        System.out.println("Words frequency:"+map);
    }
}
