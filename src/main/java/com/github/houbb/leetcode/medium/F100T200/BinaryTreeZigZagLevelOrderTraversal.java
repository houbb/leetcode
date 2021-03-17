package com.github.houbb.leetcode.medium.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class BinaryTreeZigZagLevelOrderTraversal {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
     * Memory Usage: 39.2 MB, less than 50.08% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();

        levelOrder(results, root, 0);

        // 根據層級進行反轉

        reverseByLevel(results);

        return results;
    }

    private void reverseByLevel(List<List<Integer>> results) {
        if(results.size() <= 1) {
            return;
        }

        // 偶數開始便利
        for(int i = 1; i < results.size(); i+=2) {
            List<Integer> list = results.get(i);
            Collections.reverse(list);

            results.set(i, list);
        }
    }

    /**
     *
     * @param results 結果
     * @param treeNode 樹
     * @param level 層級
     */
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
