package com.github.houbb.leetcode.datastruct.queryopt;

import java.util.Arrays;
import java.util.TreeSet;

public class T1906_minDifference_V5_mos {


    static class Query implements Comparable<Query> {
        int left, right, index, queryBlockSize;

        Query(int left, int right, int index, int queryBlockSize) {
            this.left = left;
            this.right = right;
            this.index = index;
            this.queryBlockSize = queryBlockSize;
        }

        @Override
        public int compareTo(Query other) {
            int blockSize = queryBlockSize; // 块大小，sqrt(n) 的近似值
            int blockA = this.left / blockSize;
            int blockB = other.left / blockSize;
            if (blockA != blockB) {
                return blockA - blockB;
            }
            return (blockA % 2 == 0) ? this.right - other.right : other.right - this.right;
        }
    }

    public int[] minDifference(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        // 构造 Query 对象
        Query[] queryList = new Query[q];
        final int querySize = (int) Math.sqrt(n);
        for (int i = 0; i < q; i++) {
            queryList[i] = new Query(queries[i][0], queries[i][1], i, querySize);
        }

        // 排序查询
        Arrays.sort(queryList);

        // 结果数组
        int[] result = new int[q];

        // 滑动窗口的状态
        int[] freq = new int[101]; // 记录每个数出现的频率
        TreeSet<Integer> activeNumbers = new TreeSet<>(); // 有序集合记录当前区间中出现的数

        int currentL = 0, currentR = -1;

        // 处理每个查询
        for (Query query : queryList) {
            int L = query.left, R = query.right;

            // 扩展或缩小左边界
            while (currentL < L) {
                int num = nums[currentL];
                freq[num]--;
                if (freq[num] == 0) {
                    activeNumbers.remove(num);
                }
                currentL++;
            }
            while (currentL > L) {
                currentL--;
                int num = nums[currentL];
                freq[num]++;
                if (freq[num] == 1) {
                    activeNumbers.add(num);
                }
            }

            // 扩展或缩小右边界
            while (currentR < R) {
                currentR++;
                int num = nums[currentR];
                freq[num]++;
                if (freq[num] == 1) {
                    activeNumbers.add(num);
                }
            }
            while (currentR > R) {
                int num = nums[currentR];
                freq[num]--;
                if (freq[num] == 0) {
                    activeNumbers.remove(num);
                }
                currentR--;
            }

            // 计算结果：最小差绝对值
            if (activeNumbers.size() <= 1) {
                result[query.index] = -1; // 如果只有一个元素或没有元素，返回 -1
            } else {
                int minDiff = Integer.MAX_VALUE;
                Integer prev = null;
                for (int num : activeNumbers) {
                    if (prev != null) {
                        minDiff = Math.min(minDiff, num - prev);
                    }
                    prev = num;
                }
                result[query.index] = minDiff;
            }
        }

        return result;
    }

}
