package com.github.houbb.leetcode.topics.binaryTree;

import java.util.*;

public class T230_kthSmallest_V2_Stack {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        int count = 0;
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            // 左节点一直入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            // 根
            cur = stack.pop();
            count++;
            if(count == k) {
                return cur.val;
            }

            // 右节点
            cur = cur.right;
        }

        //NOT FOUND
        return -1;
    }



}
