package com.github.houbb.leetcode.topics.binaryTree;

public class T236_lowestCommonAncestor_V1 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        // 如果二者就是 root
        if(root == p || root == q) {
            return root;
        }

        // 递归找最近的子树
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        //看二者的位置
        // 两边
        if(leftNode != null && rightNode != null) {
            return root;
        }

        // 单边
        if(leftNode != null) {
            return leftNode;
        }
        return rightNode;
    }

}
