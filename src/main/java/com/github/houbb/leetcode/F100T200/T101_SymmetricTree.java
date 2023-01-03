package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

public class T101_SymmetricTree {

    /**
     * 判断思路：
     *
     * 1. root 的左右节点，看做两棵树
     * 2. 然后复用 T100 的，判断是否左右相同左右互换的算法？
     *
     * 特例，如果 root == null，是镜像树吗？
     * @param root 根节点
     * @return 结果
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return false;
        }

        return isSymmetricTree(root.left, root.right);
    }

    public boolean isSymmetricTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }

        //1. 值对比
        // 如果对称判断呢？
        if(p != null && q != null) {
            if(p.val == q.val) {
                return isSymmetricTree(p.left, q.right) && isSymmetricTree(p.right, q.left);
            }
            return false;
        }

        return false;
    }

}
