package com.github.houbb.leetcode.topics.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class T142_detectCycle_V1_Hash {


    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            if(set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

}
