package com.gfg160;
import java.io.*;
import java.util.*;

public class StockBuyAndSell {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read the line of integers (prices)
            String arr[] = br.readLine().split(" ");
            int prices[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }

            // Create an instance of the Solution class
            Solution7 ob = new Solution7();

            // Call the stockBuyAndSell method
            int res = ob.maximumProfit(prices);

            // Print the result
            System.out.println(res);

            // Print the "~" symbol to match the original output
            System.out.println("~");
        }
    }
}


// User function Template for Java
class Solution7 {
    public int maximumProfit(int prices[]) {
        // code here
        int balance=0,bp=-1,sp=-1;
        for(int i=0;i<prices.length-1;i++) {
            if(prices[i]<prices[i+1] && bp==-1) {
                bp=prices[i];
            }
            if(prices[i]>prices[i+1] && bp!=-1 && sp==-1) {
                sp=prices[i];
                balance=balance + sp-bp;
                bp=-1;
                sp=-1;
            }
            if(prices[i] <= prices[i+1] && bp!=-1 && i+1==prices.length-1) {
                sp=prices[i+1];
                balance=balance + sp-bp;
                bp=-1;
                sp=-1;
            }
        }
        return balance;
    }
}