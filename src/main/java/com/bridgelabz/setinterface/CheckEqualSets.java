package com.bridgelabz.setinterface;
import java.util.*;

public class CheckEqualSets {
    public static void main(String[] args) {
        Set<Integer> set1= new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2= new HashSet<>(Arrays.asList(4, 2, 1, 3, 5));
        if(set1.equals(set2)){
            System.out.println("Both sets are equal");
        }
        else {
            System.out.println("Both sets are not equal");
        }
    }
}
