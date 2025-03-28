package com.bridgelabz.listinterface;
import java.util.*;

public class RotateList {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>(Arrays.asList(1,2,3,4,5));
        int position =2;
        System.out.println("List before rotating:");
        System.out.println(list);
        rotateList(list,position);
    }
    public static void rotateList(List<Integer> list,int position){
        List<Integer> list2=new ArrayList<>();
        for(int i=position;i<list.size();i++){
            list2.add(list.get(i));
        }
        for(int i=0;i<position;i++){
            list2.add(list.get(i));
        }
        System.out.println("List after rotating:");
        System.out.println(list2);
    }
}
