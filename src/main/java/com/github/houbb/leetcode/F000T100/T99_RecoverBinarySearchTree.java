package com.github.houbb.leetcode.F000T100;

import com.github.houbb.leetcode.component.TreeNode;

/**
 *【思路】
 *
 * 1. 如何找到是否为合法的 BST？
 *
 * 2. 如何找到2个节点？
 *
 * 3. 如何互换？
 *
 */
public class T99_RecoverBinarySearchTree {

    private TreeNode first = null;
    private TreeNode second = null;

    private TreeNode pre = null;

    /**
     * 递归：
     *
     * （1）当前节点，左，右
     * （2）左子树
     * （3）右子树
     *
     * 最大值，最小值
     *
     * 1. 递归整颗树，获取到2个错误的节点。
     * 2. 交换 2 节点
     *
     * @param root 根节点
     */
    public void recoverTree(TreeNode root) {
        inorder(root);

        // 交换 2 个元素
        swapNodeValue();
    }

    private void swapNodeValue() {
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    /**
     * 中序: 正常而言，BST 应该是一颗有序的数组。
     *
     * 左子树 => 根 => 右子树。
     *
     *
     * 6, 3, 4, 5, 2
     *
     *
     * 6 is first elem because 6 > 3
     *
     * and 2 is the second element to swap because 2 < 5.
     *
     * 交换后：2,3,4,5,6
     *
     * @param root 根节点
     */
    private void inorder(TreeNode root) {
        if(root == null) {
            return;
        }

        //fast-return?
        if(first != null && second != null) {
            return;
        }

        // 递归左边节点
        inorder(root.left);

        //do sth
        // 第一个节点：第一个节点，大于后面的元素。
        // pre > root，则 pre 是第一个节点
        // 兼容一下 pre 为空的情况
        if(first == null && (pre == null || pre.val > root.val)) {
            first = pre;
        }
        // 第二个元素，在第一个元素找到之后
        // pre > root，则 root 为要找的节点
        if(first != null && pre.val > root.val) {
            second = root;
        }
        // 更新当前节点为上一个节点
        pre = root;

        // 递归右边节点
        inorder(root.right);
    }

}
