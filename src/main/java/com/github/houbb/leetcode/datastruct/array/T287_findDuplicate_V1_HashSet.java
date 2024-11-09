package com.github.houbb.leetcode.datastruct.array;

import java.util.*;

public class T287_findDuplicate_V1_HashSet {

    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(set.contains(num)) {
                return num;
            }

            set.add(num);
        }

        return -1;
    }


}
