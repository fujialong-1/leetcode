package stack.p6;


import java.util.Stack;


// 剑指 Offer 09. 用两个栈实现队列

public class CQueue {

    private Stack<Integer> stackIn = new Stack<Integer>();
    private Stack<Integer> stackOut = new Stack<Integer>();

    public CQueue() {

    }

    public void appendTail(int value) {
        stackIn.push(value);
    }

    public int deleteHead() {
        if (stackOut.isEmpty()) {
            if (stackIn.isEmpty()) {
                return -1;
            } else {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
                int result = stackOut.pop();
                return result;
            }
        } else {
            return stackOut.pop();
        }
    }
}
