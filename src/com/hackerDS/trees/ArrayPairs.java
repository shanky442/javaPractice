package com.hackerDS.trees;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ArrayPairs {


    // https://www.hackerrank.com/challenges/array-pairs/problem - is not the perfect solution. worked only
    // for 2/20 test cases
    static long solve(int[] arr) {
        int[][] maxEntries = new int[arr.length][arr.length];
        int count = 0;
        for(int i=0;i<arr.length-1;i++) {
            for(int j=i+1;j<arr.length;j++) {
                int max = findMax(arr,i,j,maxEntries);
                if(arr[i]*arr[j]<=max) {
                    count++;
                }
            }
        }
        for(int i=0;i<maxEntries.length-1;i++) {
            for(int j =0;j<maxEntries.length;j++) {
                System.out.print(maxEntries[i][j]+" ");
            }
            System.out.println("");
        }
        return count;


    }

    private static int findMax(int[] arr, int i, int j, int[][] maxEntries) {
        int max = 0;
        if(maxEntries[i][j-1] == 0) {
            if(arr[i]>arr[j]) {
                max = arr[i];
            } else {
                max = arr[j];
            }
            maxEntries[i][j] = max;
            return max;
        }
        if(maxEntries[i][j-1] > arr[j]) {
            max = maxEntries[i][j-1];
            maxEntries[i][j] = max;
        } else {
            max = arr[j];
            maxEntries[i][j] = max;
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        long result = solve(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
