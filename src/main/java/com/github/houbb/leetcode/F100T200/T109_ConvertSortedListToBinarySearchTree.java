package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.ListNode;
import com.github.houbb.leetcode.component.TreeNode;
import com.github.houbb.leetcode.medium.F100T200.BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T109_ConvertSortedListToBinarySearchTree {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        ListNode head = ListNode.buildHead(nums);

        T109_ConvertSortedListToBinarySearchTree tree = new T109_ConvertSortedListToBinarySearchTree();
        TreeNode treeNode = tree.sortedListToBST(head);

        // 遍历
        BinaryTreeLevelOrderTraversal levelOrderTraversal  = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> lists = levelOrderTraversal.levelOrder(treeNode);
        System.out.println(lists);
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = getIntegers(head);

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
//        int rootIndex = start + (end - start) / 2;
        int rootIndex = (start + end)/2;
        int rootVal = list.get(rootIndex);
        TreeNode treeNode = new TreeNode(rootVal);

        // left
        treeNode.left = generateTree(list, start, rootIndex-1);

        // right
        treeNode.right = generateTree(list, rootIndex+1, end);

        return treeNode;
    }

    private List<Integer> getIntegers(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }



}
