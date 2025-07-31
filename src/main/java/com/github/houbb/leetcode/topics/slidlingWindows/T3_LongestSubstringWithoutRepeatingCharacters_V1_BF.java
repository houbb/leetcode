package com.github.houbb.leetcode.topics.slidlingWindows;

import java.util.HashSet;
import java.util.Set;

public class T3_LongestSubstringWithoutRepeatingCharacters_V1_BF {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;

        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            // 判重
            Set<Character> set = new HashSet<>();
            for(int j = i; j < chars.length; j++) {
                char c = chars[j];
                if(set.contains(c)) {
                    break;
                }
                set.add(c);
            }

            // 更新
            max = Math.max(max, set.size());
        }
        return max;
    }

}
