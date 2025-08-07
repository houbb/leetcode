package com.github.houbb.leetcode.datastruct.array;

import java.util.Arrays;

public class T287_findDuplicate_V3_NegativeMark {

    public int findDuplicate(int[] nums) {
        // 其数字都在 [1, n] 范围内（包括 1 和 n）
        for(int i = 0; i < nums.length-1; i++){
            int val = Math.abs(nums[i]);

            if(nums[val] < 0) {
                return nums[i];
            }

            nums[val] = -val;
        }

        return -1;
    }


}
