package com.github.houbb.leetcode.medium;

import com.github.houbb.leetcode.component.TreeNode;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class ValidBinarySearchTreeInOrderTraversal {

    /**
     * 中序遍历
     *
     * 左 中 右
     *
     * @param root 根节点
     * @return 结果
     */
    public boolean isValidBST(TreeNode root) {
        Long pre = Long.MIN_VALUE;
        return isValidBST(root, pre);
    }

    // 测试场景中会针对 int 的最大/小值做边界测试
    private boolean isValidBST(TreeNode root, Long pre) {
        if(root == null) {
            return true;
        }

        // 左
        boolean l = isValidBST(root.left, pre);

        // 中
        int val = root.val;
        if(val <= pre) {
            return false;
        }
        pre = (long) val;

        // 右
        boolean r = isValidBST(root.right, pre);
        return l && r;
    }

}
