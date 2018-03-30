package com.hackerAlgo;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class PlusMinus {

    /*
     * Complete the plusMinus function below.
     */
    static void plusMinus(int[] arr) {
        /*
         * Write your code here.
         */
        int countp=0;
        int countn=0;
        int countZero=0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]>0) {
                countp++;
            } else if(arr[i]<0) {
                countn++;
            } else {
                countZero++;
            }
        }
        System.out.println(String.format("%.6f",(float)countp/arr.length));
        System.out.println(String.format("%.6f",(float)countn/arr.length));
        System.out.println(String.format("%.6f",(float)countZero/arr.length));

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine().trim());

        int[] arr = new int[n];

        String[] arrItems = scan.nextLine().split(" ");

        for (int arrItr = 0; arrItr < n; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;
        }

        plusMinus(arr);
    }
}

