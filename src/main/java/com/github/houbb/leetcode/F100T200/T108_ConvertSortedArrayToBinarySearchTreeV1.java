package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.Arrays;
import java.util.List;

public class T108_ConvertSortedArrayToBinarySearchTreeV1 {

    /**
     * 数组严格有序
     *
     * 1. 树的 inorder 遍历?
     * 2. 如何构建 TREE 呢？
     *
     * 左=》中=》右
     *
     * 递归处理？
     *
     *
     * @param nums 数组
     * @return 结果
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length <= 0) {
            return null;
        }

        //root 节点如何确定？
        //root 节点，是中间的那一个。（偶数的时候，随便选择一个即可。）
        int mid = nums.length / 2;

        TreeNode root = new TreeNode(nums[mid]);

        // 递归构建左边
        int[] leftNums = Arrays.copyOfRange(nums, 0, mid);
        root.left = this.sortedArrayToBST(leftNums);

        // 递归构建右边
        int[] rightNums = Arrays.copyOfRange(nums, mid+1, nums.length);;
        root.right = this.sortedArrayToBST(rightNums);

        return root;
    }

    // 拷贝的数组，根本也用不到

    public static void main(String[] args) {
        int[] inorder = new int[] {-10,-3,0,5,9};

        TreeNode treeNode = new T108_ConvertSortedArrayToBinarySearchTreeV1().sortedArrayToBST(inorder);

        // 输出-层级遍历
        List<List<Integer>> list = new T102_BinaryTreeLevelOrderTraversal().levelOrder(treeNode);
        System.out.println(list);
    }

}
