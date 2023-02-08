package com.github.houbb.leetcode.F000T100;

import java.util.Stack;

/**
 * 阿拉伯数字转罗马字符
 *
 * 1. 限定：输入 1 to 3999
 *
 * 2. 简单对应
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 *
 * 2.特殊映射
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * @author binbin.hou
 * @since 1.0.0
 * @date 2020-6-11 17:29:21
 */
public class T012_IntegerToRoman {

    /**
     * 思路1：basic
     * 思路2：HashMap
     *
     * 1 I
     * 2 II
     * 3 III
     * 4 IV = 5-1
     * 5 V = 5
     * 6 VI = 5+1
     * 7 VII
     * 8 VIII
     * 9 IX = 10-1
     * 10 X = 10
     *
     * 考虑范围：1-3999
     *
     * 最多有 4 位
     *
     * 是否需要栈？
     * @param num 数字
     * @return 结果
     * @since v1
     */
    public String intToRoman(int num) {
        Stack<Integer> stack = new Stack<>();
        while (num > 0) {
            int mod = num % 10;
            // 剩余的部分
            num = num/10;

            // 余数
            stack.add(mod);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            // 第一个出来的是最高位
            int number = stack.pop();
            // 跳过
            if(number == 0) {
                continue;
            }
            if(stack.size() == 3) {
                stringBuilder.append(build(number,
                        "M", "", ""));
            } else if(stack.size() == 2) {
                stringBuilder.append(build(number,
                        "C", "D", "M"));
            } else if(stack.size() == 1) {
                stringBuilder.append(build(number,  "X", "L", "C"));
            } else if(stack.size() == 0) {
                stringBuilder.append(build(number,
                        "I", "V", "X"));
            }
        }

        return stringBuilder.toString();
    }

    /**
     * 核心实现
     * @param number 数字
     * @param currentChar  当前字符
     * @param fiveChar 中间
     * @param tenChar 最后
     * @return 结果
     * @since v1
     */
    private String build(final int number,
                         final String currentChar,
                         final String fiveChar,
                         final String tenChar) {
        if(number <= 3) {
            return repeat(number, currentChar);
        } else if(number == 4) {
            return currentChar + fiveChar;
        } else if(number == 5) {
            return fiveChar;
        } else if(number == 9) {
            return currentChar+tenChar;
        } else {
            return fiveChar +repeat(number-5, currentChar);
        }
    }

    /**
     * 重复构建多次
     * @param times 次数
     * @param c 字符
     * @return 结果
     * @since v1
     */
    private String repeat(final int times, final String c) {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < times; i++) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
