package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T033_V1_ForceLoop {

    public int search(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            if(target == nums[i]) {
                return i;
            }
        }

        return -1;
    }



}
