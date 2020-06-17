package com.github.houbb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 最暴力：
 *
 * 1. 全部穷举，然后对比。
 * 2.
 *
 * @author binbin.hou
 * @since 1.0.0
 * @date 2020-6-17 15:09:54
 */
public class GenerateParentheses {

    /**
     *  1 2 3
     * 简单思路
     * 1. 1== n 直接返回 ()
     * 2. 2== n
     * ()()
     * (())
     *
     * 第一个位置
     *
     * ((()))
     * (()())
     * (())()
     * ()(())
     * ()()()
     *
     * @param n 数字
     * @return 结果
     * @since v1
     */
    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();

        recursive(resultList, "", 0, 0, n);

        return resultList;
    }

    /**
     * 递归处理
     * @param resultList 结果列表
     * @param string 字符串
     * @param left 左括号
     * @param right 右括号
     * @param num 位数
     * @since v1
     */
    private void recursive(List<String> resultList,
                           String string,
                           int left,
                           int right,
                           int num) {
        System.out.println("s: " + string+", (: "+left+", ): " + right);

        if(string.length() == num << 1) {
            resultList.add(string);
            return;
        }

        //左边的括号是可以一直加的
        if(left < num) {
            recursive(resultList, string+"(", left+1, right, num);
        }

        // ) 小于 < 的时候，可以添加
        if(right < left) {
            recursive(resultList, string+")", left, right+1, num);
        }
    }

}
