package com.github.houbb.leetcode.topics.linkedlist;

import java.util.List;

public class T160_getIntersectionNode_V3_TwoPointer {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
        return pA;
    }


}
