package com.github.houbb.leetcode.F000T100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 将数字转换为字母
 *
 * 1. 可以任意顺序
 * 2. 1 不对应任何信息
 *
 * 递归解法
 *
 * @author binbin.hou
 * @since 1.0.0
 * @date 2020-6-15 11:04:31
 */
public class T017_LetterCombinationsOfAPhoneNumberRecursive {

    private static final Map<Character, char[]> MAP = new HashMap<>();

    static {
        MAP.put('2', "abc".toCharArray());
        MAP.put('3', "def".toCharArray());
        MAP.put('4', "ghi".toCharArray());
        MAP.put('5', "jkl".toCharArray());
        MAP.put('6', "mno".toCharArray());
        MAP.put('7', "pqrs".toCharArray());
        MAP.put('8', "tuv".toCharArray());
        MAP.put('9', "wxyz".toCharArray());
    }

    /**
     * 基本思路：穷举
     *
     * 1. map 只初始化一次
     * 2. StringBuilder 重复利用，降低创建耗时
     * 3. 递归实现
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Letter Combinations of a Phone Number.
     * Memory Usage: 38 MB, less than 94.58% of Java online submissions for Letter Combinations of a Phone Number.
     *
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
        StringBuilder sb = new StringBuilder();
        recursiveCombination(digits, 0, sb, resultList);

        return resultList;
    }

    /**
     * 递归处理
     * @param digits 数字
     * @param index 下标
     * @param sb 字符串
     * @param result 结果
     * @since v2
     */
    private void recursiveCombination(String digits, int index,
                                      StringBuilder sb, List<String> result){

        if(sb.length() == digits.length()){
            result.add(sb.toString());
            return;
        }

        for(char ch: MAP.get(digits.charAt(index))){
            sb.append(ch);
            recursiveCombination(digits, index+1, sb, result);

            // 删除当前已添加，节约资源
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
