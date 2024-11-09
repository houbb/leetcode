package com.github.houbb.leetcode.datastruct.array;

import java.util.HashMap;
import java.util.Map;

public class T217_ContainsDup_V1_HashMap {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums){
            countMap.put(num, countMap.getOrDefault(num, 0) +1);
        }

        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if(entry.getValue() != 1) {
                return false;
            }
        }

        return true;
    }

}
