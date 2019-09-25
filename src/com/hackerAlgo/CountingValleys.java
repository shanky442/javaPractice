package com.hackerAlgo;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingValleys {
    // Complete the countingValleys function below.
    //https://www.hackerrank.com/challenges/counting-valleys/problem
    static int countingValleys(int n, String s) {
        char[] list = s.toCharArray();
        int sum =0;
        List<Integer> intList = new ArrayList<>();
        for(int i=0;i<list.length;i++) {
            if(list[i]=='U') {
                sum+=1;
            }
            if(list[i]=='D') {
                sum-=1;
            }
            intList.add(sum);
        }
        boolean flag=false;
        int count=0;
        for(int i:intList) {
            if(i<0 && !flag) {
                flag= true;
                count++;
            }
            if(flag){
                if(i==0){
                    flag=false;
                }
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/
        System.out.println(result);

        scanner.close();
    }
}
