package com.github.houbb.leetcode.medium.F100T200;

import com.github.houbb.leetcode.ListNode;
import com.github.houbb.leetcode.component.TreeNode;
import com.github.houbb.leetcode.medium.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 专门为测试而生
 * @author binbin.hou
 * @since 1.0.0
 */
public class ConvertSortedListToBinarySearchTreeForTest {

    public static void main(String[] args) {
        ConvertSortedListToBinarySearchTreeForTest tree = new ConvertSortedListToBinarySearchTreeForTest();

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        TreeNode treeNode = tree.sortedListToBST(list);

        // 前序递归
        BinaryTreePostorderTraversalLoopDebug traversal = new BinaryTreePostorderTraversalLoopDebug();
        List<Integer> results = traversal.postorderTraversal(treeNode);
        System.out.println(results);
    }

    public TreeNode sortedListToBST(List<Integer> list) {
        if(list.size() <= 0) {
            return null;
        }

        return generateTree(list, 0, list.size()-1);
    }

    private TreeNode generateTree(List<Integer> list, int start, int end) {
        //此时没有数字，将 null 加入结果中
        if(start > end) {
            return null;
        }

        // root 节点
        // 1 2 3 4 5
        int rootIndex = (start + end)/2;
        int rootVal = list.get(rootIndex);
        TreeNode treeNode = new TreeNode(rootVal);

        // left
        treeNode.left = generateTree(list, start, rootIndex-1);

        // right
        treeNode.right = generateTree(list, rootIndex+1, end);

        return treeNode;
    }

}
