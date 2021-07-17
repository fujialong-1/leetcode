package array.p35;

public class Problem35 {
}

//35. 搜索插入位置
class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target > nums[nums.length-1]){
            return nums.length;
        }
        if(target<nums[0]){
            return 0;
        }
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int middle = left + (right-left)/2;
            if(nums[middle] == target){
                return middle;
            }else if(nums[middle] < target){
                left = middle + 1;
            }else if(nums[middle] > target){
                right = middle - 1;
            }
        }
        return right + 1;
    }
}