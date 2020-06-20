package com.hackerDS;


import java.io.*;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class Crush {

    //https://www.hackerrank.com/challenges/crush/problem
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        int[] initial = new int[n];
        Arrays.stream(initial).map(i->i=0);
        long max=0;
        //difference array method
        long[] diff = new long[n+1];
        for (int i=0;i<queries.length;i++) {
            int initialIndex = queries[i][0]-1;
            int finalIndex = queries[i][1]-1;
            int value = queries[i][2];
            diff[initialIndex]=diff[initialIndex]+value;
            if(finalIndex<n) {
                diff[finalIndex + 1] = diff[finalIndex + 1] - value;
            }
        }
        Arrays.stream(diff).forEach(i->System.out.print(i+" "));
        long y=0;
        for(int i=0;i<n;i++) {
            y=y+diff[i];
            if(y>max) {
                max = y;
            }
        }
        return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
