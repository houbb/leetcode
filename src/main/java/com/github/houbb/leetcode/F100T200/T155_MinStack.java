package com.github.houbb.leetcode.F100T200;

import java.util.Stack;

public class T155_MinStack {

    /**
     * 其实如果使用 list 构建，反而不是从零构建。
     *
     * 我们直接模拟 linkedlist 构建
     */
    private class StackNode {
        // 存储最小的值
        private int min;
        private int val;
        private StackNode next;

        public StackNode(int min, int val, StackNode next) {
            this.min = min;
            this.val = val;
            this.next = next;
        }
    }

    private StackNode head;

    public void push(int val) {
        if(head == null) {
            head = new StackNode(val, val, null);
        } else {
            head = new StackNode(Math.min(val, head.min), val, head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

}
