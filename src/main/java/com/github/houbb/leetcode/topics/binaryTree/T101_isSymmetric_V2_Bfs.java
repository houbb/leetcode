package com.github.houbb.leetcode.topics.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class T101_isSymmetric_V2_Bfs {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

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
            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }


}
