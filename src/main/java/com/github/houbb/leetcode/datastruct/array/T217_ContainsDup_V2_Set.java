package com.github.houbb.leetcode.datastruct.array;

import java.util.HashSet;
import java.util.Set;

public class T217_ContainsDup_V2_Set {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        return set.size() < nums.length;
    }

}
