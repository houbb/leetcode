package com.github.houbb.leetcode.F200T300;

import com.github.houbb.leetcode.ListNode;

public class T203_RemoveLinkedListElements {

    /**
     * 移除
     *
     * 1. 用一个节点保存头节点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = head;
        ListNode prev = dummy;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = prev.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

}
