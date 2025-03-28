package com.bridgelabz.queueinterface;
import java.util.*;

public class ImplementAStack {
    Queue<Integer> q1=new LinkedList<>();
    Queue<Integer> q2=new LinkedList<>();

    public void push(int x){
        q1.add(x);
    }

    public int pop(){
        if(q1.isEmpty()) return -1;
        while(q1.size()>1){
            q2.add(q1.remove());
        }
        int topElement=q1.remove();
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
        return topElement;
    }

    public int top(){
        if (q1.isEmpty()) return -1;

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        int topElement = q1.peek(); // Get last element
        q2.add(q1.remove()); // Move last element to q2

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    public static void main(String[] args) {
        ImplementAStack stack = new ImplementAStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }

}
