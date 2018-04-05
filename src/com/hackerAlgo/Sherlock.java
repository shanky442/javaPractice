package com.hackerAlgo;

import java.util.*;

public class Sherlock {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        //String s = "abcccc";
        String result = isValid(s);
        System.out.println(result);
    }

    static String isValid(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        char[] cArray = s.toCharArray();
        for (char c : cArray) {
            if (freqMap.containsKey(c)) {
                freqMap.put(c, freqMap.get(c) + 1);
            } else {
                freqMap.put(c, 1);
            }
        }
        HashSet<Integer> freqsSet = new HashSet<>();
        freqMap.forEach((k, v) -> freqsSet.add(v));
        int i = 0;
        if (freqsSet.size() > 2)
            return "NO";
        else if (freqsSet.size() == 1)
            return "YES";
        else if (freqsSet.size() == 2) {
            int f1 = 0;
            int f2 = 0;
            for (int n : freqsSet) {
                if (i == 0) {
                    f1 = n;
                    i++;
                } else f2 = n;
            }
            int f1Count=0;
            int f2Count=0;
            for(int freq:freqMap.values()){
                if(freq==f1)
                    f1Count++;
                if(freq==f2)
                    f2Count++;
            }
            if((f1 == 1 && f1Count == 1 ) || (f2 == 1 && f2Count == 1 ))
                return "YES";
            else if ((Math.abs(f1 - f2)  == 1) && (f1Count == 1 || f2Count == 1))
                return "YES";
            else
                return "NO";
        }
        return "NO";
    }
}

