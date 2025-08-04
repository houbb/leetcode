package com.github.houbb.leetcode.topics.twoPointer;

import java.util.*;

public class T15_threeSum_V3_TwoPointer {

    public List<List<Integer>> threeSum(int[] nums) {
        // 提前一次排序，保证整体有序
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();

        // 快速失败 最小值大于0，不可能等于0
        if (nums[0] > 0) {
            return resultList;
        }

        // 3 层循环
        for (int i = 0; i < nums.length - 2; i++) {
            // nums[i] + nums[i+1] + nums[i+2] > 0 时提前 break
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }

            // 跳过重复的 nums[i]
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 双指针
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 跳过重复的数据
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }

                    // 移动指针
                    left++;
                    right--;
                } else if (sum < 0) {
                    // 太小 left->
                    left++;
                } else {
                    // 太大 right<-
                    right--;
                }
            }
        }
        return resultList;
    }

}
