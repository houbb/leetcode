package com.github.houbb.leetcode.topics.binaryTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T105_buildTree_V1 {

    public static void main(String[] args) {
        T105_buildTree_V1 buildTreeV1 = new T105_buildTree_V1();
        buildTreeV1.buildTree(new int[]{3, 9, 20, 15, 7},
                new int[]{9, 3, 15, 20, 7});
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 用 Hash 构建一个中序的位置  其实只是用到了中序的位置
        Map<Integer, Integer> ixMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            ixMap.put(inorder[i], i);
        }

        return recursive(preorder, ixMap,
                0, preorder.length-1, 0, inorder.length-1);
    }

    /**
     *
     * @param preorder 前序
     * @param ixMap 中序
     * @param pStart 前序开始
     * @param pEnd 前序结束
     * @param iStart 中序开始
     * @param iEnd 中序结束
     * @return 节点
     */
    private TreeNode recursive(int[] preorder,
                               Map<Integer, Integer> ixMap,
                               int pStart, int pEnd,
                               int iStart, int iEnd) {
        // 终止条件
        if(pStart > pEnd || iStart > iEnd) {
            return null;
        }

        // 前序的开始元素就是根
        int rootNum = preorder[pStart];
        TreeNode rootNode = new TreeNode(rootNum);

        // 二分找到位置，可以用hash加速（左边对应的个数也就是这么多？）
        // 二分不一定对
        int iRootIndex = ixMap.get(rootNum);
        // 左子树节点个数
        int leftNum = iRootIndex - iStart;

        // 前序：根 | 左子树 | 右子树
        // 中序：左子树 | 根 | 右子树
        TreeNode leftNode = recursive(preorder, ixMap,
                pStart+1, pStart+ leftNum, iStart, iRootIndex -1);

        TreeNode rightNode = recursive(preorder, ixMap,
                pStart+ leftNum +1, pEnd, iRootIndex +1, iEnd);

        // 设置左右节点
        rootNode.left = leftNode;
        rootNode.right = rightNode;

        return rootNode;
    }

}
