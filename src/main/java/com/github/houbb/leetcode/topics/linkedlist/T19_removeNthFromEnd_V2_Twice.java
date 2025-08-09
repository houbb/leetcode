package com.github.houbb.leetcode.topics.linkedlist;

public class T19_removeNthFromEnd_V2_Twice {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLength(head);

        // 创建 dummy 节点
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        for (int i = 0; i < len-n; i++) {
            cur = cur.next;
        }

        // 移除 cur
        cur.next = cur.next.next;

        return dummy.next;
    }

    private int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }



}
