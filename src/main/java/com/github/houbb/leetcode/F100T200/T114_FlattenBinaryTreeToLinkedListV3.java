package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

public class T114_FlattenBinaryTreeToLinkedListV3 {

    private TreeNode preNode = null;

    /**
     * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/solutions/36977/my-short-post-order-traversal-java-solution-for-share/
     *
     * 我们本来想要的结果是：1,2,3,4,5,6 的这种 preOrder
     *
     * 回想起我们上一个的构建方式，是 preOrder 获取到 1-6，然后倒着处理。
     *
     * 那么，我们直接使用 postOrder 遍历，是不是就省得倒过来了，因为本身 post-order 就是 6,5,4,3,2,1
     *
     * 这种设计真的是巧妙！！
     *
     * @param root 根
     */
    public void flatten(TreeNode root) {
        //1. 递归处理
        // 终止条件
        if(root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);

        // 处理逻辑
        root.right = preNode;
        // left 置空
        root.left = null;
        preNode = root;
    }

}
