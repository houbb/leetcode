package com.github.houbb.leetcode;

/**
 * 优化思路：
 *
 * 使用数组+指针替代 Stack
 *
 * <p> project: leetcode-ValidParentheses </p>
 * <p> create on 2020/6/16 22:49 </p>
 *
 * @author binbin.hou
 * @since 2020-6-16 22:49:35
 */
public class ValidParenthesesOptimize {

    /**
     * 大道至简
     *
     * 【效果】
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Valid Parentheses.
     * Memory Usage: 37.1 MB, less than 95.67% of Java online submissions for Valid Parentheses.
     *
     * @param s 字符串
     * @return 结果
     * @since v1
     */
    public boolean isValid(String s) {
        int length = s.length();
        char[] stack = new char[length];
        int headIx = 0;

        for(int i = 0; i < length; i++) {
            char c = s.charAt(i);

            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack[headIx++] = c;
                    break;
                case '}':
                    if(headIx == 0 || stack[--headIx] != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if(headIx == 0 || stack[--headIx] != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if(headIx == 0 || stack[--headIx] != '(') {
                        return false;
                    }
                    break;
            }
        }

        return headIx == 0;
    }

}
