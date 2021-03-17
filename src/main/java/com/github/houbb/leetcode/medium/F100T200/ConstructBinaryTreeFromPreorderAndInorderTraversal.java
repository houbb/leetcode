package com.github.houbb.leetcode.medium.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    /**
     * 解题思路：
     *
     * （1）定位 root
     * （2）递归构建 left right
     * @param preorder 前序
     * @param inorder 中序
     * @return 结果
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int limit = preorder.length - 1;

        // 构建 inOrderMap
        Map<Integer, Integer> inorderMap = new HashMap<>(inorder.length);
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, limit, 0, limit,
                inorderMap);
    }

    /**
     * 构建一棵树
     * @param preorder 前序
     * @param inorder 中序
     * @param preorderLeft 前序左边
     * @param preorderRight 前序右边
     * @param inorderLeft 中序左边
     * @param inorderRight 中序右边
     * @param inorderMap map
     * @return 结果
     */
    private TreeNode buildTree(int[] preorder, int[] inorder,
                               int preorderLeft, int preorderRight,
                               int inorderLeft, int inorderRight,
                               Map<Integer, Integer> inorderMap) {
        if(preorderLeft > preorderRight) {
            return null;
        }

        // 获取根节点（前序遍历的第一个元素）
        int rootVal = preorder[preorderLeft];
        // 获取根节点在中序遍历的位置
        int rootIndex = inorderMap.get(rootVal);
        // 左子树的个数
        int leftSize = rootIndex - inorderLeft;

        // 根节点
        TreeNode root = new TreeNode();
        root.val = rootVal;

        // 左子树
        // (前序左边界+1, 前序左边界+左子树的个数) ==== 对应了=== 中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = buildTree(preorder, inorder, preorderLeft+1, preorderLeft+leftSize,
                inorderLeft, rootIndex-1, inorderMap);

        // 右子树
        // (前序左边界+左子树的个数+1, 前序右边界) ==== 对应了=== 中序遍历中「根节点定位+1, 右边界」的元素
        root.right = buildTree(preorder, inorder, preorderLeft+leftSize+1, preorderRight,
                rootIndex+1, inorderRight, inorderMap);

        return root;
    }

}
