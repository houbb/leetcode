package com.github.houbb.leetcode.F100T200;

import java.util.Stack;

public class T150_EvaluateReversePolishNotation {

    /**
     * 1. 遍历 tokens，压入 stack 内
     *
     * @param tokens 字符串数组
     * @return 结果
     */
    public int evalRPN(String[] tokens) {
        String operators = "+-*/";
        Stack<String> stack = new Stack<>();

        int result = 0;

        // 是否为操作符
        for(String token : tokens) {
            // 操作符
            if(operators.contains(token)) {
                String top1 = stack.pop();
                String top2 = stack.pop();

                // 计算的时候，top2 要在前面
                result = calc(top2, token, top1);

                // 把结果压入栈
                stack.add(result+"");
            } else {
                // 数字压入栈内
                stack.add(token);
            }
        }

        // 最后的出栈
        result = Integer.parseInt(stack.pop());

        return result;
    }


    private int calc(String top2, String operator, String top1) {
        switch (operator) {
            case "+":
                return Integer.parseInt(top2) + Integer.parseInt(top1);
            case "-":
                return Integer.parseInt(top2) - Integer.parseInt(top1);
            case "*":
                return Integer.parseInt(top2) * Integer.parseInt(top1);
            case "/":
                return Integer.parseInt(top2) / Integer.parseInt(top1);
            default:
                throw new UnsupportedOperationException();
        }
    }

}
