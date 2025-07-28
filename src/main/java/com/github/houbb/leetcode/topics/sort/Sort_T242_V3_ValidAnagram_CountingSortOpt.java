package com.github.houbb.leetcode.topics.sort;

public class Sort_T242_V3_ValidAnagram_CountingSortOpt {


    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] tempCount = new int[26];
        int length = s.length();
        for(int i = 0; i< length; i++) {
            int ix1 = s.charAt(i) - 'a';
            int ix2 = t.charAt(i) - 'a';
            tempCount[ix1]++;
            tempCount[ix2]--;
        }

        // 对比
        for(int i = 0; i < 26; i++) {
            if(tempCount[i] != 0) {
                return false;
            }
        }

        return true;
    }

}
