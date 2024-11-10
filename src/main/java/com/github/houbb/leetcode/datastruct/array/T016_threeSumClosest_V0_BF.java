package com.github.houbb.leetcode.datastruct.array;

import java.util.Arrays;

public class T016_threeSumClosest_V0_BF {


    /**
     * @param nums
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        // 处理双指针
        final int n = nums.length;
        int result = Integer.MAX_VALUE;
        int minDis = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                for(int k = j+1; k < n; k++) {
                    int sum = nums[i]+nums[j]+nums[k];
                    int dis = Math.abs(sum - target);
                    if(minDis > dis) {
                        minDis = dis;
                        result = sum;
                    }
                }
            }
        }
        return result;
    }


}
