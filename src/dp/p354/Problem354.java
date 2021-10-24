package dp.p354;

import java.util.Arrays;
import java.util.Comparator;

public class Problem354 {

    public static void main(String[] args) {

    }

    static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // 按宽度升序排序，如果宽度一样，则按高度降序排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ?
                        b[1] - a[1] : a[0] - b[0];
            }
        });
        // 对高度数组寻找LIS
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }

    /**
     * 最长递增子序列
     * 二分查找版
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }
}
