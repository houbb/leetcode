package com.github.houbb.leetcode.topics.slidlingWindows;

import java.util.HashSet;
import java.util.Set;

public class T3_LongestSubstringWithoutRepeatingCharacters_V2_SlidingWindows {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;

        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];

            // 是否满足条件
            if(!set.contains(c)) {
                continue;
            }

            // 入
            set.add(chars[i]);

            //出队列
            set.remove(c);

        }
        return max;
    }

}
