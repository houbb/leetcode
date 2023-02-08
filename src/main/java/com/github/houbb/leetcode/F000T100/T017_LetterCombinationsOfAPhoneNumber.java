package com.github.houbb.leetcode.F000T100;

import java.util.ArrayList;
import java.util.List;

/**
 * 将数字转换为字母
 *
 * 1. 可以任意顺序
 * 2. 1 不对应任何信息
 * @author binbin.hou
 * @since 1.0.0
 */
public class T017_LetterCombinationsOfAPhoneNumber {

    /**
     * 基本思路：穷举
     *
     * 使用 set 去重
     * @param digits 数字
     * @return 结果
     * @since v1
     */
    public List<String> letterCombinations(String digits) {
        // size 和 位数的关系
        List<String> resultList = new ArrayList<>();

        if(null == digits || digits.length() == 0) {
            return resultList;
        }

        // 便于后续添加
        resultList.add("");
        char[][] map = new char[10][];
        map[2] = "abc".toCharArray();
        map[3] = "def".toCharArray();
        map[4] = "ghi".toCharArray();
        map[5] = "jkl".toCharArray();
        map[6] = "mno".toCharArray();
        map[7] = "pqrs".toCharArray();
        map[8] = "tuv".toCharArray();
        map[9] = "wxyz".toCharArray();

        for(int i = 0; i < digits.length(); i++) {
            resultList = expend(resultList, map[digits.charAt(i)-'0']);
        }

        return resultList;
    }

    private List<String> expend(final List<String> resultList,
                        final char[] chars) {
        //avoid grew
        List<String> next = new ArrayList<>(resultList.size() * chars.length);
        for(String s : resultList) {
            for(char c : chars) {
                next.add(s+c);
            }
        }

        return next;
    }

    public static void main(String[] args) {
        System.out.println('c');
    }

}
