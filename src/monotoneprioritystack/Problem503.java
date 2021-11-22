package monotoneprioritystack;

import java.util.Arrays;
import java.util.Stack;

public class Problem503 {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
    public static int[] nextGreaterElements(int[] nums) {
        //边界判断
        if(nums == null || nums.length <= 1) {
            return new int[]{-1};
        }
        int size = nums.length;
        //存放结果
        int[] result = new int[size];
        //默认全部初始化为-1
        Arrays.fill(result,-1);
        //栈中存放的是nums中的元素下标
        Stack<Integer> st= new Stack<>();
        for(int i = 0; i < 2 * size; i++) {
            while(!st.empty() && nums[i % size] > nums[st.peek()]) {
                //更新result
                result[st.peek()] = nums[i % size];
                //弹出栈顶
                st.pop();
            }
            st.push(i % size);
        }
        return result;
    }
}
