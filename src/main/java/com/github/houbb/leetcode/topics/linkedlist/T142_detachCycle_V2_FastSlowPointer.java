package com.github.houbb.leetcode.topics.linkedlist;

public class T142_detachCycle_V2_FastSlowPointer {


    public ListNode detectCycle(ListNode head)  {
        ListNode fast = head;
        ListNode slow = head;

        boolean hasMeetFlag = false;
        while (fast != null
                && fast.next != null
            && slow != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                hasMeetFlag = true;
                break;
            }
        }

        // fast 来到开头
        if(hasMeetFlag) {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }

            // 再次相遇，就是相遇的点
            return fast;
        }

        return null;
    }

}
