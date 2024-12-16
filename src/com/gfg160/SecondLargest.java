package com.gfg160;
//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class SecondLargest {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        int max = arr[0];
        int count=0;
        for(int entry:arr) {
            if(entry>max)
                max = entry;
            else {
                if(entry==max) {
                    count=count+1;
                }
            }
        }
        if(count==arr.length) return -1;
        int secLargest = arr[0];
        int j=0;
        while(arr[j]==max && j<arr.length) {
            secLargest=arr[j+1];
            j++;
        }
        for(int i=0;i<arr.length;i++) {
            if(arr[i]>secLargest && arr[i]<max)
                secLargest=arr[i];
        }
        return secLargest;
    }
}

