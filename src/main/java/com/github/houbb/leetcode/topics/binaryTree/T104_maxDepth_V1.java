package com.github.houbb.leetcode.topics.binaryTree;

public class T104_maxDepth_V1 {

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
