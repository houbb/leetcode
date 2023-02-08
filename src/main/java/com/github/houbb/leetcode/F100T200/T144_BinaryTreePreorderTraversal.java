package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T144_BinaryTreePreorderTraversal {

    /**
     *
     * 【思路】
     *
     * 数据=》左=》右
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
     * Memory Usage: 37 MB, less than 89.16% of Java online submissions for Binary Tree Preorder Traversal.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        travel(results, root);
        return results;
    }

    private void travel(List<Integer> list, TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        // 数据
        list.add(treeNode.val);
        // 左
        if(treeNode.left != null) {
            travel(list, treeNode.left);
        }
        // 右边
        if(treeNode.right != null) {
            travel(list, treeNode.right);
        }
    }

}
