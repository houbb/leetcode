package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.component.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 中序 + 后序
 * @author binbin.hou
 * @since 1.0.0
 */
public class T105_ConstructBinaryTreeFromInorderAndPostOrderTraversal {

    /**
     * Runtime: 1 ms, faster than 96.64% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
     * Memory Usage: 39.2 MB, less than 47.18% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int limit = inorder.length - 1;

        // 构建 inOrderMap
        Map<Integer, Integer> inorderMap = new HashMap<>(inorder.length);
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTree(postorder, 0, limit, 0, limit, inorderMap);
    }

    /**
     * 构建一棵树
     * @param postorder 后序
     * @param postorderLeft 后序左边
     * @param postorderRight 后序右边
     * @param inorderLeft 中序左边
     * @param inorderRight 中序右边
     * @param inorderMap map
     * @return 结果
     */
    private TreeNode buildTree(int[] postorder,
                               int postorderLeft, int postorderRight,
                               int inorderLeft, int inorderRight,
                               Map<Integer, Integer> inorderMap) {
        if (postorderLeft > postorderRight || inorderLeft > inorderRight) {
            return null;
        }

        // 获取根节点（后序遍历的最后一个元素）
        int rootVal = postorder[postorderRight];
        // 获取根节点在中序遍历的位置
        int rootIndex = inorderMap.get(rootVal);
        // 左子树的个数
        int leftSize = rootIndex - inorderLeft;

        // 根节点
        TreeNode root = new TreeNode();
        root.val = rootVal;

        // 左子树
        // 后序 left, left+leftSize-1   对应：   中序 left, rootIndex-1
        root.left = buildTree(postorder, postorderLeft, postorderLeft +leftSize-1,
                inorderLeft, rootIndex-1, inorderMap);

        // 右子树
        // 后续 left+leftSize, right-1    对应 中序 rootIndex+1, right
        root.right = buildTree(postorder, postorderLeft +leftSize, postorderRight-1,
                rootIndex+1, inorderRight, inorderMap);

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[] {9,3,15,20,7};
        int[] postorder = new int[] {9,15,7,20,3};


        T105_ConstructBinaryTreeFromInorderAndPostOrderTraversal tree = new T105_ConstructBinaryTreeFromInorderAndPostOrderTraversal();
        tree.buildTree(inorder, postorder);
    }

}
