package com.github.houbb.leetcode;

import org.junit.Test;

import java.util.List;

/**
 * <p> project: leetcode-RemoveNthNodeFromEndOfListTest </p>
 * <p> create on 2020/6/16 22:12 </p>
 *
 * @author binbin.hou
 * @since v1
 */
public class RemoveNthNodeFromEndOfListTest {

    @Test
    public void basicTest() {
        RemoveNthNodeFromEndOfList list = new RemoveNthNodeFromEndOfList();

        ListNode head = ListNode.buildHead(new int[]{1,2});
        ListNode result = list.removeNthFromEnd(head, 2);
        ListNode.print(result);
    }

    @Test
    public void basic2Test() {
        RemoveNthNodeFromEndOfList list = new RemoveNthNodeFromEndOfList();

        ListNode head = ListNode.buildHead(new int[]{1,2,3,4,5});
        ListNode result = list.removeNthFromEnd(head, 2);
        ListNode.print(result);
    }

}
