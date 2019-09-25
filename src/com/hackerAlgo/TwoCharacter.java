package com.hackerAlgo;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TwoCharacter {
    // Complete the alternate function below.
    //https://www.hackerrank.com/challenges/two-characters/problem
    static int alternate(String s) {
        //fetch the unique chars
        Set<Character> charSet = new HashSet<>();
        char[] chars = s.toCharArray();
        for(Character c: chars) {
            charSet.add(c);
        }
        Iterator<Character> it = charSet.iterator();
        List<Character> list = new ArrayList<>();
        while(it.hasNext()) {
            list.add(it.next());
        }
        Set<String> setOfCobinations = new HashSet<>();
        for(int i=0;i<list.size();i++) {
            for(int j=1;j<list.size();j++) {
                if(!list.get(i).toString().equals(list.get(j).toString())) {
                    if(!setOfCobinations.contains(list.get(j).toString().concat(":").concat(list.get(i).toString())))
                    setOfCobinations.add(list.get(i).toString().concat(":").concat(list.get(j).toString()));
                }
            }
        }
         //remove the unique chars and generate the resultant string
        Iterator<String> iter = setOfCobinations.iterator();
        Set<String> stringSet = new HashSet<>();
        while(iter.hasNext()) {
            String combStr = iter.next();
            String first = combStr.split(":")[0];
            String sec = combStr.split(":")[1];
            String str = s.replaceAll("[^"+first+sec+"]","");
            //str = str.replaceAll("[^"+sec+"]","");
            stringSet.add(str);
        }
        //check if it is valid
        Iterator<String> stringIterator = stringSet.iterator();
        int max=0;
        while(stringIterator.hasNext()) {
            boolean flag = true;
            String stri = stringIterator.next();
            System.out.println(stri);
            char[] charss =  stri.toCharArray();
            for(int i=0;i<stri.length();i++) {
                if(!(charss[i%2]==charss[i])) {
                    flag=false;
                }
            }
            if(flag) {
                if(stri.length()>max) max = stri.length();
            }
        }
        //find the longest of all the valid ones

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
