package greedy;

import java.util.Arrays;

/**
 * K 次取反后最大化的数组和
 */
public class Problem1005 {
    public static void main(String[] args) {
        int[] test = new int[]{-2, 9, 9, 8, 4};
        int k = 5;
        System.out.println(largestSumAfterKNegations(test, k));

    }
    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            } else {
                break;
            }
        }
        Arrays.sort(nums);
        if (k > 0) {
            nums[0] = k % 2 == 1 ? -nums[0] : nums[0];
        }
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
