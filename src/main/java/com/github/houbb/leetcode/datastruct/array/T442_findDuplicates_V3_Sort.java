package com.github.houbb.leetcode.datastruct.array;

import java.util.*;

public class T442_findDuplicates_V3_Sort {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-1;i++){
            if(nums[i] == nums[i+1]) {
                list.add(nums[i]);
                i++;
            }
        }

        return list;
    }


}
