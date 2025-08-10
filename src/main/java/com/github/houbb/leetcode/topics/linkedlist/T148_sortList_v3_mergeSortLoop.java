package com.github.houbb.leetcode.topics.linkedlist;

public class T148_sortList_v3_mergeSortLoop {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 先统计链表长度
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        ListNode dummy = new ListNode(0, head);
        // 从子链表长度为1开始，逐步翻倍
        for (int size = 1; size < length; size <<= 1) {
            ListNode cur = dummy.next;
            ListNode tail = dummy;

            while (cur != null) {
                // 左半部分
                ListNode left = cur;
                // 右半部分
                ListNode right = split(left, size);
                // 下一次开始的节点
                cur = split(right, size);

                // 合并左右两个有序链表
                ListNode[] merged = merge(left, right);
                tail.next = merged[0];
                tail = merged[1];
            }
        }

        return dummy.next;
    }

    // 将链表从 head 开始截断，截断后返回剩余链表的头节点
    // 截断长度为 size 的子链表，尾节点.next 置为 null
    private ListNode split(ListNode head, int size) {
        if (head == null) return null;
        for (int i = 1; head.next != null && i < size; i++) {
            head = head.next;
        }
        ListNode next = head.next;
        head.next = null;
        return next;
    }

    // 合并两个有序链表，返回合并后的头和尾节点
    private ListNode[] merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null) ? l1 : l2;

        // 找到合并后的尾节点
        while (cur.next != null) {
            cur = cur.next;
        }

        return new ListNode[] {dummy.next, cur};
    }


}
