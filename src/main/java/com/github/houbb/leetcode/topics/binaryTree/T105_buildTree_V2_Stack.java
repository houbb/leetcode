package com.github.houbb.leetcode.topics.binaryTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class T105_buildTree_V2_Stack {

    public static void main(String[] args) {
        T105_buildTree_V2_Stack buildTreeV1 = new T105_buildTree_V2_Stack();
        buildTreeV1.buildTree(new int[]{3, 9, 20, 15, 7},
                new int[]{9, 3, 15, 20, 7});
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;

        Stack<TreeNode> stack = new Stack<>();
        int inorderIndex = 0;

        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        for(int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();

            if(node.val != inorder[inorderIndex]) {
                // 左子节点
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                // 栈顶节点值 == 当前中序节点，说明左子树完成
                while(!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                // 右子节点
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }


}
