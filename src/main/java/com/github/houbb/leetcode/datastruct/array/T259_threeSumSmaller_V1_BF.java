package com.github.houbb.leetcode.datastruct.array;

public class T259_threeSumSmaller_V1_BF {


    /**
     * @param nums
     * @return
     */
    public int threeSumSmaller(int[] nums, int target) {
        // 处理双指针
        final int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                for(int k = j+1; k < n; k++) {
                    int sum = nums[i]+nums[j]+nums[k];
                    if(sum > target) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


}
