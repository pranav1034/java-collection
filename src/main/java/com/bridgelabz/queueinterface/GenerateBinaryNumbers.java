package com.bridgelabz.queueinterface;
import java.util.*;

public class GenerateBinaryNumbers {
    public static void main(String[] args) {
        int N =5;
        List<String> binaryNumbers = generateBinaryNumbers(N);
        System.out.println("Binary numbers from 1 to "+N+" are:"+binaryNumbers);
    }
    public static List<String> generateBinaryNumbers(int N){
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("1");
        for(int i=1;i<=N;i++){
            String s1 = q.poll();
            result.add(s1);
            q.add(s1+"0");
            q.add(s1+"1");
        }
        return result;
    }
}
