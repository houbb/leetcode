package com.github.houbb.leetcode.topics.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T94_binaryTreeInOrder_V2_LOOP {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            // 1. 不断向左走，把沿途节点压栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            // 访问
            cur = stack.pop();
            list.add(cur.val);

            // 3. 转向右子树
            cur = cur.right;
        }

        return list;
    }


}
