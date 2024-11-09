package com.github.houbb.leetcode.datastruct.array;

import java.util.Arrays;

public class T287_findDuplicate_V2_Sort {

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]) {
                 return nums[i];
            }
        }

        return -1;
    }


}
