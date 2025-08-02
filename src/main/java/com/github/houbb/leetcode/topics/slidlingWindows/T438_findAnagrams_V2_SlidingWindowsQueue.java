package com.github.houbb.leetcode.topics.slidlingWindows;

import java.util.*;

public class T438_findAnagrams_V2_SlidingWindowsQueue {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    /**
     * 返回 s 中涵盖 t 所有字符的最小子串。
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        int[] targetWindows = new int[26];
        int[] sourceWindows = new int[26];

        for(char c : p.toCharArray()) {
            targetWindows[c-'a']++;
        }

        List<Integer> resultList = new ArrayList<>();

        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            sourceWindows[c-'a']++;

            // 满足初步收缩条件
            int len = right-left+1;
            if(len == p.length()) {
                // 满足
                if(Arrays.equals(sourceWindows, targetWindows)) {
                    resultList.add(left);
                }

                // left 向右移动
                char leftChar = s.charAt(left);
                sourceWindows[leftChar-'a']--;
                left++;
            }
        }

        return resultList;
    }

}
