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

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(target < matrix[0][0]) return false;
        int left = 0;
        int right = matrix[0].length;
        while(left < right){
            int middle = left + ((right - left) >> 1);
            if(matrix[0][middle] == target){
                return true;
            } else if(matrix[0][middle] > target){
                right = middle;
            } else if(matrix[0][middle] < target){
                left = middle + 1;
            }
        }
        int index = left - 1;
        left = 0;
        right = matrix.length;
        while(left < right){
            int middle = left + ((right - left) >> 1);
            if(matrix[index][middle] == target){
                return true;
            } else if(matrix[index][middle] > target){
                right = middle;
            } else if(matrix[index][middle] < target){
                left = middle + 1;
            }
        }
        return false;
    }
}
