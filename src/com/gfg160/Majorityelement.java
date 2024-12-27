package com.gfg160;
import java.io.*;
import java.util.*;

public class Majorityelement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution6 ob = new Solution6();
            List<Integer> ans = ob.findMajority1(nums);

            if (ans.size() == 0) {
                System.out.println("[]");
            } else {
                for (int i : ans) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
// } Driver Code Ends
}

class Solution6 {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        // Your code goes here.
        int numOfVotes = nums.length;
        int qualifyingNumVotes = numOfVotes/3;
        int[] lastIndex= new int[1];
        lastIndex[0]=0;
        int[][] tempArray = new int[numOfVotes][2];
        for(int i=0;i<numOfVotes;i++) {
            addToTempArray(tempArray,nums[i],lastIndex);
        }
        List<Integer> finalList = new ArrayList<>();
        for(int x=0;x< tempArray.length;x++) {
            if(tempArray[x][1]>qualifyingNumVotes)
                finalList.add(tempArray[x][0]);
        }
        return finalList;
    }

    private void addToTempArray(int[][] tempArray, int num, int[] lastIndex) {
        int j=0;
        boolean found = false;
        for(;j< lastIndex[0];j++) {
            if(tempArray[j][0]==num) {
                found = true;
                tempArray[j][1]=tempArray[j][1]+1;
                break;
            }
        }
        if(!found) {
            tempArray[lastIndex[0]][0]=num;
            tempArray[lastIndex[0]][1]=1;
            lastIndex[0]++;
        }
    }

    public List<Integer> findMajority1(int[] nums) {
        List<Integer> answerList= new ArrayList<>();
        int numOfVotes = nums.length;
        int qualifyingNumVotes = numOfVotes/3;
        int m1=0,n1=0;
        int m2=0,n2=0;
        for(int i=0;i<numOfVotes;i++) {
            if(nums[i]==m1){
                n1++;
            } else if(nums[i]==m2) {
                n2++;
            } else if(n1==0) {
                m1=nums[i];
                n1++;
            } else if(n2==0) {
                m2=nums[i];
                n2++;
            } else {
                n1--;
                n2--;
            }
        }
        int finalCountM1=0;
        int finalCountM2=0;
        for(int x:nums) {
            if(x==m1)
                finalCountM1++;
            else {
                if(x==m2)
                    finalCountM2++;
            }
        }
        if(finalCountM1>qualifyingNumVotes)
            answerList.add(m1);
        if(finalCountM2>qualifyingNumVotes) {
            if(m2<m1) {
                answerList.add(0,m2);
            } else
                answerList.add(m2);
        }
        return answerList;
    }
}
