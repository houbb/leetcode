package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T112_PathSum {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
     * Memory Usage: 38.9 MB, less than 69.04% of Java online submissions for Path Sum.
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(new ArrayList<>(), root, targetSum, 0);
    }

    private boolean hasPathSum(List<Integer> tempList,
                               TreeNode root, int targetSum,
                               int currentSum) {
        if(root == null) {
            return false;
        }

        tempList.add(root.val);
        currentSum += root.val;

        // 叶子
        if(root.left == null && root.right == null && targetSum == currentSum) {
            return true;
        }

        // 左右子树
        return hasPathSum(tempList, root.left, targetSum, currentSum)
                ||
        hasPathSum(tempList, root.right, targetSum, currentSum);
    }


}
