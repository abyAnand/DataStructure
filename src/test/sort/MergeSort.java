package test.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {5,4,3,2,1};
        arr = mergy(arr);
        System.out.println(Arrays.toString(arr));
        
    }
    
    static int[] mergy(int[] arr){
        if(arr.length ==1){
            return arr;
        }

        int mid = arr.length/2;

        int[] left = mergy(Arrays.copyOfRange(arr,0, mid));
        int[] right = mergy(Arrays.copyOfRange(arr,mid, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right){
        int[] mix = new int[left.length + right.length];

        int i=0;
        int j=0;
        int k=0;

        while(i< left.length && j< right.length){
            if(left[i] < right[j]){
                mix[k] = left[i];
                i++;
            }else{
                mix[k] = right[j];
                j++;
            }
            k++;
        }

        while(i< left.length){
            mix[k] = left[i];
            k++;
            i++;
        }

        while(j < right.length){
            mix[k] = right[j];
            k++;
            j++;
        }

        return mix;
    }

}
