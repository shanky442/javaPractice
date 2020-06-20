package com.hackerDS.arrays;

import java.util.Scanner;

public class LeftRotation {
    //https://www.hackerrank.com/challenges/array-left-rotation/problem
    static int[] leftShift(int[] inputArray, int rotations) {
        int j=0;
        int[] targetArray = new int[inputArray.length];
        for(int i=rotations;j<inputArray.length;j++) {
            targetArray[j]=inputArray[i];
            //System.out.print(inputArray[i]+" ");
            if(i+1 == inputArray.length) {
                i=0;
            } else {
                i++;
            }
        }
        return targetArray;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        int rots = d;
        if(a.length<d) {
            rots = d % a.length;
        }

        int[] finalArray = new int[a.length];
        if(rots == 0) {
            finalArray = a;
        } else {
            finalArray = leftShift(a,d);
        }
        //System.out.println(finalArray);
        for(int i:finalArray) {
            System.out.print(i+" ");
        }

        scanner.close();
    }
}
