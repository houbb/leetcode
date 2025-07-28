package com.github.houbb.leetcode.topics.sort;

import java.util.HashSet;
import java.util.Set;

public class Sort_T389_V1_CountingSort {

    public char findTheDifference(String s, String t) {
        int[] counts = new int[26];

        for(int i = 0; i < t.length(); i++) {
            counts[t.charAt(i)-'a']++;
        }

        for(int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)-'a']--;
        }

        // 找到不为0的
        for(int i = 0; i < 26; i++) {
            if(counts[i] > 0) {
                return (char)('a' + i);
            }
        }
        return 'a';
    }


}
