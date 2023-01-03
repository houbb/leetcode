package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

public class T110_BalancedBinaryTree {

    /**
     * 如何判断是否高度平衡？
     *
     * 1. 其实，一个节点，那么其高度是可以知道的。
     * 2. 直接对比左右，不超过1，则认为是高度平衡的。
     *
     * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one
     *
     *
     * @param root 高度
     * @return 结果
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // 递归
        // 从直觉上而言，这个算法性能其实很一遍。
        // 因为每一次都要从上到下计算一遍，优化的话应该可以考虑 DP。
        // 不过 test-case 应该比较简单，并没有考察这个点。
        int differ = Math.abs(leftHeight - rightHeight);
        if(differ > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode treeNode) {
        if(treeNode == null) {
            return 0;
        }

        return Math.max(height(treeNode.left), height(treeNode.right)) + 1;
    }

}
