package com.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {

        int[] arr = {2, -32, 0, 78, 1};
        selection(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void selection(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            //find the max element in the remaining array and swap with correct index
            int last = arr.length - i -1;
            int maxIndex = getMaxIndex(arr,0,last);
            swap(arr, maxIndex, last);

        }
    }

    static void swap(int[] arr,int num,int swapNum){
        int temp = arr[num];
        arr[num] = arr[swapNum];
        arr[swapNum] = temp;
    }

    private static int getMaxIndex(int[] arr, int start, int end){
        int max = start;
        for (int i = start; i <= end; i++) {
            if(arr[max] < arr[i]){
                max = i;
            }
        }
        return max;
    }
}
