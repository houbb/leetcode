package com.github.houbb.leetcode.datastruct.queryopt;

import java.util.Arrays;
import java.util.TreeSet;

public class T1906_minDifference_V6_BIT {


    // 树状数组实现
    static class FenwickTree {
        int[] bit;
        int n;

        public FenwickTree(int size) {
            this.n = size;
            this.bit = new int[size + 1];
        }

        // 更新树状数组
        public void update(int index, int delta) {
            while (index <= n) {
                bit[index] += delta;
                index += index & -index; // 更新父节点
            }
        }

        // 查询前缀和
        public int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += bit[index];
                index -= index & -index; // 查询父节点
            }
            return sum;
        }

        // 查询区间 [left, right] 的和
        public int queryRange(int left, int right) {
            return query(right) - query(left - 1);
        }
    }

    public int[] minDifference(int[] nums, int[][] queries) {
        final int n = nums.length;
        int maxVal = 100; // nums 中的值范围为 1 到 100

        // 初始化树状数组
        FenwickTree[] fenwickTrees = new FenwickTree[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            fenwickTrees[i] = new FenwickTree(n);
        }
        // 更新树状数组，记录 nums 中每个元素的频次
        for (int i = 0; i < n; i++) {
            fenwickTrees[nums[i]].update(i + 1, 1); // 将元素 nums[i] 计入树状数组
        }

        // 处理每个查询
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0] + 1;
            int right = queries[i][1] + 1;

            int minDiff = Integer.MAX_VALUE;    // 最小差值初始化为一个很大的数
            int pre = -1;    // 上一个出现的元素
            // 遍历 1 到 100 的所有数字，检查在区间 [left, right] 内的出现情况
            for (int j = 1; j <= maxVal; j++) {
                if (fenwickTrees[j].queryRange(left, right) > 0) {
                    // 计算差值
                    if (pre != -1) {
                        minDiff = Math.min(minDiff, j - pre);
                    }
                    pre = j;
                }
            }

            // 如果 minDiff 没有更新，说明区间内没有不同的元素
            res[i] = (minDiff == Integer.MAX_VALUE) ? -1 : minDiff;
        }

        return res;
    }

}
