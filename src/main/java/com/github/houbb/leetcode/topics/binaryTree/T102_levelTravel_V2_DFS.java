package com.github.houbb.leetcode.topics.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T102_levelTravel_V2_DFS {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(root, 0, resultList);
        return resultList;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> list) {
        // 结束
        if(root == null) {
            return;
        }

        // 一开始，初始化 list
        if(list.size() == level) {
            list.add(new ArrayList<>());
        }

        // 根-》左右 递归
        list.get(level).add(root.val);

        dfs(root.left, level+1, list);
        dfs(root.right, level+1, list);
    }

}
