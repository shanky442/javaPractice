package com.gfg160;



    //{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;

    public class MoveAllZerosToEnd {

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int tc = Integer.parseInt(br.readLine());
            while (tc-- > 0) {
                String[] inputLine = br.readLine().split(" ");
                int[] arr = new int[inputLine.length];
                for (int i = 0; i < inputLine.length; i++) {
                    arr[i] = Integer.parseInt(inputLine[i]);
                }

                new Solution2().pushZerosToEnd(arr);
                int n = arr.length;
                for (int i = 0; i < n; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        }
    }
// } Driver Code Ends


// User function Template for Java

class Solution2 {
    void pushZerosToEnd(int[] arr) {
        // code here
        //int ofset = 1;
        //one way with O(n*n)
        /*for(int j=arr.length;j>=0;j--) {
            for(int i=0;i<j-1;i++) {
                if(arr[i]==0) {
                    arr[i]=arr[i+1];
                    arr[i+1]=0;
                }
            }
        }*/
        //more efficient with O(n)
        int count=0;
        for(int i=0;i<arr.length-1;i++) {
            if(arr[i]==0) {
                if(arr[i+1]==0) {
                    count++;
                } else {
                    arr[i-count] = arr[i + 1];
                    arr[i + 1] = 0;
                    //count=0;
                }
            }
        }


    }
}

