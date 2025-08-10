package com.github.houbb.leetcode.topics.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T102_levelTravel_V1_BFS {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> tempList = new ArrayList<>();

            // 遍历当前层所有节点
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tempList.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            resultList.add(tempList);
        }
        return resultList;
    }

}
