package com.bridgelabz.mapinterface;
import java.util.*;

public class MergeTwoMaps {
    public static void main(String[] args) {
        // Input maps
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Merge maps
        Map<String, Integer> mergedMap = mergeMaps(map1, map2);

        // Display result
        System.out.println("Merged Map: " + mergedMap);
    }

    public static <K> Map<K, Integer> mergeMaps(Map<K, Integer> map1, Map<K, Integer> map2) {
        Map<K, Integer> merged = new HashMap<>(map1); // Copy map1 into merged map

        for (Map.Entry<K, Integer> entry : map2.entrySet()) {
            merged.put(entry.getKey(), merged.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }

        return merged;
    }
}
