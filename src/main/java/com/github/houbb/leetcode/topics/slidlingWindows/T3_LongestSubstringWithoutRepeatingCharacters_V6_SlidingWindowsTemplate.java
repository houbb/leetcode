package com.github.houbb.leetcode.topics.slidlingWindows;

public class T3_LongestSubstringWithoutRepeatingCharacters_V6_SlidingWindowsTemplate {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;

        int left = 0;
        int[] windows = new int[128];
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windows[c]++;


            // 收缩条件-如果满足重复条件，则不断移动 left 向右缩小范围
            while (windows[c] > 1) {
                char leftChar = s.charAt(left);
                windows[leftChar]--;
                left++;
            }

            // 更新结果
            max = Math.max(max, right-left+1);
        }

        return max;
    }
}
