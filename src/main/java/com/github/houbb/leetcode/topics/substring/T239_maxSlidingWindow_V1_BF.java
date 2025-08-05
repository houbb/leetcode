package com.github.houbb.leetcode.topics.substring;

public class T239_maxSlidingWindow_V1_BF {


    public int[] maxSlidingWindow(int[] nums, int k) {
        int lenResult = nums.length - k + 1;
        int[] results = new int[lenResult];


        // 暴力
        int index = 0;
        for(int i = 0; i < nums.length-k+1; i++) {
            // 判断这个窗口内的最大值
            int max = nums[i];
            for(int j = i+1; j < i+k; j++) {
                if(nums[j] > max) {
                    max = nums[j];
                }

                results[index++] = max;
            }
        }

        return results;
    }

}
