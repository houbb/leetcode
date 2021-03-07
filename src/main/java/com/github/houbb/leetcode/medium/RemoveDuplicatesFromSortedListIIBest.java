package com.github.houbb.leetcode.medium;


/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class RemoveDuplicatesFromSortedListIIBest {

    /**
     * 使用双指针
     *
     * 这是一种很有用的思想。
     *
     * 妙不可言！！！！！！！！！！！！！！
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        //use two pointers, slow - track the node before the dup nodes,
        // fast - to find the last node of dups.
        ListNode dummy = new ListNode(0), fast = head, slow = dummy;
        slow.next = fast;
        while(fast != null) {
            //while loop to find the last node of the dups.
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }

            if (slow.next != fast) { //duplicates detected.
                slow.next = fast.next; //remove the dups.
                fast = slow.next;     //reposition the fast pointer.
            } else { //no dup, move down both pointer.
                slow = slow.next;
                fast = fast.next;
            }

        }
        return dummy.next;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}
