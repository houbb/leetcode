package com.github.houbb.leetcode.topics.binaryTree;

public class T124_maxPathSum_V1 {

    private long max = Long.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return (int)max;
    }

    // 以当前节点作为根节点的单边最大值
    public long dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }

        // 左边最大
        long leftMax = Math.max(dfs(root.left), 0);
        // 右边最大
        long rightMax = Math.max(dfs(root.right), 0);

        // 当前节点最大值
        long curMax = root.val + leftMax + rightMax;
        if(max < curMax) {
            max = curMax;
        }

        // 返回时，只能返回单边的最大值 避免递归混乱
        return root.val + Math.max(leftMax, rightMax);
    }


}
