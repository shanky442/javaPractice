package com.hackerAlgo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CamelCase {
    //https://www.hackerrank.com/challenges/camelcase/problem
    // Complete the camelcase function below.
    static int camelcase(String s) {
        int min = 1;
        for(char c:s.toCharArray()) {
            if((int)c>64 && (int)c<91) {
                min++;
            }
        }
        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        int result = camelcase(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
