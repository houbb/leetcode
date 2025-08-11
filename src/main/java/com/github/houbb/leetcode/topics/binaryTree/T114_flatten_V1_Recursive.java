package com.github.houbb.leetcode.topics.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class T114_flatten_V1_Recursive {

    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }

        List<TreeNode> preOrderList = new ArrayList<>();
        preOrder(root, preOrderList);

        // 递归构建子树
        // 用迭代试一下
        TreeNode cur = root;
        for(int i = 1; i < preOrderList.size(); i++) {
            cur.right = preOrderList.get(i);
            cur.left = null;
            cur = preOrderList.get(i);
        }
    }



    private void preOrder(TreeNode root, List<TreeNode> preOrderList) {
        if(root == null) {
            return;
        }

        // root
        preOrderList.add(root);
        preOrder(root.left, preOrderList);
        preOrder(root.right, preOrderList);
    }

}
