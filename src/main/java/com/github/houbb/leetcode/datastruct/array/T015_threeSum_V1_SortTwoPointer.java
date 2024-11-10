package com.github.houbb.leetcode.datastruct.array;

import java.util.*;

public class T015_threeSum_V1_SortTwoPointer {


    /**
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> res = new HashSet<>();

        final int n = nums.length;
        // 因为是有序的，从前面找2个数字，等于当前数字更加合理。
        // nums[j] + nums[k] == -nums[i]

        for(int i = 0; i < n; i++){
            int target = -nums[i];

            int left = 0;
            int right = n-1;

            // 找两个数
            while (left < right) {
                int sum = nums[left]+nums[right];
                if(sum == target) {
                    // 排序+去重
                    if(i != left && left != right && i != right) {
                        List<Integer> list = Arrays.asList(nums[left], nums[right], nums[i]);
                        Collections.sort(list);
                        res.add(list);
                    }
                }
                if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return new ArrayList<>(res);
    }


}
