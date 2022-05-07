package dfs.p491;

import java.util.*;

public class Problem491 {
    public static void main(String[] args) {
        int[] test = new int[]{4, 6, 7, 7};
        findSubsequences(test);

    }

    public static List<List<Integer>> res = new LinkedList<>();
    public static LinkedList<Integer> path = new LinkedList<>();

    public static List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    public static void dfs(int[] nums, int start) {
        if(path.size() >= 2) {
            res.add(new LinkedList<>(path));
        }
        Set<Integer> set = new HashSet<>();
        for(int i = start; i < nums.length; i++) {
            if(!path.isEmpty() && nums[i] < path.getLast()) {
                continue;
            }
            if (set.contains(nums[i])) {
                continue;
            }
            // 老是写成nums[start]
            set.add(nums[i]);
            path.add(nums[i]);
            dfs(nums, i+1);
            path.removeLast();
        }
    }
}
