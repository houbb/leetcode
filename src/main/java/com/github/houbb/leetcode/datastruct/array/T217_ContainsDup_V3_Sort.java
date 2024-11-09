package com.github.houbb.leetcode.datastruct.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T217_ContainsDup_V3_Sort {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]) {
                return true;
            }
        }

        return false;
    }

}
