package monotoneprioritystack;

import java.util.Stack;

public class Problem739 {
    public static void main(String[] args) {

    }

    /**
     * 维护递减栈，后入栈的元素总比栈顶元素小。
     *
     * 比对当前元素与栈顶元素的大小
     * 若当前元素 < 栈顶元素：入栈
     * 若当前元素 > 栈顶元素：弹出栈顶元素，记录两者下标差值即为所求天数
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return res;
    }
}
