package stack.p225;

import java.util.Deque;
import java.util.LinkedList;

public class Problem225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}

//class MyStack {
//
//    //使用两个Deque实现
//    Deque<Integer> stIn;
//    Deque<Integer> stOut;
//
//    /** Initialize your data structure here. */
//    public MyStack() {
//        stIn = new LinkedList<>();
//        stOut = new LinkedList<>();
//    }
//
//    /** Push element x onto stack. */
//    public void push(int x) {
//        stIn.addLast(x);
//    }
//
//    /** Removes the element on top of the stack and returns that element. */
//    public int pop() {
//        int res = 0;
//        while (stIn.size() > 1) {
//            stOut.addLast(stIn.poll());
//        }
//        res = stIn.poll();
//        while (!stOut.isEmpty()) {
//            this.push(stOut.poll());
//        }
//        return res;
//    }
//
//    /** Get the top element. */
//    public int top() {
//        int res = this.pop();
//        this.push(res);
//        return res;
//    }
//
//    /** Returns whether the stack is empty. */
//    public boolean empty() {
//        return stIn.isEmpty() && stOut.isEmpty();
//    }
//}

class MyStack {

    //使用一个Deque实现
    Deque<Integer> deque;

    /** Initialize your data structure here. */
    public MyStack() {
        deque = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        deque.addLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        for (int i = 1; i <= deque.size()-1; i++) {
            deque.addLast(deque.poll());
        }
        return deque.poll();
    }

    /** Get the top element. */
    public int top() {
        int res = 0;
        for (int i = 1; i <= deque.size()-1; i++) {
            deque.addLast(deque.poll());
        }
        res = deque.poll();
        this.push(res);
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return deque.isEmpty();
    }


}