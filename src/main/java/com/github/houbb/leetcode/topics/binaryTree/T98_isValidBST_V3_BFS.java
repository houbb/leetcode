package com.github.houbb.leetcode.topics.binaryTree;

public class T98_isValidBST_V3_BFS {

    private Integer pre = null;

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        // 左
        boolean leftFlag  = isValidBST(root.left);

        // 中
        int val = root.val;
        if(pre != null && pre >= val) {
            return false;
        }
        pre = val;

        // 右边
        boolean rightFlag = isValidBST(root.right);

        return leftFlag && rightFlag;
    }

}
