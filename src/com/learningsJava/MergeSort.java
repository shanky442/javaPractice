package com.learningsJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        //List<Integer> inputList = Arrays.asList(10,5,3,20,65,2);
        int[] inputList = new int[] {10,5,3,20,65,2};
        sort(inputList,0,inputList.length-1);
        int i=0;
        while(i<inputList.length) {
            System.out.print(inputList[i]);
            i++;
        }


    }

    private static void sort(int[] inputList,int l,int r) {
        if(l<r) {
            int mid = (l+r)/2;
            sort(inputList,l, mid);
            sort(inputList,mid+1, r);
            merge(inputList, l, mid, r);
        }
    }

    private static void merge(int[] inputList, int l, int mid, int r) {
        int size1 = mid+1-l;
        int size2 = r-mid;
        int leftArray[] = new int[size1];
        int rightArray[] = new int[size2];

        //copy the left and the right array
        for(int i=0;i<size1;i++) {
            leftArray[i] = inputList[l+i];
        }

        for(int j=0;j<size2;j++) {
            rightArray[j] = inputList[mid+1+j];
        }

        //initial index of first and the second subarray
        int i=0,j=0;
        //initial index of the combined array
        int k=l;
        while(i<size1 && j<size2) {
            if(leftArray[i]>rightArray[j]) {
                inputList[k]=rightArray[j];
                j++;
            } else {
                inputList[k] = leftArray[i];
                i++;
            }
            k++;
        }

        //copy remaining elements
        while(i<size1) {
            inputList[k]=leftArray[i];
            i++;
            k++;
        }
        while(j<size2) {
            inputList[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
