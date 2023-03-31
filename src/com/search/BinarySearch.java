package com.search;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        int target = 4;
        int answer = findFirstGreaterOrEqual(arr, target);
        System.out.println("element which is greater than or equal to the target number is in index: " + answer);

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
