package stack.p150;

import java.util.Deque;
import java.util.LinkedList;

public class Problem150 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] tokens = new String[]{"2","1","+","3","*"};
        System.out.println(solution.evalRPN(tokens));
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> dequeNum = new LinkedList<>();
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == "+") {
                num1 = dequeNum.pop();
                num2 = dequeNum.pop();
                dequeNum.push(num2 + num1);
            } else if (tokens[i] == "-") {
                num1 = dequeNum.pop();
                num2 = dequeNum.pop();
                dequeNum.push(num2 - num1);
            } else if (tokens[i] == "*") {
                num1 = dequeNum.pop();
                num2 = dequeNum.pop();
                dequeNum.push(num2 * num1);
            } else if (tokens[i] == "/") {
                num1 = dequeNum.pop();
                num2 = dequeNum.pop();
                dequeNum.push(num2 / num1);
            } else {
                int temp = Integer.parseInt(tokens[i]);
                dequeNum.push(temp);
            }
        }
        return dequeNum.pop();
    }
}
