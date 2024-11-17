package com.github.houbb.leetcode.datastruct.queryopt;

import java.util.*;

public class T1906_minDifference_V3_binarySearch {


    public int[] minDifference(int[] nums, int[][] queries) {
        // 记录数字 i (1 <= i <= 100) 出现在 nums 中的所有位置
        Map<Integer, List<Integer>> idx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = idx.getOrDefault(i, new ArrayList<>());
            list.add(i);
            idx.put(nums[i], list);
        }

        // 获取已出现过的数字并排序
        List<Integer> keys = new ArrayList<>(idx.keySet());
        Collections.sort(keys);

        int[] res = new int[queries.length];

        // 遍历每个查询
        for (int q = 0; q < queries.length; q++) {
            int l = queries[q][0];
            int r = queries[q][1];
            int minDiff = Integer.MAX_VALUE;
            int pre = 0;

            // 遍历已出现的数字
            for (int i : keys) {
                List<Integer> positions = idx.get(i);

                // 判断数字 i 是否出现在 [l, r] 区间
                int pos = lowerBound(positions, l);
                if (pos < positions.size() && positions.get(pos) <= r) {
                    // 如果存在相邻的两个不同数字，更新最小绝对差
                    if (pre > 0) {
                        minDiff = Math.min(minDiff, i - pre);
                    }
                    pre = i;
                }
            }

            // 如果 minDiff 未被更新，说明区间内只有一种数字
            res[q] = (minDiff == Integer.MAX_VALUE) ? -1 : minDiff;
        }

        return res;
    }

    // 二分查找：找到第一个大于等于 target 的位置
    private int lowerBound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
