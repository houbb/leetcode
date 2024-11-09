package com.github.houbb.leetcode.datastruct.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T219_ContainsDup_V1_HashMap {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> countMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            List<Integer> indexList = countMap.getOrDefault(num, new ArrayList<>());
            if(!indexList.isEmpty()) {
                int minLen = i - indexList.get(indexList.size()-1);
                if(minLen <= k) {
                    return true;
                }
            }
            indexList.add(i);

            // i-j <= k
            // 判断是否满足条件
            countMap.put(num, indexList);
        }

        return false;
    }


}
