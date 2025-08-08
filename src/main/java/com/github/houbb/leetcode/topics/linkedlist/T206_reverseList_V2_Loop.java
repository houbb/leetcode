package com.github.houbb.leetcode.topics.linkedlist;

public class T206_reverseList_V2_Loop {


    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;

            cur.next = pre;

            pre = cur;
            cur = temp;
        }
        return pre;
    }

}
