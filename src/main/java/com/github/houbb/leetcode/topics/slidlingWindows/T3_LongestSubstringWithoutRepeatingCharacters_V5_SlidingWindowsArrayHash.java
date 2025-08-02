package com.github.houbb.leetcode.topics.slidlingWindows;

import java.util.HashMap;
import java.util.Map;

public class T3_LongestSubstringWithoutRepeatingCharacters_V5_SlidingWindowsArrayHash {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int max = 0;

        int[] windows = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 最大值
            start = Math.max(start, windows[c]);

            max = Math.max(max, i-start+1);

            // 更新位置，这里统一+1，避免0的混淆
            windows[c] = i+1;
        }

        return max;
    }
}
