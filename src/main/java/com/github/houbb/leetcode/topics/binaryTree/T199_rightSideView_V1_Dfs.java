package com.github.houbb.leetcode.topics.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class T199_rightSideView_V1_Dfs {

    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        int level = 0;
        dfs(root, level, levelList);

        // 最后一个值
        List<Integer> resultList = new ArrayList<>();
        for(List<Integer> item : levelList) {
            resultList.add(item.get(item.size()-1));
        }
        return resultList;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> levelList) {
        if(root == null) {
            return;
        }
        if(level == levelList.size()) {
            levelList.add(new ArrayList<>());
        }

        levelList.get(level).add(root.val);

        // dfs
        dfs(root.left, level+1, levelList);
        dfs(root.right, level+1, levelList);
    }

}
