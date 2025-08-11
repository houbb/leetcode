package com.github.houbb.leetcode.topics.binaryTree;

import java.util.*;

public class T114_flatten_V2_DFS_Stack {

    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }

        List<TreeNode> preOrderList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            preOrderList.add(node);

            // 保障左先出，所以后入
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }

        // 递归构建子树
        // 用迭代试一下
        TreeNode cur = root;
        for(int i = 1; i < preOrderList.size(); i++) {
            cur.right = preOrderList.get(i);
            cur.left = null;
            cur = preOrderList.get(i);
        }
    }



}
