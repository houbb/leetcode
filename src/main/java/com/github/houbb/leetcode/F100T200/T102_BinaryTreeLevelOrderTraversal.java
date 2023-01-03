package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T102_BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();

        levelOrder(results, root, 0);

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
