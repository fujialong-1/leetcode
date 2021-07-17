package array.p34;

public class Problem34 {
    public static void main(String[] args) {

    }
}

class Solution {
    //34. 在排序数组中查找元素的第一个和最后一个位置
    /*
     * 思路：
     * 1、先判断存不存在
     * 2、如果存在，找出左右边界
     * */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if(nums.length == 0){
            result = new int[]{-1,-1};
            return result;
        }
        if(target > nums[nums.length - 1]){
            result = new int[]{-1,-1};
            return result;
        }
        if(target < nums[0]){
            result = new int[]{-1,-1};
            return result;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if(target == nums[mid]){
                int indexLeft = mid;
                int indexRighr = mid;
                while (indexLeft >= 0 && nums[indexLeft] == target){
                    indexLeft--;
                }
                while (indexRighr <= nums.length-1 && nums[indexRighr] == target){
                    indexRighr++;
                }
                result = new int[]{indexLeft+1,indexRighr-1};
                return result;
            } else if (target < nums[mid]){
                right = mid - 1;
            } else if (target > nums[mid]){
                left = mid + 1;
            }
        }
        result = new int[]{-1,-1};
        return result;
    }
}
