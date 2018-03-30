package com.learningsJava;

import java.util.*;

public class GenericMethod {
    public static <E extends Comparable<E>> List<E> removeDuplicates(List<E> list) {
        List<E> newList = new ArrayList<>();
        Set<E> newSet = new HashSet<>();
        list.forEach(e->newSet.add(e));
        newSet.forEach(e->newList.add(e));
        return newList;
    }

    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        numList.add(10);
        numList.add(10);
        numList.add(20);
        List<String> stringList;
        stringList= Arrays.asList("","","aaa","sss","bbb","aaa");
        System.out.println(removeDuplicates(stringList));
        System.out.println(removeDuplicates(numList));
    }
}
