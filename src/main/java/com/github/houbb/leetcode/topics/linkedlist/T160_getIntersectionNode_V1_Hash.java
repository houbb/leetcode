package com.github.houbb.leetcode.topics.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class T160_getIntersectionNode_V1_Hash {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        // 找到 b 中重复的点
        while (headB != null) {
            if(set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

}
