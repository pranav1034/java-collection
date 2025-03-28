package com.bridgelabz.mapinterface;
import java.util.*;

public class KeyMaximumValue {
    public static void main(String[] args) {
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('a', 10);
        map.put('b', 20);
        map.put('c', 30);
        map.put('d', 25);
        char ans='a';
        int max=0;
        for(char c:map.keySet()){
            if(map.get(c)>max){
                max=map.get(c);
                ans=c;
            }
        }
        System.out.println(ans);
    }
}
