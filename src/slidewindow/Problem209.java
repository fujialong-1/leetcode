package slidewindow;

// 给定一个含有 n 个正整数的数组和一个正整数 target 。
//
//找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Problem209 {
    public static void main(String[] args) {

    }
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while(right < nums.length) {
            sum += nums[right];
            right++;
            while(sum >= target) {
                res = Math.min(res, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
