package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T199_BinaryTreeRightSideView {

    /**
     * 本质：层级遍历，最右边的元素。
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {

        //1. level travel
        List<List<Integer>> results = new ArrayList<>();

        levelOrder(results, root, 0);

        //2. 提取最右边的元素
        List<Integer> resultList = new ArrayList<>();
        for(List<Integer> list : results) {
            resultList.add(list.get(list.size()-1));
        }

        return resultList;
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
