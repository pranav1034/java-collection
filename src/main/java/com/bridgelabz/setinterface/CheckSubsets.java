package com.bridgelabz.setinterface;
import java.util.*;

public class CheckSubsets {
    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> set2=new HashSet<>(Arrays.asList(1,2,3,4,5));
        if(isSubset(set1,set2)){
            System.out.println("Set1 is subset of Set2");
        }
        else {
            System.out.println("Set1 is not subset of Set2");
        }
    }
    public static boolean isSubset(Set<Integer> set1, Set<Integer> set2){
        //boolean flag=false;
        for(int i:set1){
            if(!set2.contains(i))
                return false;
        }
        return true;
    }
}
