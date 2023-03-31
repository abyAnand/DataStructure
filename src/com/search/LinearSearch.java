package com.search;

public class LinearSearch {

    public static void main(String[] args) {

        int arr[] = {2,3,4,5,6,7,8};
        int target = 4;

        int result = linearSearch(arr, target);

        if(result != -1){
            System.out.println("Element Found at position "+ (result+1) );
        }
        else{
            System.out.println("Element not Found");
        }

    }

    static int linearSearch(int[] arr, int target){

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }


}
