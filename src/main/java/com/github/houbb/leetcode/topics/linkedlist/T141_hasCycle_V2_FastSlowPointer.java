package com.github.houbb.leetcode.topics.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class T141_hasCycle_V2_FastSlowPointer {


    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null
                && fast.next != null
            && slow != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

}
