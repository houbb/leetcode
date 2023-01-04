package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T113_PathSumIIV2 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        getAllPathSum(allPaths, new ArrayList<>(), root, targetSum, 0);
        return allPaths;
    }

    private void getAllPathSum(List<List<Integer>> allPaths, List<Integer> tempList,
                               TreeNode root, int targetSum, int currentSum) {
        if(root == null) {
            return ;
        }

        tempList.add(root.val);
        currentSum += root.val;

        // 叶子
        if(root.left == null && root.right == null && targetSum == currentSum) {
            allPaths.add(tempList);
        }

        // 左右子树
        getAllPathSum(allPaths, new ArrayList<>(tempList), root.left, targetSum, currentSum);
        getAllPathSum(allPaths, new ArrayList<>(tempList), root.right, targetSum, currentSum);
    }


}
