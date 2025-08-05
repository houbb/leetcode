package com.github.houbb.leetcode.topics.slidlingWindows;

import java.util.HashSet;
import java.util.Set;

public class T3_LongestSubstringWithoutRepeatingCharacters_V3_Queue_TwoPointer {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;

        int max = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            // 入栈
            if(!set.contains(c)) {
                max = Math.max(max, right-left+1);

                set.add(c);
                right++;
            } else {
                // 出栈
                set.remove(s.charAt(left));
                left++;
            }
        }

        return max;
    }

}
