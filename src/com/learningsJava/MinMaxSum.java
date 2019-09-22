package com.learningsJava;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        int min = arr[0];
        int max = Integer.MIN_VALUE;
        long minSum = 0;
        long maxSum=0;
        for(int i:arr) {
            if(i<min) {
                min = i;
            }
            if(i>max) {
                max=i;
            }
        }
        System.out.print(min + "min max "+ max);
        boolean flag = false;
        boolean maxFlag = false;
        for(int i:arr) {
            if(!(i == min) || flag == true) {
                maxSum =maxSum + i;
            } else {
                flag = true;
            }
            if(!(i== max) || maxFlag == true) {
                minSum = minSum + i;
            } else {
                maxFlag = true;
            }
        }
        System.out.print(minSum + " " + maxSum);


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
