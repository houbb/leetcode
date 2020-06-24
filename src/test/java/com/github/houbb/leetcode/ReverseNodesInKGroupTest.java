package com.github.houbb.leetcode;

import org.junit.Test;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class ReverseNodesInKGroupTest {

    @Test
    public void basicTest() {
        ReverseNodesInKGroup group = new ReverseNodesInKGroup();

        ListNode head = ListNode.buildHead(new int[]{1,2,3,4, 5});

        ListNode result = group.reverseKGroup(head, 2);
        ListNode.print(result);
    }

    @Test
    public void basic2Test() {
        ReverseNodesInKGroup group = new ReverseNodesInKGroup();

        ListNode head = ListNode.buildHead(new int[]{1,2,3,4, 5});

        ListNode result = group.reverseKGroup(head, 3);
        ListNode.print(result);
    }


    @Test
    public void optimizeTest() {
        ReverseNodesInKGroupOptimize group = new ReverseNodesInKGroupOptimize();
        ListNode head = ListNode.buildHead(new int[]{1,2,3,4, 5});

        ListNode result = group.reverseKGroup(head, 3);
        ListNode.print(result);

        System.out.println("---------------");
        ListNode result2 = group.reverseKGroup(head, 2);
        ListNode.print(result2);
    }

}
