package com.github.houbb.leetcode.topics.binaryTree;

import java.util.Stack;

public class T101_isSymmetric_V3_dfs {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();

            // 比较逻辑
            if(left == null && right == null) {
                // 这对节点对称，继续检查后续节点
                continue;
            }
            if(left == null || right == null) {
                return false;
            }

            // 值要相等
            if(left.val != right.val) {
                return false;
            }

            // 继续入栈
            stack.push(left.left);
            stack.push(right.right);

            stack.push(left.right);
            stack.push(right.left);
        }

        return true;
    }


}
