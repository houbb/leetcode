package com.github.houbb.leetcode.topics.binaryTree;

public class T226_invertTree_V1_Recursive {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        // 当前节点 temp 避免被覆盖
        TreeNode rightTemp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(rightTemp);

        return root;

    }

}
