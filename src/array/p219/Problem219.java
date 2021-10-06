package array.p219;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
// 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
// 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。

public class Problem219 {
    public static void main(String[] args) {

    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 滑动窗口
        Map<Integer, Integer> window = new HashMap<>();
        int right = 0;
        while (right < nums.length) {
            if (window.containsKey(nums[right])) {
                int index = window.get(nums[right]);
                if (right - index <= k) {
                    return true;
                } else {
                    window.put(nums[right], right);
                }
            } else {
                window.put(nums[right], right);
            }
            right++;
        }
        return false;
    }
}
