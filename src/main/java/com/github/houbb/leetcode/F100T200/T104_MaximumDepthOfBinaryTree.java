package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

/**
 * 思路：
 *
 * 1. 遍历一棵树，然后到最后一层，就是最大的长度
 * 2. 应该使用哪一种遍历？
 */
public class T104_MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        // 递归左右
        // 递归真的是神！
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }



}
