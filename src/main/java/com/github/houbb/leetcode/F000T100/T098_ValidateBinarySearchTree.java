package com.github.houbb.leetcode.F000T100;

import com.github.houbb.leetcode.component.TreeNode;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T098_ValidateBinarySearchTree {

    /**
     * 递归：
     *
     * （1）当前节点，左，右
     * （2）左子树
     * （3）右子树
     *
     * 最大值，最小值
     *
     * @param root 根节点
     * @return 结果
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // 测试场景中会针对 int 的最大/小值做边界测试
    private boolean isValidBST(TreeNode root, long lower, long upper) {
        if(root == null) {
            return true;
        }

        int val = root.val;
        //节点的左子树只包含小于当前节点的数。
        if(lower >= val) {
            return false;
        }
        //节点的右子树只包含大于当前节点的数。
        if(upper <= val) {
            return false;
        }

        //所有左子树和右子树自身必须也是二叉搜索树。
        return isValidBST(root.left, lower, val) && isValidBST(root.right, val, upper);
    }

}
