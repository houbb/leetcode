package com.github.houbb.leetcode.topics.sort;

import java.util.Arrays;

public class Sort_T164_MaxGap_V1_Sort {


    public int maximumGap(int[] nums) {
        Arrays.sort(nums);

        int maxGap = 0;

        for(int i = 1; i < nums.length; i++) {
            maxGap = Math.max(nums[i]-nums[i-1], maxGap);
        }

        return maxGap;
    }

}
