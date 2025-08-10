package com.github.houbb.leetcode.topics.binaryTree;

public class T101_isSymmetric_V1_Recursive {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        // 比较
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }

        // 值要相等
        if(left.val != right.val) {
            return false;
        }
        // 递归
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

}
