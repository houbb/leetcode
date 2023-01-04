package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

public class T124_BinaryTreeMaximumPathSum {

    private int maxSum = Integer.MIN_VALUE;

    /**
     *
     * 思路：递归
     *
     * 问题拆分：
     *
     * 1. 左边的最大路径 + 右边的最大路径
     *
     * 2.
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        this.solve(root);

        return maxSum;
    }

    private int solve(TreeNode treeNode) {
        if(treeNode == null) {
            return 0;
        }

        //左右两边
        int maxLeft = Math.max(0, solve(treeNode.left));
        int maxRight = Math.max(0, solve(treeNode.right));

        // 更新最大路径
        maxSum = Math.max(maxSum, treeNode.val + maxLeft + maxRight);

        // 左右两条路，选择一条
        return treeNode.val + Math.max(maxLeft, maxRight);
    }

}
