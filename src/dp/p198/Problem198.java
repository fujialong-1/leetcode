package dp.p198;
/**
打家劫舍问题
*/

public class Problem198 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for(int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i-1], nums[i-1] + dp[i-2]);
        }
        return dp[nums.length];
    }
}
