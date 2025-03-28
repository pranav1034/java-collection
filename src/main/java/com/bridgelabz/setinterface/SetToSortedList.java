package com.bridgelabz.setinterface;
import java.util.*;

public class SetToSortedList {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(3,2,1,4,5));
        List<Integer> sortedList = setToSortedList(set);
        System.out.println("Sorted list:"+sortedList);
    }
    public static List<Integer> setToSortedList(Set<Integer> set){
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        return sortedList;
    }
}
