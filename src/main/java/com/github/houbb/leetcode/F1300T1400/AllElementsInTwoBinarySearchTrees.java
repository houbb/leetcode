package com.github.houbb.leetcode.F1300T1400;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class AllElementsInTwoBinarySearchTrees {

    /**
     * 這一題实际上是2 个子问题的组合：
     *
     * （1）二叉搜索树的中序遍历
     * （2）合并 2 个有序链表
     * @param root1
     * @param root2
     * @return
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> listOne = new ArrayList<>();
        List<Integer> listTwo = new ArrayList<>();

        inorderTravel(root1, listOne);
        inorderTravel(root2, listTwo);

        listOne.addAll(listTwo);
        Collections.sort(listOne);

        return listOne;
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
