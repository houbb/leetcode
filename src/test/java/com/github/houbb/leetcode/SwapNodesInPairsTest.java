package com.github.houbb.leetcode;

import org.junit.Test;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class SwapNodesInPairsTest {

    @Test
    public void basicTest() {
        ListNode head = ListNode.buildHead(new int[]{1,2,3,4});

        ListNode result = new SwapNodesInPairs().swapPairs(head);
        ListNode.print(result);
    }

}
