package com.bridgelabz.listinterface;
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>(Arrays.asList(3,1,2,2,3,4));
        System.out.println("List before removing duplicates:");
        HashSet<Integer> set = new HashSet<>();
        for(int i:list){
            if(!set.contains(i)){
                System.out.print(i+" ");
            }
            set.add(i);
        }
    }
}
