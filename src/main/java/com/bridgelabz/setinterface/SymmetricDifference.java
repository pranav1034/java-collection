package com.bridgelabz.setinterface;
import java.util.*;

public class SymmetricDifference {
    public static void main(String[] args) {
        // Create two sets
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3,4,5));

        // Find symmetric difference of two sets
        Set<Integer> symmetricDifferenceSet = findSymmetricDifference(set1,set2);

        // Print symmetric difference of two sets
        System.out.println("Symmetric difference of sets:"+symmetricDifferenceSet);
    }
    public static Set<Integer> findSymmetricDifference(Set<Integer> set1, Set<Integer> set2){
        Set<Integer> result= new HashSet<>();
        for(int i : set1){
            if(!set2.contains(i)){
                result.add(i);
            }
        }
        for(int i : set2){
            if(!set1.contains(i)){
                result.add(i);
            }
        }
        return result;
    }
}
