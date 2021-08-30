package dp.p55;

public class Problem55 {

    public static void main(String[] args) {

        boolean[] temp = new boolean[2];
        //System.out.println(temp[0]);
        System.out.println(true || false);




    }

    public static boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        // 定义dp数组，dp[j]代表能否从下标为j的位置跳到最后一个下标
        boolean[] dp = new boolean[nums.length];
        dp[nums.length-1] = !(nums[nums.length-1] == 0);
        // 状态转移方程
        for (int j = nums.length-2; j >= 0; j--) {
            int temp = nums[j];
            if (temp == 0) {
                dp[j] = false;
            } else {
                int i = 1;
                while (i <= temp && (i+j) < nums.length) {
                    dp[j] = dp[j+i] | dp[j];
                    i++;
                }
                if (i+j == nums.length) dp[j] = true;
            }
        }
        return dp[0];
    }


}
