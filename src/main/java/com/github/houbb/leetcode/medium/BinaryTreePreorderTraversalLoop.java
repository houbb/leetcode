package com.github.houbb.leetcode.medium;

import com.github.houbb.leetcode.component.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class BinaryTreePreorderTraversalLoop {

    /**
     *
     * 【思路】
     *
     * 数据=》左=》右
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
     * Memory Usage: 36.9 MB, less than 95.24% of Java online submissions for Binary Tree Preorder Traversal.
     *
     */
    public List<Integer> preorderTraversal(TreeNode node) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> rights = new Stack<>();

        while(node != null) {
            list.add(node.val);
            if (node.right != null) {
                rights.push(node.right);
            }
            node = node.left;
            if (node == null && !rights.isEmpty()) {
                node = rights.pop();
            }
        }
        return list;
    }

}
