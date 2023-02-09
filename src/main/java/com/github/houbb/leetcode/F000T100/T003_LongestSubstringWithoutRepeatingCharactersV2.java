package com.github.houbb.leetcode.F000T100;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长的无重复子串
 * @author binbin.hou
 * @since 1.0.0
 */
public class T003_LongestSubstringWithoutRepeatingCharactersV2 {

    /**
     * 滑动窗口-优化
     *
     * 优化思想：最外层 i 的自增是可以优化的。
     *
     * i 在遍历的时候，直接走到最新的位置。并且保存上一个最大的距离。
     *
     * abcdee
     *
     * abcdaefgi
     *
     * [i, j]
     *
     * j-i+1 获取最长字串的长度。
     *
     * i 初始位置遍历
     * j 当前 char 位置
     *
     *
     * 效果：
     *
     * Runtime: 5 ms, faster than 86.17% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 39.2 MB, less than 97.56% of Java online submissions for Longest Substring Without Repeating Characters.
     *
     * @param s 字符串
     * @return 结果
     * @since v2
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        final int length = s.length();
        Map<Character, Integer> indexMap = new HashMap<>(length);
        for(int i = 0,j = 0; j < length; j++) {
            char currentChar = s.charAt(j);
            if(indexMap.containsKey(currentChar)) {
                // 重复，直接更新 i 的位置到最大的 max(i, j+1)
                // 这里的 indexMap.get(currentChar) 获取到的是上一次出现该元素的位置+1
                // 这里到底快了多少呢？
                i = Math.max(i, indexMap.get(currentChar));
            }

            maxLength = Math.max(maxLength, j-i+1);
            // 对应的元素位置，是下一个
            indexMap.put(currentChar, j+1);
        }

        return maxLength;
    }

}
