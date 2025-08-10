package com.github.houbb.leetcode.topics.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class T94_binaryTreeInOrder_V1 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        // 递归
        travel(root, list);

        return list;
    }

    private void travel(TreeNode root, List<Integer> list) {
        // 终止
        if(root == null) {
            return;
        }

        // 中
        list.add(root.val);
        travel(root.left, list);
        travel(root.right, list);
    }

}
