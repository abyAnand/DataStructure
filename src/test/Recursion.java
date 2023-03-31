package test;

public class Recursion {

    public static void main(String[] args) {

        int[] nums = {5,4,3,2,7,6,8};

        System.out.println(find(nums.length-1, 3, nums));

    }

    static int find(int arrayLength, int num, int[] arr){
        if( arrayLength < 0){
            return -1;
        }
        if(arr[arrayLength] == num){
            return arrayLength;
        }
        return find(arrayLength-1, num, arr);

    }
}
