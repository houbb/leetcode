package com.github.houbb.leetcode.topics.twoPointer;

import java.util.*;

public class T15_threeSum_V2_HashMap {

    public List<List<Integer>> threeSum(int[] nums) {
        // 提前一次排序，保证整体有序
        Arrays.sort(nums);

        Map<Integer, Integer> numAndLastIndexMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            numAndLastIndexMap.put(num, i);
        }

        List<List<Integer>> resultList = new ArrayList<>();

        // 3 层循环
        for(int i = 0; i < nums.length-2; i++) {
            for(int j = i+1; j < nums.length-1; j++) {
                // nums[k] = (nums[i] + nums[j] ) * -1;
                int target = (nums[i] + nums[j] ) * -1;

                Integer k = numAndLastIndexMap.get(target);
                if(k != null && k > j) {
                    resultList.add(Arrays.asList(nums[i], nums[j], target));
                }

                while (nums[j+1] == nums[j] && j < nums.length-2) {
                    j++;
                }
            }

            // 如何跳过相同的数字
            while (nums[i+1] == nums[i] && i < nums.length-3) {
                i++;
            }
        }
        return resultList;
    }

}
