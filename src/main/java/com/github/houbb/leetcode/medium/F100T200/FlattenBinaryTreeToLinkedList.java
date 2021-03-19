package com.github.houbb.leetcode.medium.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);

        if(root != null) {
            // 清空左子树
            root.left = null;
            // 设置新的右子树
            root.right = buildRightTree(list);
        }
    }

    private TreeNode buildRightTree(List<Integer> list) {
        TreeNode root = null;
        TreeNode pre = null;
        for(int i = list.size()-1; i > 0 ; i--) {
            root = new TreeNode(list.get(i));

            // 右子树
            root.right = pre;

            pre = root;
        }

        return root;
    }

    private void preorder(TreeNode treeNode, List<Integer> list) {
        if(treeNode == null) {
            return;
        }

        list.add(treeNode.val);

        preorder(treeNode.left, list);
        preorder(treeNode.right, list);
    }

}
