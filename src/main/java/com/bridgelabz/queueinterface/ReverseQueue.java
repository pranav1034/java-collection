package com.bridgelabz.queueinterface;
import java.util.*;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        System.out.println("Original queue:"+q);
        int n=q.size();
        reverseQueue(q,n);
        System.out.println("Reversed queue:"+q);
    }
    public static void reverseQueue(Queue<Integer> q, int n){
        if(q.isEmpty()) return;
        int front=q.remove();
        reverseQueue(q,n);
        q.add(front);
    }
}
