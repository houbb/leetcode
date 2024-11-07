package com.github.houbb.leetcode.F1000T1100;

public class T1124longestWPI {

    public int longestWPI(int[] hours) {
        final int n = hours.length;
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            if(hours[i] > 8) {
                nums[i] = 1;
            } else {
                nums[i] = -1;
            }
        }


        // 然后计算最长子数组？
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        // 计算最长的数组？
        // 找到大于0的最长子数组
        for(int step = nums.length-1; step >= 0; step--) {
            for(int i = 0; i < nums.length - step; i++) {
                int sum = prefix[i+step] - prefix[i] + nums[i];
                if(sum > 0) {
                    return step+1;
                }
            }
        }

        return 0;
    }


}
