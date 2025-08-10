package com.github.houbb.leetcode.topics.linkedlist;

import java.util.PriorityQueue;

public class T23_mergeKLists_V4_PriorityQueue {

    // 额外空间
    public ListNode mergeKLists(ListNode[] lists) {
        // 排序
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }

}
