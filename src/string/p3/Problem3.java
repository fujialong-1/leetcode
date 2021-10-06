package string.p3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Problem3 {

    public static void main(String[] args) {

    }
    // 无重复字符的最长子串
    // 思路：用队列实现
    /*public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Queue<Character> queue = new LinkedList<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char temp = s.charAt(i);
            if (queue.contains(temp)) {
                while (queue.peek() != temp) {
                    queue.poll();
                }
                queue.poll();
            }
            queue.offer(temp);
            res = Math.max(res, queue.size());
        }
        return res;
    }*/
    // 用滑动窗口实现
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int res = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 判断左侧窗口是否要收缩
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            // 在这里更新答案
            res = Math.max(res, right - left);
        }
        return res;
    }
}
