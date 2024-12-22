package com.gfg160;

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RotateArray {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int d = Integer.parseInt(in.readLine().trim()); // rotation count (key)
            int n = array.size();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = array.get(i);

            new Solution4().rotateArr(arr, d); // rotating the array
            StringBuilder sb = new StringBuilder();

            // printing the elements of the array
            for (int value : arr) sb.append(value).append(" ");
            out.println(sb.toString().trim());

            out.println("~");
        }
        out.flush();
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution4 {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
        // add your code here
        //Less efficient method O(n*d)
        /*if(d>=arr.length)
            d = d % arr.length;
        for(int i=0;i<d;i++) {
            int temp = arr[0];
            for(int j=0;j<arr.length-1;j++) {
                arr[j]=arr[j+1];
            }
            arr[arr.length-1]=temp;
        }*/
        //More efficient O(n)
        int hcf = hcf(arr.length,d);
        d=d%arr.length;
        for(int i=0;i<hcf;i++) {
            int beginIndex = i;
            int temp=arr[i];

            while(true) {
                int nextIndex = (beginIndex+d)%(arr.length);
                if(nextIndex==i)
                    break;
                arr[beginIndex] = arr[nextIndex];
                beginIndex = nextIndex;
            }
            arr[beginIndex] = temp;
        }
    }

    private static int hcf(int length, int d) {
        int smaller;
        int larger;
        if(length>d) {
            larger = length;
            smaller=d;
        } else {
            smaller = length;
            larger = d;
        }

        int hcf = 1;
        for(int i=2;i<=smaller;i++) {
            if(smaller%i==0 && larger%i==0)
                hcf=i;
        }
        return hcf;
    }
}
