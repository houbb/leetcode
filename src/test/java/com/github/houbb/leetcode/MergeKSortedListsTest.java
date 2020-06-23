package com.github.houbb.leetcode;

import org.junit.Test;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class MergeKSortedListsTest {

    /**
     * Input: 1->2->4, 1->3->4
     * Output: 1->1->2->3->4->4
     */
    @Test
    public void basicTest() {
        MergeKSortedListsPriorityQueue lists = new MergeKSortedListsPriorityQueue();

        ListNode one = ListNode.buildHead(new int[]{1,2,4});
        ListNode two = ListNode.buildHead(new int[]{1,3,4});

        ListNode result = lists.mergeKLists(new ListNode[]{one, two});
        ListNode.print(result);
    }

    /**
     * Input: 1->2->4, 1->3->4
     * Output: 1->1->2->3->4->4
     */
    @Test
    public void loopTest() {
        MergeTwoSortedLists2 lists = new MergeTwoSortedLists2();

        ListNode one = ListNode.buildHead(new int[]{1,2,4});
        ListNode two = ListNode.buildHead(new int[]{1,3,4});

        ListNode result = lists.mergeTwoLists(one, two);
        ListNode.print(result);
    }

}