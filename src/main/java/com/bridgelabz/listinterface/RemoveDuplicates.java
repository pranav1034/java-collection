package com.bridgelabz.listinterface;
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>(Arrays.asList(3,1,2,2,3,4));
        System.out.println("List before removing duplicates:");
        System.out.println(list);

        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<list.size();i++){
            if(!set.contains(list.get(i))){
                set.add(list.get(i));
            }
            else {
                list.remove(i);
                i--;
            }
        }
        System.out.println("List after removing duplicates:");
        System.out.println(list);
    }
}
