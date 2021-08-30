package dfs.p698;

public class Problem698 {
    public static void main(String[] args) {

        int[] nums = {3, 3, 3, 3, 4};
        int k = 4;
        System.out.println(canPartitionKSubsets(nums, k));

    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {

        /*if (k == 1) return true;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            sum += nums[i];
        }
        if (sum % k != 0) return false;
        int mean = sum/k;
        if (max > mean) return false;
        int[] bucket = new int[k];
        return permute(nums, bucket, 0, mean);*/

        if (k == 1) return true;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            sum += nums[i];
        }
        if (sum % k != 0) return false;
        int mean = sum/k;
        if (max > mean) return false;
        boolean[] used = new boolean[nums.length];
        return permute(k, 0, nums, 0, used, mean);


    }

    // 站在数字的角度，选择进哪个桶
    /*public static boolean permute(int[] nums, int[] bucket, int index, int mean) {
        if (index == nums.length) {
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] != mean) return false;
            }
            return true;
        }

        // 选择进哪个桶
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] + nums[index] <= mean) {
                bucket[i] += nums[index];
                if (permute(nums, bucket, index+1, mean)) {
                    return true;
                } else {
                    bucket[i] -= nums[index];
                }
            }
        }

        return false;
    }*/

    // 站在桶的角度，选择是否将当前数字装进桶中
    public static boolean permute(int k, int bucket, int[] nums, int i, boolean[] used, int target) {
        // 桶都遍历完了
        if (k == 0) return true;

        // 桶都装满了，就不用再进入后面的装数环节了
        if (bucket == target) {
            return permute(k-1, 0, nums, 0, used, target);
        }

        for (int j = i; j < nums.length; j++) {
            if (used[j]) {
                continue;
            }
            if (bucket + nums[j] <= target) {
                used[i] = true;
                bucket += nums[j];
                if (permute(k, bucket, nums,j+1, used, target)) {
                    return true;
                }
                used[j] = false;
                bucket -= nums[j];
            }
            /*if (bucket + nums[j] == target) {
                if (permute(k-1, 0, nums, 0, used, target)) {
                    return true;
                }
            }*/
        }

        return false;
    }


}
