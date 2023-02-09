package com.github.houbb.leetcode.F000T100;

/**
 * 最长的无重复子串
 * @author binbin.hou
 * @since 1.0.0
 */
public class T003_LongestSubstringWithoutRepeatingCharactersV3 {

    /**
     * 假设字符是固定的
     *
     * 这里的原理就是把 char 当做数组的下标，访问时为 O(1)
     * 优点：快速 && 节约内存
     *
     * 其他的和上面的方法一样。
     *
     * 效果：
     *
     * Runtime: 2 ms, faster than 99.78% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 39.4 MB, less than 84.35% of Java online submissions for Longest Substring Without Repeating Characters.
     *
     * @param s 字符串
     * @return 结果
     * @since v3
     */
    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];
        int maxLength = 0;

        for(int i = 0,j = 0; j < s.length(); j++) {
            char currentChar = s.charAt(j);

            // 有值的情况
            i = Math.max(chars[currentChar], i);

            // 这里临时值的计算优化基本为 0
            int temp = j+1;
            maxLength = Math.max(maxLength, temp-i);
            chars[currentChar] = temp;
        }

        return maxLength;
    }

}
