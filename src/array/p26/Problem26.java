package array.p26;

public class Problem26 {
}

class Solution {
    //26. 删除有序数组中的重复项
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        } else {
            int fastIndex = 1;
            int slowIndex;
            int val = 0;
            for (slowIndex = 0; fastIndex < nums.length; fastIndex++){
                val = nums[slowIndex];
                if (nums[fastIndex] != val) {
                    slowIndex++;
                    nums[slowIndex] = nums[fastIndex];
                }
            }
            return slowIndex + 1;
        }
    }
}
