package dfs.p494;

public class Problem494 {

    public static int res;

    public static void main(String[] args) {

        int[] nums = {1};
        int target = 1;
        System.out.println(findTargetSumWays(nums, target));

    }

    public static int findTargetSumWays(int[] nums, int target) {
        res = 0;
        permute(nums, target, 0);
        return res;
    }

    public static void permute(int[] nums, int target, int index) {
        if (index == nums.length) {
            if (target == 0) {
                res++;
            }
            return;
        }

        // 对于当前的nums[i]，你要做的选择是什么。
        target = target + nums[index];
        permute(nums, target, index+1);
        target = target - nums[index];

        target = target - nums[index];
        permute(nums, target, index+1);
        target = target + nums[index];


    }

}
