package array.p643;
// 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
//
//请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
//
//任何误差小于 10-5 的答案都将被视为正确答案。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Problem643 {
    public static void main(String[] args) {


    }
    public double findMaxAverage(int[] nums, int k) {
        double res = 0.0;
        int sum = 0;
        int i = 0;
        for(; i < k; i++) {
            sum += nums[i];
        }
        // 两个int类型的数相除还是int,如果想得到double类型的数，先要将其转成double
        res = (double)sum / k;
        while(i < nums.length) {
            sum += nums[i];
            sum -= nums[i-k];
            res = Math.max(res, (double)sum / k);
            i++;
        }
        return res;
    }
}
