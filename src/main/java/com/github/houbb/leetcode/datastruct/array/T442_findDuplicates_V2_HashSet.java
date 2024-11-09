package com.github.houbb.leetcode.datastruct.array;

import java.util.*;

public class T442_findDuplicates_V2_HashSet {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)) {
                list.add(num);
            }
            set.add(num);
        }

        return list;
    }


}
