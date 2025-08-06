package com.github.houbb.leetcode.topics.array;

import java.util.Arrays;

public class T189_rotate_V1_BF {



    public void rotate(int[] nums, int k) {
        if(nums.length <= 1) {
            return;
        }

        int mod = k % nums.length;
        if(mod == 0) {
            return;
        }

        // 如何移动
        for(int i = 0; i < k; i++) {
            // 如何移动一位？
            int last = nums[nums.length-1];

            // 前面的向后移动一位
            System.arraycopy(nums, 0, nums, 1, nums.length-1);
            // 队尾放在开始
            nums[0] = last;
        }
    }


}
