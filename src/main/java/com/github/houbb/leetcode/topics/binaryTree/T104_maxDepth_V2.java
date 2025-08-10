package com.github.houbb.leetcode.topics.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class T104_maxDepth_V2 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            // 遍历当前层所有节点
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            depth++;
        }
        return depth;
    }

}
