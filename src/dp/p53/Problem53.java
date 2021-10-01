package dp.p53;

public class Problem53 {
    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums) {


        // 定义一维dp数组
        int[] dp = new int[nums.length];
        // 初始化
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i- 1] + nums[i], nums[i]); // 递归方程
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }
}
