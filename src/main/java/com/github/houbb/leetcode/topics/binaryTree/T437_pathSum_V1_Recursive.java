package com.github.houbb.leetcode.topics.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class T437_pathSum_V1_Recursive {

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;
        }

        return dfs(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int dfs(TreeNode root, long targetSum) {
        if(root == null) {
            return 0;
        }
        int count = 0;
        if(root.val == targetSum) {
            count++;
        }

        // 累加左+右
        count += dfs(root.left, targetSum-root.val);
        count += dfs(root.right, targetSum-root.val);

        return count;
    }

}
