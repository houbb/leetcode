package com.github.houbb.leetcode.F000T100;

import java.util.Stack;

/**
 * @author d
 * @since 1.0.0
 */
public class T032_LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("(())()"));

        T032_LongestValidParentheses longestValidParentheses = new T032_LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses("()"));
        System.out.println(longestValidParentheses.longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses.longestValidParentheses(""));
    }

    /**
     * 最简单的思路：
     *
     * 1. 通过双指针，两边移动。截取 substring
     * 2. 通过 020 的方法，判断字符串是否为 valid，是返回 j-i
     * 3. i j 重合，返回 0
     *
     * 这种解法：会在 222 CASE 超时
     *
     * @param s 字符串
     * @return 结果
     */
    public int longestValidParentheses(String s) {
        //0.1 都不是
        if(s.length() <= 1) {
            return 0;
        }

        // 这个复杂度是 o(N^3)，肯定没戏
        for (int stepLen = s.length(); stepLen >= 2; stepLen--) {
            // 逆序，本质是双指针
            for(int i = 0; i < s.length()-1; i++) {
                // fast-return
                if(i + stepLen > s.length()) {
                    break;
                }

                String subString = s.substring(i, i+stepLen);

                if(isValid(subString)) {
                    return stepLen;
                }
            }
        }

        // 没有
        return 0;
    }

    /**
     * 大道至简
     *
     * T020
     *
     * @param s 字符串
     * @return 结果
     * @since v1
     */
    public static boolean isValid(String s) {
        // 奇数个，不可能满足
        if(s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(') {
                stack.push(c);
            } else {
                // 开始 pop
                if(stack.isEmpty()) {
                    return false;
                }

                char pop = stack.pop();
                char expectPop = '(';

                if(pop != expectPop) {
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }


}
