package com.github.houbb.leetcode.medium;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class BinaryTreeInorderTraversalLoop {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
     * Memory Usage: 37 MB, less than 88.15% of Java online submissions for Binary Tree Inorder Traversal.
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while(current !=null || !stack.empty()){
            // 寻找到最左边的节点
            while(current !=null){
                stack.add(current);
                current = current.left;
            }

            // pop 处理
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }

        return list;
    }

}
