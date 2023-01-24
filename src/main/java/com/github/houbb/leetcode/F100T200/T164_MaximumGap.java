package com.github.houbb.leetcode.F100T200;

import java.util.Arrays;

public class T164_MaximumGap {

    public int maximumGap(int[] nums) {
        //1. 排序
        Arrays.sort(nums);

        //2. 遍历
        int maxGap = 0;

        for(int i = 1; i < nums.length; i++) {
            int differ = nums[i] - nums[i-1];

            if(differ > maxGap) {
                maxGap = differ;
            }
        }

        return maxGap;
    }


}
