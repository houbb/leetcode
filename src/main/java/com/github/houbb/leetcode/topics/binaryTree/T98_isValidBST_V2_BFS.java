package com.github.houbb.leetcode.topics.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class T98_isValidBST_V2_BFS {

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, null, null));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            Integer min = tuple.min;
            Integer max = tuple.max;

            int val = node.val;
            // 必须小于 max
            if(max != null && val >= max) {
                return false;
            }
            // 必须大于 min
            if(min != null && val <= min) {
                return false;
            }

            // 子节点继续判断
            if(node.left != null) {
                queue.offer(new Tuple(node.left, min, val));
            }
            if(node.right != null) {
                queue.offer(new Tuple(node.right, val, max));
            }
        }

        return true;
    }



    class Tuple {
        TreeNode node;
        Integer min;
        Integer max;

        public Tuple(TreeNode node, Integer min, Integer max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }

}
