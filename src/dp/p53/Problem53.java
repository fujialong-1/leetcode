package dp.p53;

/**
 * 最大子序和
 */
public class Problem53 {

    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums) {
        int pre = nums[0];
        int res = pre;
        for(int i = 1; i < nums.length; i++) {
            pre = pre < 0 ? nums[i] : pre + nums[i];
            res = Math.max(pre, res);
        }
        return res;
    }
}
