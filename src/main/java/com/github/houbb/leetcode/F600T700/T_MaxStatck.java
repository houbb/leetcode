package com.github.houbb.leetcode.F600T700;

import java.util.List;
import java.util.Stack;

public class T_MaxStatck {

    /** initialize your data structure here. */
    private final Stack<Integer> stack;
    private final Stack<Integer> assistStack;

    public T_MaxStatck() {
        stack = new Stack<>();
        assistStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (assistStack.isEmpty()) {
            assistStack.push(x);
        } else {
            if (assistStack.peek() < x) {
                assistStack.push(x);
            } else {
                assistStack.push(assistStack.peek());
            }
        }
    }
    public int pop() {
        assistStack.pop();
        return stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int peekMax() {
        return assistStack.peek();
    }
    public int popMax() {
        Stack<Integer> tmpStack = new Stack<>();
        while (!stack.peek().equals(assistStack.peek())) {
            tmpStack.push(this.pop());
        }
        int max = this.pop();
        while (!tmpStack.isEmpty()) {
            this.push(tmpStack.pop());
        }
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */

