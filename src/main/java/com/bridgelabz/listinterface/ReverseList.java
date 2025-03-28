package com.bridgelabz.listinterface;
import java.util.*;

public class ReverseList {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        System.out.println("Enter the size:");
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();

        System.out.println("Enter the elements for the list:");
        for(int i=0;i<size;i++){
            list.add(sc.nextInt());
        }
        System.out.println("ArrayList before reversing:");
        System.out.println(list);
        reverseArrayList(list);
        System.out.println("\nArrayList after reversing:");
        System.out.println(list);

        List<Integer> linkedList=new LinkedList<>(Arrays.asList(1,2,3,4,5));
        System.out.println("\nLinkedList before reversing:");
        System.out.println(linkedList);
        reverseArrayList(linkedList);
        System.out.println("\nLinkedList after reversing:");
        System.out.println(linkedList);

    }
    public static List<Integer> reverseArrayList(List<Integer> list){
        int start=0;
        int end=list.size()-1;
        while(start<end){
            int temp=list.get(start);
            list.set(start,list.get(end));
            list.set(end,temp);
            start++;
            end--;
        }
        return list;
    }
}
