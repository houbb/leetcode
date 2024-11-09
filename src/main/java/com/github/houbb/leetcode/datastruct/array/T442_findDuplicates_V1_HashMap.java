package com.github.houbb.leetcode.datastruct.array;

import java.util.*;

public class T442_findDuplicates_V1_HashMap {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            int count = map.getOrDefault(num, 0);
            if(count > 0) {
                list.add(num);
            }
            map.put(num, count+1);
        }
        return list;
    }


}
