package com.github.houbb.leetcode.F1300T1400;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class AllElementsInTwoBinarySearchTreesBetter {

    /**
     * 這一題实际上是2 个子问题的组合：
     *
     * （1）二叉搜索树的中序遍历
     * （2）合并 2 个有序链表
     *
     *
     * Runtime: 12 ms, faster than 89.78% of Java online submissions for All Elements in Two Binary Search Trees.
     * Memory Usage: 43.4 MB, less than 17.82% of Java online submissions for All Elements in Two Binary Search Trees.
     * @param root1
     * @param root2
     * @return
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> listOne = new ArrayList<>();
        List<Integer> listTwo = new ArrayList<>();

        inorderTravel(root1, listOne);
        inorderTravel(root2, listTwo);

        // 如何合并2個有序的鏈表？
        return mergeTwoSortedList(listOne, listTwo);
    }

    private List<Integer> mergeTwoSortedList(List<Integer> oneList, List<Integer> twoList) {
        int oneSize = oneList.size();
        int twoSize = twoList.size();

        if(oneSize <= 0) {
            return twoList;
        }
        if(twoSize <= 0) {
            return oneList;
        }

        List<Integer> results = new ArrayList<>(oneSize+ twoSize);

        int oneIndex = 0;
        int twoIndex = 0;
        while (oneIndex < oneSize && twoIndex < twoSize) {
            // 對比當前元素
            int one = oneList.get(oneIndex);
            int two = twoList.get(twoIndex);

            if(one <= two) {
                // 添加小的到列表
                results.add(one);
                oneIndex++;
            } else {
                results.add(two);
                twoIndex++;
            }
        }

        // 補全剩餘的部分
        for(int i = oneIndex; i < oneSize; i++) {
            results.add(oneList.get(i));
        }
        for(int i = twoIndex; i < twoSize; i++) {
            results.add(twoList.get(i));
        }

        return results;
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
