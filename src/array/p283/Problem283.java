package array.p283;

public class Problem283 {
    public static void main(String[] args) {

    }
}

class Solution {
    //283. 移动零
    public void moveZeroes(int[] nums) {
        int fastIndex = 0;
        int slowIndex;
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++){
            if (nums[fastIndex] != 0){
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        for (int i = slowIndex; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}
