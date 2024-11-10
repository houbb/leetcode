package com.github.houbb.leetcode.datastruct.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T001_twoSum_V3_SortTwoPointer {


    /**
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        // 存储值+下标 避免排序后找不到原始的索引
        List<int[]> indexList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            indexList.add(new int[]{nums[i], i});
        }
        Collections.sort(indexList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 双指针
        int left = 0;
        int right = n-1;
        while (left < right) {
            int sum = indexList.get(left)[0] - indexList.get(right)[0];

            if(sum == target) {
                return new int[]{indexList.get(left)[1]+1, indexList.get(right)[1]+1};
            }
            if(sum < target) {
                left++;
            }
            if(sum > target) {
                right--;
            }
        }

        //NOT FOUND
        return new int[]{-1, -1};
    }

}
