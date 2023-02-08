package com.github.houbb.leetcode.F000T100;

import com.github.houbb.leetcode.ListNode;

/**
 * 合并 k 个有序的链表
 * <p>
 * 两个两个合并，一直持续到最后。
 * <p> project: leetcode-MergeKSortedLists </p>
 * <p> create on 2020/6/17 23:17 </p>
 *
 * @author binbin.hou
 * @since 2020-6-17 23:17:53
 */
public class T023_MergeKSortedListsV2 {

    /**
     *
     * 思路：
     *
     * 1. 从2边开始头尾相加变成一个新的节点，不断重复。
     *
     * 【效果】
     *
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Merge k Sorted Lists.
     * Memory Usage: 41.5 MB, less than 35.98% of Java online submissions for Merge k Sorted Lists.
     *
     * @param lists 列表
     * @return 结果
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        int i = 0;
        int j = lists.length - 1;

        while (j > 0) {
            // ?
            i = 0;

            while (i < j) {
                lists[i] = mergeTwoLists(lists[i], lists[j]);
                i++;
                j--;
            }
        }

        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
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
            if (valOne <= valTwo) {
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
        if (l1 != null) {
            newNode.next = l1;
        }
        if (l2 != null) {
            newNode.next = l2;
        }

        return head.next;
    }

}
