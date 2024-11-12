package com.github.houbb.leetcode.datastruct.array;

import java.util.*;

public class T018_fourSum_V2_SortAndTwoPointer {

    public static void main(String[] args) {
        T018_fourSum_V2_SortAndTwoPointer twoPointer = new T018_fourSum_V2_SortAndTwoPointer();
        twoPointer.fourSum(new int[]{1,0,-1,0,-2,2}, 0);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        final int n = nums.length;
        for(int i = 0; i < n-3; i++) {
            // 跳过重复的元素
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for(int j = i+1; j < n-2; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }

                // 双指针
                int left = j+1;
                int right = n-1;

                while (left < right) {
                    //int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    long sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if(sum == target) {
                        // 跳过后续可能重复的数据
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        res.add(list);

                        // 考虑左边
                        while (left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        // 右边
                        while (left < right && nums[right] == nums[right-1]) {
                            right--;
                        }
                    }

                    if(sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return res;
    }

}
