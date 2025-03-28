package com.bridgelabz.listinterface;
import java.util.*;

public class NthFromEnd {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int N = 2;
        System.out.println(findNthFromEnd(list, N));
    }
    public static String findNthFromEnd(LinkedList<String> list, int N) {
        if (list == null || N <= 0) return null;
        int slow = 0, fast = 0;

        for (int i = 0; i < N; i++) {
            if (fast >= list.size()) return null;
            fast++;
        }

        while (fast < list.size()) {
            slow++;
            fast++;
        }
        return list.get(slow);
    }
}
