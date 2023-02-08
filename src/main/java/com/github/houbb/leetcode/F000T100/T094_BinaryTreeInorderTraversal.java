package com.github.houbb.leetcode.F000T100;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T094_BinaryTreeInorderTraversal {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
     * Memory Usage: 37 MB, less than 88.15% of Java online submissions for Binary Tree Inorder Traversal.
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        travel(results, root);
        return results;
    }

    private void travel(List<Integer> list, TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        // 左
        if(treeNode.left != null) {
            travel(list, treeNode.left);
        }
        // 中
        list.add(treeNode.val);

        // 右边
        if(treeNode.right != null) {
            travel(list, treeNode.right);
        }
    }

}
