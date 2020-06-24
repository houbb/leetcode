package com.github.houbb.leetcode;

/**
 * 优化
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class ReverseNodesInKGroupOptimize {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        return reverseInGroup(head, k);
    }

    private ListNode reverseInGroup(ListNode head, int k) {
        if (!ifSizeGreaterThanK(head, k)) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        int count = 0;
        ListNode next = null;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if (next != null) {
            head.next = reverseInGroup(next, k);
        }

        return prev;
    }

    private boolean ifSizeGreaterThanK(ListNode head, int k) {
        int count = 0;
        while (head != null) {
            count++;
            if (count >= k) {
                return true;
            }
            head = head.next;
        }

        return false;
    }

}
