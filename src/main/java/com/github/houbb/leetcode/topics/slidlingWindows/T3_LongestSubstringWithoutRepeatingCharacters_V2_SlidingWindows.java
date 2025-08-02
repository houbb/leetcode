package com.github.houbb.leetcode.topics.slidlingWindows;

import java.util.LinkedList;
import java.util.Queue;

public class T3_LongestSubstringWithoutRepeatingCharacters_V2_SlidingWindows {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Queue<Character> queue = new LinkedList<>();

        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            // 是否满足条件
            if (!queue.contains(c)) {
                queue.add(c);
                continue;
            }

            // 已经有重复的数据
            max = Math.max(max, queue.size());

            //出队列，需要把和当前字符重复的和之前的字符全部异常
            while (!queue.isEmpty() && queue.peek() != c) {
                queue.poll();
            }
            queue.poll();
            queue.add(c);
        }

        // 避免全部没重复的场景
        max = Math.max(max, queue.size());

        return max;
    }
}
