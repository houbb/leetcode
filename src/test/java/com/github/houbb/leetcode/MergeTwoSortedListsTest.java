package com.github.houbb.leetcode;

import org.junit.Test;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class MergeTwoSortedListsTest {

    /**
     * Input: 1->2->4, 1->3->4
     * Output: 1->1->2->3->4->4
     */
    @Test
    public void basicTest() {
        MergeTwoSortedLists lists = new MergeTwoSortedLists();

        ListNode one = ListNode.buildHead(new int[]{1,2,4});
        ListNode two = ListNode.buildHead(new int[]{1,3,4});

        ListNode result = lists.mergeTwoLists(one, two);
        ListNode.print(result);
    }

    /**
     * Input: 1->2->4, 1->3->4
     * Output: 1->1->2->3->4->4
     */
    @Test
    public void loopTest() {
        MergeTwoSortedListsBest lists = new MergeTwoSortedListsBest();

        ListNode one = ListNode.buildHead(new int[]{1,2,4});
        ListNode two = ListNode.buildHead(new int[]{1,3,4});

        ListNode result = lists.mergeTwoLists(one, two);
        ListNode.print(result);
    }

}
