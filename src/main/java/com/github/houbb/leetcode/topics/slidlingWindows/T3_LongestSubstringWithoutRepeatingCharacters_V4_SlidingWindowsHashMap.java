package com.github.houbb.leetcode.topics.slidlingWindows;

import java.util.HashMap;
import java.util.Map;

public class T3_LongestSubstringWithoutRepeatingCharacters_V4_SlidingWindowsHashMap {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int max = 0;

        Map<Character, Integer> posMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer pos = posMap.get(c);
            // 存在
            if(pos != null) {
                // 最大值
                start = Math.max(start, pos+1);
            }

            max = Math.max(max, i-start+1);

            // 更新位置
            posMap.put(c, i);
        }

        return max;
    }
}
