package com.bridgelabz.setinterface;
import java.util.*;

public class UnionAndIntersection {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3,4,5));

        Set<Integer> unionSet = findUnion(set1,set2);
        Set<Integer> intersectionSet = findIntersection(set1,set2);

        System.out.println("Union of sets:"+unionSet);
        System.out.println("Intersection of sets:"+intersectionSet);
    }
    public static Set<Integer> findUnion(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> result= new HashSet<>(set1);
        for(int i : set2){
            if(!set1.contains(i)){
                result.add(i);
            }
        }
        return result;
    }
    public static Set<Integer> findIntersection(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> result= new HashSet<>();
        for(int i : set2){
            if(set1.contains(i)){
                result.add(i);
            }
        }
        return result;
    }
}
