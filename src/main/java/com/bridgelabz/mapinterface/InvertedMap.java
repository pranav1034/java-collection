package com.bridgelabz.mapinterface;
import java.util.*;

public class InvertedMap {
    public static void main(String[] args) {
        // Input map
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        // Inverted map
        Map<Integer, List<String>> invertedMap = invertMap(originalMap);

        // Display result
        System.out.println("Inverted Map: " + invertedMap);
    }

    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> map) {
        Map<V, List<K>> inverted = new HashMap<>();

        for (Map.Entry<K, V> entry : map.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            // Add key to the list of the corresponding value
            inverted.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }

        return inverted;
    }
}

