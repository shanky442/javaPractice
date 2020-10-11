package com.hackerAlgo;

import java.io.*;

public class CyclicBinaryString {
    //https://www.hackerrank.com/contests/hackerrank-hackfest-2020/challenges/cyclic-binary-string

    /**
     * not solved completely. only 3 test cases passed
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        int result = maximumPower(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int maximumPower(String s) {
        // Write your code here
        long length = s.length();
        //int num = Integer.parseInt(s,2);
        int power = 0;
        for (int i = 0; i < length; i++) {
             s = rotateRight(s);
            int shiftedNum = Integer.parseInt(s,2);
            if(shiftedNum%2==0) {
                int powerOf2 = calculatePowerof2(shiftedNum);
                if (powerOf2 > power) {
                    power = powerOf2;
                }
            }
        }
        return power;
    }

    private static String rotateRight(String num) {
        char[] charArray = num.toCharArray();
        int l = charArray.length;
        return charArray[l-1]+String.valueOf(charArray,0,l-1);
    }

    private static int calculatePowerof2(int shiftedNum) {
        int power = 0;
        int result = 0;
        //int num =1;
        while(Math.pow(2,power)<shiftedNum) {
            if(shiftedNum % Math.pow(2,power) == 0) {
                result = power;
            }
            power++;
        }
        return result;
    }
}
