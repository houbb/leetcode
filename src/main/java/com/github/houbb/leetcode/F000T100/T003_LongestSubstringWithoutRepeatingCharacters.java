package com.github.houbb.leetcode.F000T100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
    public int lengthOfLongestSubstringSlidWindowOptimize(String s) {
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
    public int tableOptimize(String s) {
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
