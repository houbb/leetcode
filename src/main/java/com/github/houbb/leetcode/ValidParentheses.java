package com.github.houbb.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 1. empty 是合法的
 * 2. () 必须按照对应的顺序关闭。
 *
 * <p> project: leetcode-ValidParentheses </p>
 * <p> create on 2020/6/16 22:49 </p>
 *
 * @author binbin.hou
 * @since 2020-6-16 22:49:35
 */
public class ValidParentheses {

    private static final Map<Character, Character> MAP = new HashMap<>(4);

    static {
        MAP.put(')', '(');
        MAP.put('}', '{');
        MAP.put(']', '[');
    }

    /**
     * 简单思路
     *
     * 【效果】
     *
     * Runtime: 1 ms, faster than 98.79% of Java online submissions for Valid Parentheses.
     * Memory Usage: 37.4 MB, less than 70.07% of Java online submissions for Valid Parentheses.
     *
     * @param s 字符串
     * @return 结果
     * @since v1
     */
    public boolean isValid(String s) {
        if(null == s || s.length() == 0) {
            return true;
        }
        // 奇数
        if(s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // 开始 pop
                if(stack.isEmpty()) {
                    return false;
                }

                char pop = stack.pop();
                char expectPop = MAP.get(c);

                if(pop != expectPop) {
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }

}
