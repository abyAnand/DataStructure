package com.search;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        int target = 4;
        int answer = findFirstGreaterOrEqual(arr, target);
        System.out.println("element which is greater than or equal to the target number is in index: " + answer);

//        int[] arr = {1,2,3,4,5,6,7,8,9};
//
//        int s = 0;
//        int e = arr.length -1;
//        int target = 8;
//        int answer = binary(arr, target, s, e);
//        System.out.println("Answer found at Position: "+ (answer+1));

    }

    static int findFirstGreaterOrEqual(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {

                right = mid - 1;
            } else {

                left = mid + 1;
            }
        }
        return left;
    }

    static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        while(start <= end){

            int mid = (start+end)/2;

            if(target < arr[mid]){
                end = mid -1;
            }
            else if(target > arr[mid]){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }


    static int binary(int[] arr, int target, int s, int e){
        if(s> e){
            return -1;
        }

        int m = s + (e-s)/2;
        if(arr[m] == target){
            return m;
        }
        if(target < arr[m]){
            return binary(arr, target, s, e);
        }
        return binary(arr, target, m+1, e);
    }

    static int findMax(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
