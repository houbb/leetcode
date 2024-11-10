package com.github.houbb.leetcode.datastruct.array;

import java.util.*;

public class T001_twoSum_V2_SortBinarySearch {


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

        // 遍历+二分  这里直接手写二分比较简单，因为直接查询数字可能会重复
        for(int i = 0; i < n-1; i++) {
            int t = target - indexList.get(i)[0];
            //从当前 i 的后面开始寻找
            int j = binarySearch(indexList, t, i+1);
            if(j > 0) {
                return new int[]{i, j};
            }
        }

        //NOT FOUND
        return new int[]{-1, -1};
    }

    private int binarySearch(List<int[]> indexList,
                             final int target,
                             final int startIx) {
        int left = startIx;
        int right = indexList.size()-1;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            int val = indexList.get(mid)[0];
            if(val == target) {
                // 原始下标
                return indexList.get(mid)[1];
            }

            // update
            if(val < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        return -1;
    }

}
