package com.github.houbb.leetcode.topics.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class T108_sortedArrayToBST_V2_BFS {

    public TreeNode sortedArrayToBST(int[] nums) {
        Queue<Tuple> queue = new LinkedList<>();
        TreeNode root = new TreeNode();
        queue.offer(new Tuple(root, 0, nums.length-1));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int left = tuple.left;
            int right = tuple.right;

            int mid = left+(right-left)/2;
            node.val = nums[mid];

            // 左右子节点
            if(left <= mid-1) {
                // 设置
                node.left = new TreeNode();
                queue.offer(new Tuple(node.left,left,mid-1));
            }
            if(right >= mid+1) {
                node.right = new TreeNode();
                queue.offer(new Tuple(node.right,mid+1,right));
            }
        }

        return root;
    }

    class Tuple {
        TreeNode node;
        int left;
        int right;

        public Tuple(TreeNode node, int left, int right) {
            this.node = node;
            this.left = left;
            this.right = right;
        }
    }

}
