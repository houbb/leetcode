package com.github.houbb.leetcode.medium.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToLinkedListBetter {


    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            // 左子树不为空
            if (curr.left != null) {
                // 左子树
                TreeNode next = curr.left;
                // 前继结点
                TreeNode predecessor = next;

                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }

}
