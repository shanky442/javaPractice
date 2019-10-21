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
        int[] res = new int[alice.length];
        res[0] = scoreSet.size()+1;
        for(int j=1;j<alice.length;j++) {
            for(int k=0;k<scoreList.size();k++) {
                if(scoreList.get(k)<=alice[j]) {
                    res[j]=k+1;
                    break;
                }
                if(k==scoreList.size()-1) {
                    res[j]=scoreList.size()+1;
                }
            }
        }
        return res;
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
