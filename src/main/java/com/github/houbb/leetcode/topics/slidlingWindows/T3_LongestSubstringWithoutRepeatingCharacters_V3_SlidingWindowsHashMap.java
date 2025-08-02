package com.github.houbb.leetcode.topics.slidlingWindows;

public class T3_LongestSubstringWithoutRepeatingCharacters_V3_SlidingWindowsHashMap {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int max = 0;

        char[] chars = s.toCharArray();
        int[] queue = new int[s.length()];
        for (char c : chars) {
            // 判断是否包含
            for(int i = 0; i < end; i++) {
                // 重复
                if(queue[i] == c) {
                    max = Math.max(max, end-start+1);

                    // 丢弃 i 和之前的元素
                    start = i+1;
                }
            }

            // 放入队尾
            queue[end++] = c;
        }

        // 避免全部没重复的场景
        max = Math.max(max, end-start+1);

        return max;
    }
}
