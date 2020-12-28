package com.hackerDS.stacks;

import java.util.ArrayList;
import java.util.Scanner;

public class MaximumElement {
    //https://www.hackerrank.com/challenges/maximum-element/problem
    static class Entry {
        int value;
        int max;

        Entry(int value, int max) {
            this.value = value;
            this.max = max;
        }
    }

    public static ArrayList<Entry> array;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int items = sc.nextInt();
        array = new ArrayList<>();
        for (int i = 0; i < items; i++) {
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    pushInArray(sc.nextInt());
                    break;
                case 2:
                    deleteElement();
                    break;
                case 3:
                    maxElement();
                    break;
                default:
                    break;
            }
        }
    }

    private static void pushInArray(int nextInt) {
        if (!array.isEmpty()) {
            if (nextInt < array.get(array.size() - 1).max) {
                array.add(new Entry(nextInt, array.get(array.size() - 1).max));
            } else {
                array.add(new Entry(nextInt, nextInt));
            }
        } else {
            array.add(new Entry(nextInt, nextInt));
        }
    }

    private static void deleteElement() {
        if (!array.isEmpty()) {
            int index = array.size() - 1;
            array.remove(index);
        }
    }

    private static void maxElement() {
        if (!array.isEmpty()) {
            System.out.println(array.get(array.size() - 1).max);
        }
    }
}
