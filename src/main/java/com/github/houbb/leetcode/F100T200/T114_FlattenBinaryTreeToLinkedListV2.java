package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T114_FlattenBinaryTreeToLinkedListV2 {

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
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
     * PS: 这种方式，和上面一个差不多。性能没有太大的变化。
     *
     * @param list 列表
     * @return 结果
     */
    private TreeNode buildRightTree(List<TreeNode> list) {
        TreeNode root = null;
        TreeNode pre = null;
        for(int i = list.size()-1; i > 0 ; i--) {
            root = list.get(i);

            // 右子树
            root.right = pre;
            root.left = null;

            pre = root;
        }

        return root;
    }

    /**
     * pre-order 遍历
     * @param treeNode 节点
     * @param list 数组
     */
    private void preorder(TreeNode treeNode, List<TreeNode> list) {
        if(treeNode == null) {
            return;
        }

        // 加入节点本身，减少对象的构建.
        list.add(treeNode);

        preorder(treeNode.left, list);
        preorder(treeNode.right, list);
    }

}
