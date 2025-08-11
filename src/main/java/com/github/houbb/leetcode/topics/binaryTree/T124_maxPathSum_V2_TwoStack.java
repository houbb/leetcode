package com.github.houbb.leetcode.topics.binaryTree;

import java.util.*;

public class T124_maxPathSum_V2_TwoStack {

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;

        // stack1 用于遍历树，模拟后序遍历的顺序
        Stack<TreeNode> stack1 = new Stack<>();
        // stack2 用于存储后序遍历节点的顺序，方便后续倒序处理
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        // 1. 第一次遍历，把节点按后序遍历顺序存到 stack2
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            // 先压左节点，后压右节点，保证 stack2 是后序顺序
            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }

        // 用哈希表存储每个节点的单边最大路径和（向下延伸）
        Map<TreeNode, Long> singlePathSum = new HashMap<>();
        long max = Long.MIN_VALUE;

        // 2. 倒序处理 stack2，真正从叶子节点向上计算
        while (!stack2.isEmpty()) {
            TreeNode node = stack2.pop();

            // 左子节点最大单边路径和，负数则视为0（不选取）
            long leftMax = node.left == null ? 0 : Math.max(singlePathSum.get(node.left), 0);
            // 右子节点最大单边路径和，负数则视为0
            long rightMax = node.right == null ? 0 : Math.max(singlePathSum.get(node.right), 0);

            // 当前节点为根的最大路径和（包括左右子树）
            long currMax = node.val + leftMax + rightMax;
            max = Math.max(max, currMax);

            // 返回给父节点的最大单边路径和（只能选择左边或右边）
            singlePathSum.put(node, node.val + Math.max(leftMax, rightMax));
        }

        return (int) max;
    }



}
