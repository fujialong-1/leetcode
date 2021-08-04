package stack.p20;

import java.util.Deque;
import java.util.LinkedList;

public class Problem20 {
    public static void main(String[] args) {

    }
}
//有效的括号
class Solution {
    public boolean isValid(String s) {
        Deque<Character> que = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                que.addLast(s.charAt(i));
            }
            if (s.charAt(i) == ')') {
                if (que.size() == 0 || '(' != que.removeLast()) {
                    return false;
                }
            }
            if (s.charAt(i) == '}') {
                if (que.size() == 0 || '{' != que.removeLast()) {
                    return false;
                }
            }
            if (s.charAt(i) == ']') {
                if (que.size() == 0 || '[' != que.removeLast()) {
                    return false;
                }
            }
        }
        if (que.size() != 0) {
            return false;
        }
        return true;
    }
}