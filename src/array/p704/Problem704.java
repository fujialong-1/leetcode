package array.p704;

public class Problem704 {
    public static void main(String[] args) {

    }
}
//704. 二分查找
class Solution {
    public int search(int[] nums, int target) {
        if(nums[0] > target || nums[nums.length - 1] < target ){
            return -1;
        }
        int left = 0;
        int right = nums.length;
        while(left < right){
            int middle = left + ((right - left) >> 1);
            if(nums[middle] == target){
                return middle;
            } else if(nums[middle] > target){
                right = middle;
            } else if(nums[middle] < target){
                left = middle + 1;
            }
        }
        return -1;
    }
}
