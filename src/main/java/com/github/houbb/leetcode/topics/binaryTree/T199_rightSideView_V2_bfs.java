package com.github.houbb.leetcode.topics.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T199_rightSideView_V2_bfs {

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> levelList = new ArrayList<>();
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 当前层全部出队列
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tempList.add(node.val);

                // 左右子树入队列
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }

            level++;
            levelList.add(tempList);
        }

        // 最后一个值
        List<Integer> resultList = new ArrayList<>();
        for(List<Integer> item : levelList) {
            resultList.add(item.get(item.size()-1));
        }
        return resultList;
    }

}
