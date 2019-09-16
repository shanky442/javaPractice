package com.learningsJava;

import java.util.*;
public class JavaDeque {
    //https://www.hackerrank.com/challenges/java-dequeue/problem
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            set.add(num);
            if(deque.size()==m) {
                if(set.size()>max) {
                    max=set.size();
                }
                int first = (Integer)deque.pollFirst();
                if(!deque.contains(first)) {
                    set.remove(first);
                }
            }
        }
        System.out.println(max);
    }
}




