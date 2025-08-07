package com.github.houbb.leetcode.topics.stack;

import java.util.Stack;

public class T20_isValid_V1_Stack {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c : chars) {
            // 入
            if('{' == c
                    || '(' == c
                    || '[' == c) {
                stack.push(c);
                continue;
            }
            // 出
            if(stack.isEmpty()) {
                return false;
            }
            char popChar = stack.pop();
            if('}' == c) {
                if('{' != popChar) {
                    return false;
                }
            }
            if(']' == c) {
                if('[' != popChar) {
                    return false;
                }
            }
            if(')' == c) {
                if('(' != popChar) {
                    return false;
                }
            }
        }

        // 出
        // 必须为空
        return stack.isEmpty();
    }

}
