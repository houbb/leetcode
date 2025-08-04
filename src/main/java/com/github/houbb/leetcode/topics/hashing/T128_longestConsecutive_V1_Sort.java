package com.github.houbb.leetcode.topics.hashing;

import java.util.*;

public class T128_longestConsecutive_V1_Sort {

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,1,2};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        if(nums.length <= 0) {
            return 0;
        }

        Arrays.sort(nums);

        // 跳过第一个数
        int tempLen = 1;
        int maxLen = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i-1] == 1) {
                tempLen++;

                maxLen = Math.max(maxLen, tempLen);
            } else if(nums[i] - nums[i-1] == 0) {
                // nothing
            } else {
                // reset
                tempLen = 1;
            }
        }

        return maxLen;
    }

}
