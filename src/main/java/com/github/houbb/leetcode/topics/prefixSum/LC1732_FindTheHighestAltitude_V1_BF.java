package com.github.houbb.leetcode.topics.prefixSum;

public class LC1732_FindTheHighestAltitude_V1_BF {


    public int largestAltitude(int[] gain) {
        // 默认从0开始？
        int high = 0;
        int max = high;

        for(int i = 0; i < gain.length; i++) {
            high = high + gain[i];
            max = Math.max(max, high);
        }
        return max;
    }

}
