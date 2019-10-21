package com.hackerAlgo;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class Leaderboard {
    //https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem


    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int i=0;
        TreeSet<Integer> scoreSet = new TreeSet<>();
        while(i<scores.length && scores[i]>alice[0]) {
            scoreSet.add(scores[i]);
            i++;
        }
        TreeSet<Integer> scoreSetDesc = (TreeSet<Integer>)scoreSet.descendingSet();
        List<Integer> scoreList = new ArrayList<>(scoreSetDesc);
        List<Integer> resultList = new ArrayList<>();
        int[] scoresArray = getArray(scoreList);
        for(int aliceScore:alice) {
            int position = binarySearch(scoresArray,0,scoresArray.length-1,aliceScore);
            //System.out.println(position);
            resultList.add(position+1);
        }
        int[] res = new int[alice.length];
        return getArray(resultList);
    }

    private static int[] getArray(List<Integer> scoreList) {
        int[] scoresArray = new int[scoreList.size()];
        int k=0;
        for(int j:scoreList) {
            scoresArray[k]=j;
            k++;
        }
        return scoresArray;
    }

    static int binarySearch(int scoreList[], int low, int high, int aliceScore)
    {
        if (high < low)
            return scoreList.length;

        /*low + (high - low)/2;*/
        int mid = (low + high) / 2;
        if(mid==scoreList.length-1 && mid==high) {
            if(aliceScore<scoreList[mid]) {
                return high+1;
            } else {
                return high;
            }

        }
        if(aliceScore==scoreList[mid]) {
            return mid;
        }
        if(mid==0 && aliceScore>scoreList[0]) {
            return 0;
        }
        if (aliceScore > scoreList[mid] && aliceScore < scoreList[mid-1])
            return mid;
        if (aliceScore < scoreList[mid])
            return binarySearch(scoreList, (mid + 1), high, aliceScore);

        return binarySearch(scoreList, low, (mid - 1), aliceScore);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
