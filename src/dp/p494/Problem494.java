package dp.p494;

/**
 * 目标和
 */
public class Problem494 {
    public static void main(String[] args) {

    }

    private static int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;
        int[][] dp = new int[n+1][2001];
        dp[1][nums[0]] = nums[0] == 0 ? 2 : 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= 1000; j++) {
                int target1 = j + nums[i-1] >= 0 ? j + nums[i-1] : -j-nums[i-1];
                int target2 = j - nums[i-1] >= 0 ? j - nums[i-1] : -j+nums[i-1];
                dp[i][j] = dp[i-1][target1] + dp[i-1][target2];
            }
        }
        target = target >= 0 ? target : -target;
        return dp[n][target];
    }
}
