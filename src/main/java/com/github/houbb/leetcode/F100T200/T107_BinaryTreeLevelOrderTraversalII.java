package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T107_BinaryTreeLevelOrderTraversalII {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Level Order Traversal II.
     * Memory Usage: 39 MB, less than 89.71% of Java online submissions for Binary Tree Level Order Traversal II.
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();

        levelOrder(results, root, 0);

        // reverse
        return reverseList(results);
    }

    private List<List<Integer>> reverseList(List<List<Integer>> list) {
        if(list.size() <= 1) {
            return list;
        }

        // 从后向前遍历
        List<List<Integer>> results = new ArrayList<>();

        for(int i = list.size()-1; i >= 0; i--) {
            List<Integer> temp = list.get(i);
            results.add(temp);
        }
        return results;
    }

    private void levelOrder(List<List<Integer>> results, TreeNode treeNode, int level) {
        if(treeNode == null) {
            return;
        }

        // 当前节点
        // AVOID BOUND EX
        if(results.size() <= level) {
            results.add(new ArrayList<>());
        }
        List<Integer> list = results.get(level);

        // 节点
        int val = treeNode.val;
        list.add(val);
        results.set(level, list);

        // 左
        levelOrder(results, treeNode.left, level+1);

        // 右
        levelOrder(results, treeNode.right, level+1);
    }

}
