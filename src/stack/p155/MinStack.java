package stack.p155;

import java.util.Queue;
import java.util.Stack;

public class MinStack {

    private Stack<Integer> normalStack;
    private Stack<Integer> minStack;

    public MinStack() {
        normalStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        normalStack.push(val);
        if (!minStack.isEmpty()) {
            if (val <= minStack.peek()) {
                minStack.push(val);
            }
        } else {
            minStack.push(val);
        }
    }

    public void pop() {
        int temp = normalStack.pop();
        if (!minStack.isEmpty()) {
            if (temp == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        return normalStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack myMinStack = new MinStack();
        myMinStack.push(0);
        myMinStack.push(1);
        myMinStack.push(0);
        myMinStack.getMin();
        myMinStack.pop();
        myMinStack.getMin();
    }

}
