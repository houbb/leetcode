package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.List;

public class T108_ConvertSortedArrayToBinarySearchTree {

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
        //root 节点如何确定？
        //root 节点，是中间的那一个。（偶数的时候，随便选择一个即可。）
        return sortedArrayToBST(nums, 0, nums.length);
    }

    public TreeNode sortedArrayToBST(int[] nums, int fromIndex, int toIndex) {
        if(fromIndex > toIndex) {
            return null;
        }

        // 新的中间节点
        // 这里还可使用位运算，替代除法。
        int midIndex = fromIndex + (toIndex - fromIndex) / 2;
        TreeNode root = new TreeNode(nums[midIndex]);

        // 递归构建左边
        root.left = this.sortedArrayToBST(nums, fromIndex, midIndex);

        // 递归构建右边
        root.right = this.sortedArrayToBST(nums, midIndex+1, toIndex);

        return root;
    }


    // 拷贝的数组，根本也用不到。所以不需要拷贝
    // 只需要把 from to 传入进去，然后变化对应的下标志即可。

    public static void main(String[] args) {
        int[] inorder = new int[] {-10,-3,0,5,9};

        TreeNode treeNode = new T108_ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(inorder);

        // 输出-层级遍历
        List<List<Integer>> list = new T102_BinaryTreeLevelOrderTraversal().levelOrder(treeNode);
        System.out.println(list);
    }

}
