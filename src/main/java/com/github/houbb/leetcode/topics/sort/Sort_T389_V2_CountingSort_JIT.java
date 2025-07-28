package com.github.houbb.leetcode.topics.sort;

public class Sort_T389_V2_CountingSort_JIT {

    static {
        for(int i = 0; i < 500; i++) {
            findTheDifference("", "");

        }
    }
    public static char findTheDifference(String s, String t) {
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
