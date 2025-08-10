package com.github.houbb.leetcode.topics.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T148_sortList_v2_mergeSortRecursive {

    public ListNode sortList(ListNode head) {
        // 递归终止条件：空链表或只有一个节点
        if (head == null || head.next == null) {
            return head;
        }

        // 1. 找中点，将链表拆成两半
        ListNode mid = getMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;  // 断开左半链表

        // 2. 递归分别排序左右两部分
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 3. 合并两个有序链表
        return mergeTwoLists(left, right);
    }

    // 找链表中点（慢指针法）
    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next; // fast从head.next开始，保证mid偏左
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 合并两个有序链表（调整指针，不新建节点）
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

}
