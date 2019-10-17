package com.hackerAlgo;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    //https://www.hackerrank.com/challenges/between-two-sets/problem
    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
    public static int findLcm(List<Integer> list) {
        int ans = list.get(0);
        for(int i=1;i<list.size();i++) {
            ans = ans*list.get(i)/gcd(ans,list.get(i));
        }
        return ans;
    }

    public static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b,a%b);
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int maxa = findLcm(a);
        int minb = findGCD(b);
        int divisor = minb/maxa;
        List<Integer> possibles = new ArrayList<>();
        for(int i=0;i<divisor;i++) {
            possibles.add(maxa*(i+1));
        }
        int count=0;
        for(Integer i:possibles) {
            int check=0;
            for(Integer j:b) {
                if(j%i!=0) {
                    check =1;
                }
            }
            if(check==0) {
                count++;
            }
        }
        return count;
    }

    private static int findGCD(List<Integer> inputArray) {
        int gcd = inputArray.get(0);
        for(int i = 1; i< inputArray.size(); i++) {
            gcd = gcd(gcd, inputArray.get(i));
        }
        return gcd;
    }

}

public class TwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        String[] brrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> brr = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrTemp[i]);
            brr.add(brrItem);
        }

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

