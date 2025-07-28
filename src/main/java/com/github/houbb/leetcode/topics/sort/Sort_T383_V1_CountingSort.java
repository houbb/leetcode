package com.github.houbb.leetcode.topics.sort;

public class Sort_T383_V1_CountingSort {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counts = new int[26];

        for(int i = 0; i < magazine.length(); i++) {
            counts[magazine.charAt(i)-'a']++;
        }

        for(int i = 0; i < ransomNote.length(); i++) {
            counts[ransomNote.charAt(i)-'a']--;
        }

        for(int i = 0; i < 26; i++) {
            if(counts[i] < 0) {
                return false;
            }
        }
        return true;
    }


}
