package com.github.houbb.leetcode.datastruct.array;

import java.util.Arrays;

public class T128_longestConsecutiveSequence_V1 {

    /**
     * 是否连续？
     * @param nums 数组
     * @return 结果
     */
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        // 排序
        Arrays.sort(nums);

        int maxLen = 1;
        int tempLen = 1;
        // 对于连续的定义是什么？
        for(int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int pre = nums[i-1];
            if(num - pre == 1) {
                tempLen++;
            } else {
                // 断开
                tempLen = 1;
            }

            maxLen = Math.max(maxLen, tempLen);
        }
        return maxLen;
    }

}
