package com.github.houbb.leetcode.topics.slidlingWindows;

import java.util.HashSet;
import java.util.Set;

public class T3_LongestSubstringWithoutRepeatingCharacters_V3_Queue_TwoPointer_ArrayHash {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }


    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;

        int[] set = new int[128];

        while (right < s.length()) {
            char c = s.charAt(right);

            // 不重复，直接加入窗口
            if (set[c] == 0) {
                set[c]++;
                max = Math.max(max, right - left + 1);
                right++;
            } else {
                // 重复了，移除左侧字符，收缩窗口
                char leftChar = s.charAt(left);
                set[leftChar]--;
                left++;
            }
        }

        return max;
    }

}
