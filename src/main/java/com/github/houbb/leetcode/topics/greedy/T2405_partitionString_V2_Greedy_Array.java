package com.github.houbb.leetcode.topics.greedy;

import java.util.Arrays;

public class T2405_partitionString_V2_Greedy_Array {

    public int partitionString(String s) {
        int[] set = new int[26];

        int count = 1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(set[c-'a'] > 0) {
                // 清空
                Arrays.fill(set, 0);

                count++;
            }

            set[c-'a']++;
        }

        return count;
    }

}
