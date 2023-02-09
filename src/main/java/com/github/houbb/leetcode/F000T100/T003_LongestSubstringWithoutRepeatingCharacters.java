package com.github.houbb.leetcode.F000T100;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长的无重复子串
 * @author binbin.hou
 * @since 1.0.0
 */
public class T003_LongestSubstringWithoutRepeatingCharacters {

    /**
     * 获取最长字符的长度
     *
     * 最笨的方法：
     * 从第一位开始，重复遍历。
     *
     * 效果：
     *
     * Runtime: 121 ms, faster than 8.72% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 40.3 MB, less than 22.93% of Java online submissions for Longest Substring Without Repeating Characters.
     *
     * @date 2020-6-9 16:08:57
     * @param s 字符串
     * @return 结果
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        // 元素开始的下标
        for(int i = 0; i < s.length(); i++) {

            // 循环
            Set<Character> characters = new HashSet<>();
            for(int j = i; j < s.length(); j++) {
                char currentChar = s.charAt(j);

                // 如果元素重复
                if(characters.contains(currentChar)) {
                    maxLength = Math.max(characters.size(), maxLength);
                    // 跳过当前循环
                    break;
                }

                // 正常添加元素
                characters.add(s.charAt(j));

                // 如果已经走到了最后一位
                // 说明是最长的一位
                if(j == (s.length()-1)) {
                    return Math.max(maxLength, characters.size());
                }
            }
        }

        return maxLength;
    }

}
