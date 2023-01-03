package com.github.houbb.leetcode.F000T100;

import com.github.houbb.leetcode.component.TreeNode;

/**
 *【思路】
 *
 * 1. 同时遍历整2棵树
 * 2. 对比每一个节点，全部相同则通过
 *
 */
public class T100_SameTree {

    /**
     * 递归：
     *
     * （1）当前节点，左，右
     * （2）左子树
     * （3）右子树
     *
     * 最大值，最小值
     * @param p p
     * @param q q
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }

        //1. 值对比
        if(p != null && q != null) {
            if(p.val == q.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
            return false;
        }

        return false;
    }

}
