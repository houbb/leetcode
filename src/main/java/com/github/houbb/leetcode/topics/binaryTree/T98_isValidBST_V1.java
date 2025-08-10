package com.github.houbb.leetcode.topics.binaryTree;

public class T98_isValidBST_V1 {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode root, Integer min, Integer max) {
        if(root == null) {
            return true;
        }

        int val = root.val;

        // 必须小于 max
        if(max != null && val >= max) {
            return false;
        }

        // 必须大于 min
        if(min != null && val <= min) {
            return false;
        }

        // 递归判断左右
        return dfs(root.left, min, val) && dfs(root.right, val, max);
    }

}
