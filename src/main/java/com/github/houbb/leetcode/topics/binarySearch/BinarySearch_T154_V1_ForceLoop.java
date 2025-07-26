package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T154_V1_ForceLoop {

    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int num : nums) {
            min = Math.min(num, min);
        }
        return min;
    }



}
