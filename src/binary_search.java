/*
* 二分查找的相关算法
* 应用二分查找的条件：排好序的数组
* */

public class binary_search {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.isPerfectSquare(5);
//        System.out.println(5%3);
    }
}

class Solution1 {

    //704. 二分查找
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

    //35. 搜索插入位置
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

    //69. x的平方根
    public int mySqrt(int x) {
        int left = 1, right = x;
        int ans = -1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if(x/mid == mid){
                ans = mid;
                return ans;
            } else if (x/mid > mid){
                left = mid + 1;
            } else if (x/mid < mid){
                right = mid -1;
            }
        }
        return right;
    }

    //367. 有效的完全平方数
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        boolean ans = false;
        while (left <= right){
            int mid = left + (right-left)/2;
            if(num/mid == mid){
                if (num%mid == 0){
                    ans = true;
                    return ans;
                } else {
                    return ans;
                }

            } else if (num/mid > mid){
                left = mid + 1;
            } else if (num/mid < mid){
                right = mid -1;
            }
        }
        return ans;
    }
}