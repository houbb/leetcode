package com.github.houbb.leetcode.datastruct.array;

import java.util.*;

public class T015_threeSum_V1_SortTwoPointerOpt {


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        final int n = nums.length;
        for(int i = 0; i < n-2; i++){
            // 跳过重复的第一个数
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            // 目标值
            int left = i+1;
            int right = n-1;

            // 双指针
            while (left < right) {
                int sum = nums[i] + nums[left]+nums[right];
                if(sum == 0) {
                    List<Integer> list = Arrays.asList(nums[i], nums[left], nums[right]);
                    res.add(list);

                    // 左右避免数据重复
                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                }
                if(sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }


}
