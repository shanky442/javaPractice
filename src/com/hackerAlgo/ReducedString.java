package com.hackerAlgo;

import java.io.*;
public class ReducedString {
    // Complete the superReducedString function below.
    //https://www.hackerrank.com/challenges/reduced-string/problem
    static String superReducedString(String s) {
        boolean flag = false;
        char[] chars = s.toCharArray();
        for(int i=1;i<chars.length;i++) {
            if(chars[i-1]==chars[i]) {
                chars[i-1]='\0';
                chars[i]='\0';
                flag = true;
            }
        }
        String str = new String(chars);
        str = str.replaceAll("\0","");
        //System.out.print(str);
        if(flag) str = superReducedString(str);
        if(str.equals("")) {
            str = "Empty String";
        }
        return str;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
