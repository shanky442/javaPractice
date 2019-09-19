package com.learningsJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaList {
    //https://www.hackerrank.com/challenges/java-list/problem
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfElements = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<noOfElements;i++) {
            list.add(sc.nextInt());
        }
        int noOfQueries = sc.nextInt();
        for(int j=0;j<noOfQueries;j++) {
            String operation = sc.next();
            if(operation.equals("Insert")) {
                int index=sc.nextInt();
                int elem = sc.nextInt();
                list.add(index,elem);
            }
            if(operation.equals("Delete")) {
                int index=sc.nextInt();
                list.remove(index);
            }
        }
        for(int item:list) {
            System.out.print(item+" ");
        }
    }
}
