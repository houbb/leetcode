package com.github.houbb.leetcode.F000T100;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T095_UniqueBinarySearchTreesII {

    /**
     * 1 <= n <= 8
     *
     * Runtime: 1 ms, faster than 93.81% of Java online submissions for Unique Binary Search Trees II.
     * Memory Usage: 39.2 MB, less than 88.47% of Java online submissions for Unique Binary Search Trees II.
     *
     * @param n 整数
     * @return 结果
     */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();
        return getList(1, n);
    }

    private List<TreeNode> getList(int start, int end) {
        List<TreeNode> results = new ArrayList<>();

        //此时没有数字，将 null 加入结果中
        if(start > end) {
            results.add(null);
            return results;
        }
        //只有一个数字，当前数字作为一棵树加入结果中
        if(start == end) {
            TreeNode treeNode = new TreeNode(start);
            results.add(treeNode);
            return results;
        }

        // 遍历所有的可能
        for(int i = start; i <= end; i++) {
            // 所有的左子树
            List<TreeNode> lefts = getList(start, i-1);
            // 所有的右子树
            List<TreeNode> rights = getList(i+1, end);
            // 整合为一棵树
            for(TreeNode left : lefts) {
                for(TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    results.add(root);
                }
            }
        }

        return results;
    }

}
