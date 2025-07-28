package com.github.houbb.leetcode.topics.sort;

public class Sort_T242_V1_ValidAnagram_CountingSort {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] count1 = getCharsCount(s);
        int[] count2 = getCharsCount(t);

        // 对比
        for(int i = 0; i < 26; i++) {
            if(count1[i] != count2[i]) {
                return false;
            }
        }

        return true;
    }

    private int[] getCharsCount(String s) {
        int[] ints = new int[26];

        char[] chars = s.toCharArray();
        for(char c : chars) {
            int index = c-'a';
            int count = ints[index];
            ints[index] = count+1;
        }

        return ints;
    }

}
