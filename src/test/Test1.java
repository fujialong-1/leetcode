package test;


import java.util.Arrays;

public class Test1 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1};
        Arrays.sort(nums, 1,3);
        System.out.println(Arrays.toString(nums));
        System.out.println();
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }
    public static void nextPermutation(int[] nums) {
        if(nums.length == 1) {
            return;
        }
        int index = -1;
        int i = nums.length - 1;
        for(; i >= 0; i--) {
            int j = i-1;
            while(j >= 0) {
                if(nums[j] < nums[i]) {
                    swap(nums, i, j);
                    index = j;
                    break;
                }
                j--;
            }
            if(index != -1) {
                break;
            }
        }
        Arrays.sort(nums, index+1, nums.length);
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


