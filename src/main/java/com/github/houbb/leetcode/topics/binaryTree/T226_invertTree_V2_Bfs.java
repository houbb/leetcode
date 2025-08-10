package com.github.houbb.leetcode.topics.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class T226_invertTree_V2_Bfs {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 拿出当前节点
            TreeNode cur = queue.poll();
            // 交换左右
            TreeNode tempRight = cur.right;
            cur.right = cur.left;
            cur.left = tempRight;

            // 左右子节点入队列
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null) {
                queue.offer(cur.right);
            }
        }

        return root;
    }

}
