package com.recursion;

public class Fibo {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9};

        int s = 0;
        int e = arr.length -1;
        int target = 8;
        int answer = binary(arr, target, s, e);
        System.out.println("Answer found at Position: "+ (answer+1));
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

    static int fibo(int n){
        //base condition
        if(n<2){
            return n;
        }
        return fibo(n-1)+fibo(n-2);
    }

}
