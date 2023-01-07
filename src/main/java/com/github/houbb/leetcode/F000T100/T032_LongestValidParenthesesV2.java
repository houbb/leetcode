package com.github.houbb.leetcode.F000T100;

import java.util.Stack;

/**
 * @author d
 * @since 1.0.0
 */
public class T032_LongestValidParenthesesV2 {

    public static void main(String[] args) {
        T032_LongestValidParenthesesV2 longestValidParentheses = new T032_LongestValidParenthesesV2();
        System.out.println(longestValidParentheses.longestValidParentheses(")(())"));
    }

    /**
     * 基于 stack 的差异对比
     *
     * @param s 字符串
     * @return 结果
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        stack.push(-1);

        for(int i = 0; i < s.length(); i++) {
            // 当前为 )，且 stack 中上一个刚好为 (
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                result = Math.max(result, i - stack.peek());
            } else {
                stack.push(i);
            }
        }

        return result;
    }

}
