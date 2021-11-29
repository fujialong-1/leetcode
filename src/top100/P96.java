package top100;

public class P96 {
    public static void main(String[] args) {

    }
    // 动态规划解二叉树，本质上是找规律
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= i-1; j++) {
                dp[i] += dp[j] * dp[i-1-j];
            }
        }
        return dp[n];
    }
}
