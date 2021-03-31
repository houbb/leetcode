package com.github.houbb.leetcode.F1300T1400;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class AllElementsInTwoBinarySearchTrees2 {

    /**
     * 這一題实际上是2 个子问题的组合：
     *
     * （1）二叉搜索树的中序遍历
     * （2）合并 2 个有序链表
     *
     * Runtime: 13 ms, faster than 83.56% of Java online submissions for All Elements in Two Binary Search Trees.
     * Memory Usage: 42.2 MB, less than 48.03% of Java online submissions for All Elements in Two Binary Search Trees.
     *
     * @param root1
     * @param root2
     * @return
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();

        inorderTravel(root1, list);
        inorderTravel(root2, list);

        Collections.sort(list);

        return list;
    }

    private void inorderTravel(TreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }

        // 遞歸
        inorderTravel(node.left, list);
        list.add(node.val);
        inorderTravel(node.right, list);
    }

}
