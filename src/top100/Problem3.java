package top100;

public class Problem3 {
    public static void main(String[] args) {

    }
    public int lengthOfLongestSubstring(String s) {
        // 通过字符串记录字符上一次出现的位置
        int[] last = new int[128];
        int n = s.length();
        int res = 0;
        // 窗口开始位置
        int start = 0;
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index]);
            res = Math.max(res, i - start + 1);
            // 之所以是i+1是因为不能包含i,所以往后移一位
            last[index] = i+1;
        }
        return res;
    }
}
