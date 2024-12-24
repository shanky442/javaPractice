package com.gfg160;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NextPermutation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int N = arr.length;
            Solution5 ob = new Solution5();
            ob.nextPermutation(arr); // Generate the next permutation
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < N; i++) {
                out.append(arr[i] + " "); // Corrected: use arr[i] instead of arr.get(i)
            }
            System.out.println(out.toString().trim()); // Print the output

            System.out.println("~");
        }
    }
}

class Solution5 {
    void nextPermutation(int[] arr) {
        // code here
        int i = arr.length-1;
        boolean max=true;
        for(;i>0;i--) {
            if(arr[i]>arr[i-1]) {
                max=false;
                break;
            }
        }
        if(max) {
            reverse(arr,0,arr.length-1);
        } else {
            int j=i-1;
            for(int x=arr.length-1;x>j;x--) {
                if(arr[x]>arr[j]) {
                    swap(arr,x,j);
                    break;
                }
            }
            reverse(arr,j+1,arr.length-1);
        }
    }

    private void reverse(int[] arr, int j, int lastIndex) {
        int numOfEntries = lastIndex-j+1;
        for(int x=j,y=lastIndex;j<x+(numOfEntries/2) && lastIndex>y-(numOfEntries/2);j++,lastIndex--) {
            int temp= arr[j];
            arr[j]=arr[lastIndex];
            arr[lastIndex]=temp;
        }

    }

    private void swap(int[] arr, int x, int j) {
        int temp = arr[j];
        arr[j]=arr[x];
        arr[x]=temp;
    }


}
