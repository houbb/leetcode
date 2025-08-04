package com.github.houbb.leetcode.topics.twoPointer;

import java.util.*;

public class T15_threeSum_V1_BF {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        // 去重
        Set<String> stringSet = new HashSet<>();

        // 3 层循环
        for(int i = 0; i < nums.length-2; i++) {
            for(int j = i+1; j < nums.length-1; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tempList = Arrays.asList(nums[i], nums[j], nums[k]);
                        // 排序
                        Collections.sort(tempList);
                        String key = tempList.toString();
                        if(stringSet.contains(key)) {
                            continue;
                        }
                        stringSet.add(key);

                        resultList.add(tempList);
                    }
                }
            }
        }
        return resultList;
    }

}
