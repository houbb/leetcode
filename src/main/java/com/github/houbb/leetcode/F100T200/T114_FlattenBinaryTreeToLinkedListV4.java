package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

public class T114_FlattenBinaryTreeToLinkedListV4 {


    /**
     * 优化思路：
     *
     * 1. 前面的做法，最大的问题就是实际上是遍历了2次。
     *
     * 那能不能一遍遍历，一遍构建呢？
     *
     *
     * @param root 根
     */
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            // 左子树不为空
            if (cur.left != null) {
                // 左子树
                TreeNode next = cur.left;
                // 前继结点
                TreeNode pre = next;

                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }

}
