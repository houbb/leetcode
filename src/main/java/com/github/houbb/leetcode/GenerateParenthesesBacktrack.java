package com.github.houbb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author binbin.hou
 * @since 1.0.0
 * @date 2020-6-17 15:09:54
 */
public class GenerateParenthesesBacktrack {

    /**
     * 优化思路：
     *
     * （1）列表扩容
     * （2）String 重用
     *
     * 【性能】
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Generate Parentheses.
     * Memory Usage: 39.6 MB, less than 63.29% of Java online submissions for Generate Parentheses.
     *
     * @param n 数字
     * @return 结果
     */
    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder(n << 1);
        backtrack(resultList, stringBuilder, 0, 0, n);

        return resultList;
    }

    /**
     * 递归处理
     * @param resultList 结果列表
     * @param stringBuilder 字符串
     * @param left 左括号
     * @param right 右括号
     * @param num 位数
     */
    private void backtrack(List<String> resultList,
                           StringBuilder stringBuilder,
                           int left,
                           int right,
                           int num) {
        if(stringBuilder.length() == num << 1) {
            resultList.add(stringBuilder.toString());
            return;
        }

        //左边的括号是可以一直加的
        if(left < num) {
            backtrack(resultList, stringBuilder.append("("), left+1, right, num);

            // 重新设置
            stringBuilder.setLength(stringBuilder.length()-1);
        }

        // ) 小于 < 的时候，可以添加
        if(right < left) {
            backtrack(resultList, stringBuilder.append(")"), left, right+1, num);

            stringBuilder.setLength(stringBuilder.length()-1);
        }
    }

}
