package com.github.houbb.leetcode.topics.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class T141_hasCycle_V1_Hash {


    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            if(set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

}
