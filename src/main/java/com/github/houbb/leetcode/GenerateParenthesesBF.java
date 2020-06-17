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
public class GenerateParenthesesBF {

    /**
     *
     * 思路：
     *
     * （1）生成所有可能
     * （2）如果符合则加入结果
     *
     * 性能：超过 5.08%
     * 
     * @param n 数字
     * @return 结果
     * @since v1
     */
    public List<String> generateParenthesis(int n) {
        List<String> all = generateAll(n);
        List<String> resultList = new ArrayList<>();

        for(String string : all) {
            if(isValid(string)) {
                resultList.add(string);
            }
        }
        return resultList;
    }

    private boolean isValid(final String s) {
        int length = s.length();
        int headIx = 0;

        for(int i = 0; i < length; i++) {
            char c = s.charAt(i);

            if('(' == c) {
                headIx++;
            } else {
                if(headIx == 0) {
                    return false;
                }
                headIx--;
            }
        }

        return headIx == 0;
    }

    /**
     * 生成所有的可能字符串
     * @param n 个数
     * @return 结果
     * @since v1
     */
    private List<String> generateAll(final int n) {
        List<String> resultList = new ArrayList<>();
        resultList.add("");

        char[] chars = new char[]{'(', ')'};

        for(int i = 0; i < n*2; i++) {
            List<String> newList = new ArrayList<>();
            for(String result : resultList) {
                for(char c: chars) {
                    newList.add(result+c);
                }
            }
            resultList = newList;
        }

        return resultList;
    }

}
