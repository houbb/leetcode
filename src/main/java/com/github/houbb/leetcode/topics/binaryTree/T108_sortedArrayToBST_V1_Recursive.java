package com.github.houbb.leetcode.topics.binaryTree;

public class T108_sortedArrayToBST_V1_Recursive {

    public TreeNode sortedArrayToBST(int[] nums) {
        // 数组有序 所以直接拆分为左右两个数组，dfs
        return dfs(nums, 0, nums.length-1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }

        // 中间
        int mid = left + (right-left)/2;
        TreeNode tree = new TreeNode(nums[mid]);
        tree.left = dfs(nums,left,mid-1);
        tree.right = dfs(nums,mid+1,right);
        return tree;
    }

}
