package com.hackerDS.stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class EqualStacks {


    /*
     * https://www.hackerrank.com/challenges/equal-stacks/problem
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    private static final Logger logger = Logger.getLogger(EqualStacks.class.getName());

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        int sumH1 = calculateSum(h1);
        int sumH2 = calculateSum(h2);
        int sumH3 = calculateSum(h3);
        if (sumH1 == sumH2 && sumH1 == sumH3) {
            return sumH1;
        }
        List<Integer> smallestList = findStackWithSmallestSize(h1, h2, h3);
        if(smallestList.equals(h2)) {
            h2 = h1;
        }
        if(smallestList.equals(h3)) {
            h3 = h1;
        }
        h1 = smallestList;
        for(int i=0; i<h1.size();i++) {
            h1.remove(0);
            int newSum = calculateSum(h1);
            boolean possible2 = checkNewSumPossibility(h2, newSum);
            boolean possible3 = checkNewSumPossibility(h3, newSum);
            if(possible2 && possible3) {
                return newSum;
            }
        }
        return 0;

    }

    private static boolean checkNewSumPossibility(List<Integer> list1, int newSum) {
        int sum =0;
        int index = list1.size()-1;
        while(sum<newSum && index>=0) {
            sum = sum + list1.get(index);
            if(sum == newSum) {
                return true;
            }
            index--;
        }
        return false;
    }

    private static int calculateSum(List<Integer> list) {
        int result = 0;
        for(int i:list) {
            result = result + i;
        }
        return result;
    }

    private static List<Integer> findStackWithSmallestSize(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        List<Integer> smallestList;
        if(h1.size() < h2.size()) {
            smallestList = h1;
        } else {
            smallestList = h2;
        }
        if(h3.size() < smallestList.size()) {
            smallestList = h3;
        }
        return smallestList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = EqualStacks.equalStacks(h1, h2, h3);

        System.out.println(String.valueOf(result));
        //logger.info(() -> String.valueOf(result));

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }

}

