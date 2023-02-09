package com.github.houbb.leetcode.F000T100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author d
 * @since 1.0.0
 */
public class T032_LongestValidParenthesesV2 {

    public static void main(String[] args) {
        T032_LongestValidParenthesesV2 longestValidParentheses = new T032_LongestValidParenthesesV2();
        System.out.println(longestValidParentheses.longestValidParentheses("())((())"));
    }

    /**
     * 基于 stack 的差异对比
     *
     * @param s 字符串
     * @return 结果
     */
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }

            System.out.println("i="+i + ", stack=" +stack +", maxans=" + maxans);
        }
        return maxans;
    }

}
