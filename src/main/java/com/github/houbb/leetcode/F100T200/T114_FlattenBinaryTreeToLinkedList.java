package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T114_FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);

        if(root != null) {
            // 清空左子树
            root.left = null;
            // 设置新的右子树
            root.right = buildRightTree(list);
        }
    }

    /**
     * 构建的时候，从后往前处理
     *
     * 1,2,3,4,5,6
     *
     * 从 6 构建，6 是最后的右边节点。
     *
     * @param list 列表
     * @return 结果
     */
    private TreeNode buildRightTree(List<Integer> list) {
        TreeNode root = null;
        TreeNode pre = null;
        for(int i = list.size()-1; i > 0 ; i--) {
            root = new TreeNode(list.get(i));

            // 右子树
            root.right = pre;

            pre = root;
        }

        return root;
    }

    /**
     * pre-order 遍历
     * @param treeNode 节点
     * @param list 数组
     */
    private void preorder(TreeNode treeNode, List<Integer> list) {
        if(treeNode == null) {
            return;
        }

        list.add(treeNode.val);

        preorder(treeNode.left, list);
        preorder(treeNode.right, list);
    }

}
