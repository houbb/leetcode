package com.github.houbb.leetcode.topics.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T23_mergeKLists_V2_TwoAndTwo {

    // 额外空间
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }

        // 两两合并
        ListNode left = lists[0];

        for(int i = 1; i < lists.length; i++) {
            left = mergeTwoLists(left, lists[i]);
        }

        return left;
    }

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

            //current 向前走，指向刚接上的节点
            current = current.next;
        }

        // 连接剩余的非空链表节点
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }



}
