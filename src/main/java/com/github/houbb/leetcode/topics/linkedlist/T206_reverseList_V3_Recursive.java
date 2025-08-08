package com.github.houbb.leetcode.topics.linkedlist;

public class T206_reverseList_V3_Recursive {


    public ListNode reverseList(ListNode head) {
        return recursive(null, head);
    }

    private ListNode recursive(ListNode pre, ListNode cur) {
        if(cur == null) {
            return pre;
        }

        ListNode temp = cur.next;
        cur.next = pre;

        // 递归
        return recursive(cur, temp);
    }

}
