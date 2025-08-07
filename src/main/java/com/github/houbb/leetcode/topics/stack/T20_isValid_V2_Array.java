package com.github.houbb.leetcode.topics.stack;

public class T20_isValid_V2_Array {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        char[] stack = new char[chars.length]; // 模拟栈
        int top = -1; // 栈顶指针

        for (char c : chars) {
            // 入栈
            if (c == '{' || c == '(' || c == '[') {
                stack[++top] = c;
                continue;
            }

            // 出栈前判断是否为空
            if (top == -1) {
                return false;
            }

            char popChar = stack[top--]; // 出栈

            // 匹配判断
            if (c == '}' && popChar != '{') return false;
            if (c == ']' && popChar != '[') return false;
            if (c == ')' && popChar != '(') return false;
        }

        // 最终必须栈为空
        return top == -1;
    }
    
}
