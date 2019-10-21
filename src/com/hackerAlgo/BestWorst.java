package com.hackerAlgo;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class BestWorst {

    //https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {
        int countLow=0, countHigh = 0;
        int min = scores[0];
        int max = scores[0];
        for(int i=1;i<scores.length;i++) {
            if(scores[i]>max) {
                max=scores[i];
                countHigh++;
            } else if(scores[i]<min) {
                min = scores[i];
                countLow++;
            }
        }
        int[] res = new int[]{countHigh, countLow};
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
