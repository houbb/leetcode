package com.github.houbb.leetcode.topics.array;

public class T41_firstMissingPositive_v3_Negative {

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }

    // 这一题大概率是数字哈希来解决
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 1. 忽略掉过大、过小的数
        for(int i = 0; i < n; i++) {
            if(nums[i] <= 0 || nums[i] > n) {
                nums[i] = n+1;
            }
        }

        //2. 利用负号标记 1 ~ n 是否出现过
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val <= n) {
                nums[val - 1] = -Math.abs(nums[val - 1]);
            }
        }

        //3. 再次判断一次
        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                return i+1;
            }
        }

        return n+1;
    }


}
