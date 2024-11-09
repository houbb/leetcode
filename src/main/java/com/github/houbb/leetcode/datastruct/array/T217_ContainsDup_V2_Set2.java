package com.github.houbb.leetcode.datastruct.array;

import java.util.HashSet;
import java.util.Set;

public class T217_ContainsDup_V2_Set2 {

    public boolean containsDuplicate(int[] nums) {
        if (nums==null || nums.length<2) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

}
