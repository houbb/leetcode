package com.github.houbb.leetcode.F100T200;

import java.util.Arrays;

public class T128_LongestConsecutiveSequence {

    /**
     * 思路：
     *
     * 1. 第一步排序
     * 2. 然后再进行 O(n) 的遍历，计算连续值
     * 2.1 相差1，或者不差值？
     * @param nums 数组
     * @return 结果
     */
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 0) {
            return 0;
        }

        Arrays.sort(nums);

        int maxLen = 1;
        int curLen = 1;

        // loop
        for(int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int pre = nums[i-1];

            // 是否是连续的？
            int differ = cur - pre;
            if(differ == 0) {
                // 不变
            } else if (differ == 1) {
                // +1
                curLen++;
                if(curLen > maxLen) {
                    maxLen = curLen;
                }
            } else {
                // 不连续，重置为1？还是重置为0
                curLen = 1;
            }
        }

        return maxLen;
    }

}
