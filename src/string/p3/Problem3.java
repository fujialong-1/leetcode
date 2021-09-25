package string.p3;

import java.util.LinkedList;
import java.util.Queue;

public class Problem3 {

    public static void main(String[] args) {

    }

    // 无重复字符的最长子串
    // 思路：用队列实现
    public int lengthOfLongestSubstring(String s) {
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
    }
}
