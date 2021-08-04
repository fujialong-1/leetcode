package stack.p1047;

import java.util.Deque;
import java.util.LinkedList;

public class Problem1047 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.removeDuplicates("abbaca");
        System.out.println(s);
    }
}

class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> que = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (que.size() == 0) {
                que.push(s.charAt(i));
            } else {
                if (que.peek() == s.charAt(i)) {
                    que.pop();
                } else {
                    que.push(s.charAt(i));
                }
            }
        }
//        StringBuffer str = new StringBuffer();
//        int size = que.size();// que的size动态发生变化
//        for (int i = 0; i < size; i++) {
//            str.append(que.removeLast());
//        }
//        return str.toString();
        String str = "";
        while (!que.isEmpty()) {
            str = que.pop() + str;
        }
        return str;
    }
}