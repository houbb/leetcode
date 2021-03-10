package com.github.houbb.leetcode.medium;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.*;

/**
 * 後續遍歷
 * @author binbin.hou
 * @since 1.0.0
 */
public class BinaryTreePostorderTraversalLoop {

    /**
     *
     * 【思路】
     *
     * 左=》右=>D
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Postorder Traversal.
     * Memory Usage: 37 MB, less than 95.15% of Java online submissions for Binary Tree Postorder Traversal.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.addFirst(p.val);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }

}
