package com.github.houbb.leetcode.datastruct.queryopt;

public class T1906_minDifference_V7_SegmentTree {


    class SegmentTree {
        // 定义线段树，树的每个节点存储一个大小为 101 的数组，记录该区间内每个数字的出现次数
        private int[][] tree;
        private int n;

        public SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n][101]; // 线段树大小为 4 * n
        }

        // 构建线段树
        public void build(int[] nums, int node, int start, int end) {
            if (start == end) {
                // 如果是叶子节点，将 nums[start] 对应的数字出现次数设为 1
                tree[node][nums[start]] = 1;
            } else {
                int mid = (start + end) / 2;
                int leftNode = 2 * node + 1;
                int rightNode = 2 * node + 2;
                build(nums, leftNode, start, mid);
                build(nums, rightNode, mid + 1, end);
                // 合并左右子树的信息
                for (int i = 1; i <= 100; i++) {
                    tree[node][i] = tree[leftNode][i] + tree[rightNode][i];
                }
            }
        }

        // 查询区间 [l, r] 的信息
        public int[] query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) {
                return new int[101]; // 区间完全不在查询范围内，返回一个全 0 的数组
            }
            if (l <= start && end <= r) {
                return tree[node]; // 完全包含在查询范围内，直接返回该区间的出现情况
            }
            int mid = (start + end) / 2;
            int leftNode = 2 * node + 1;
            int rightNode = 2 * node + 2;
            int[] leftResult = query(leftNode, start, mid, l, r);
            int[] rightResult = query(rightNode, mid + 1, end, l, r);
            int[] result = new int[101];
            for (int i = 1; i <= 100; i++) {
                result[i] = leftResult[i] + rightResult[i];
            }
            return result;
        }
    }

    public int[] minDifference(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int[] res = new int[m];

        // 构建线段树
        SegmentTree segmentTree = new SegmentTree(n);
        segmentTree.build(nums, 0, 0, n - 1);

        // 处理查询
        for (int q = 0; q < m; q++) {
            int left = queries[q][0];
            int right = queries[q][1];
            int[] freq = segmentTree.query(0, 0, n - 1, left, right);

            // 计算最小绝对差
            int minDiff = Integer.MAX_VALUE;
            int prev = -1;
            for (int i = 1; i <= 100; i++) {
                if (freq[i] > 0) {
                    if (prev != -1) {
                        minDiff = Math.min(minDiff, i - prev);
                    }
                    prev = i;
                }
            }

            // 如果 minDiff 没有更新，说明区间内所有元素相同
            res[q] = minDiff == Integer.MAX_VALUE ? -1 : minDiff;
        }

        return res;
    }

}
