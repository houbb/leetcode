package com.github.houbb.leetcode.topics.linkedlist;

public class T21_mergeTwoLists_V2_Loop {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 创建一个虚拟头节点，方便操作
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // 当两个链表都不为空时，比较当前节点值，连接较小节点
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // 连接剩余的非空链表节点
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        // 返回合并后链表的头节点
        return dummy.next;
    }

}
