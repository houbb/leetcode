package com.github.houbb.leetcode.F000T100;

import com.github.houbb.leetcode.ListNode;

/**
 * 分治算法
 * <p> project: leetcode-MergeKSortedLists </p>
 * <p> create on 2020/6/17 23:17 </p>
 *
 * @author binbin.hou
 * @since 2020-6-17 23:17:53
 */
public class T023_MergeKSortedListsDivideAndConquer {

    /**
     * 简单思路
     *
     *
     * 【效果】
     *
     * Runtime: 106 ms, faster than 14.46% of Java online submissions for Merge k Sorted Lists.
     * Memory Usage: 41 MB, less than 75.98% of Java online submissions for Merge k Sorted Lists.
     *
     * @param lists 列表
     * @return 结果
     */
    public ListNode mergeKLists(ListNode[] lists) {
        final int length = lists.length;
        if(lists.length == 0) {
            return null;
        }

        if(lists.length == 1) {
            return lists[0];
        }

        // 递归获取两个节点
        int mid = (length) / 2;

        ListNode one = mergeKLists(subArray(lists, 0, mid));
        ListNode two = mergeKLists(subArray(lists, mid, length));

        // 合并最后2个节点

        return mergeTwoLists(one, two);
    }

    private ListNode[] subArray(ListNode[] listNodes, int start, int end) {
        int size = end-start;
        ListNode[] result = new ListNode[size];

        int index = 0;
        for(int i = start; i < end; i++) {
            result[index++] = listNodes[i];

        }
        return result;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        // 临时变量
        ListNode newNode = new ListNode(0);

        // 新增的头指针
        ListNode head = newNode;

        // 循环处理
        while (l1 != null && l2 != null) {
            int valOne = l1.val;
            int valTwo = l2.val;

            // 插入小的元素节点
            if(valOne <= valTwo) {
                newNode.next = l1;
                l1 = l1.next;
            } else {
                newNode.next = l2;
                l2 = l2.next;
            }

            // 变换 newNode
            newNode = newNode.next;
        }

        // 如果长度不一样
        if(l1 != null) {
            newNode.next = l1;
        }
        if(l2 != null) {
            newNode.next = l2;
        }

        return head.next;
    }

}
