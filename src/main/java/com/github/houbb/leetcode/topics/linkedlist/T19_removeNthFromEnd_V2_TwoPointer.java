package com.github.houbb.leetcode.topics.linkedlist;

public class T19_removeNthFromEnd_V2_TwoPointer {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建 dummy 节点
        ListNode dummy = new ListNode(0, head);
        // 避免空指针
        ListNode cur = dummy;
        ListNode pRight = head;
        for (int i = 0; i < n; i++) {
            pRight = pRight.next;
        }

        while (pRight != null) {
            pRight = pRight.next;
            cur = cur.next;
        }

        // 移除 cur
        cur.next = cur.next.next;

        return dummy.next;
    }

}
