package com.github.houbb.leetcode.topics.binaryTree;

import java.util.Stack;

public class T226_invertTree_V3_Dfs {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            // 拿出当前节点
            TreeNode cur = stack.pop();
            // 交换左右
            TreeNode tempRight = cur.right;
            cur.right = cur.left;
            cur.left = tempRight;

            // 左右子节点入stack
            if(cur.left != null) {
                stack.push(cur.left);
            }
            if(cur.right != null) {
                stack.push(cur.right);
            }
        }

        return root;
    }

}
