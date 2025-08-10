package com.github.houbb.leetcode.topics.binaryTree;

public class T543_diameterOfBinaryTree_V1_Recursive {

    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        recursive(root);
        return max;
    }

    private int recursive(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 0;
        }

        int leftDepth = node.left == null ? 0 : recursive(node.left)+1; // 包含自己，所以+1
        int rightDepth = node.right == null ? 0 : recursive(node.right)+1; // 包含自己，所以+1


        // 整体最大值
        max = Math.max(max, leftDepth+rightDepth);

        // 二者最大直
        return Math.max(leftDepth, rightDepth);
    }

}
