package com.github.houbb.leetcode.topics.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class T230_kthSmallest_V1_Recursive {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> results = new ArrayList<>();
        dfs(root, k, results);
        return results.get(k-1);
    }

    private void dfs(TreeNode root, int k, List<Integer> results) {
        if(root == null) {
            return;
        }
        if(results.size() == k) {
            return;
        }

        dfs(root.left, k, results);

        results.add(root.val);

        dfs(root.right, k, results);
    }

}
