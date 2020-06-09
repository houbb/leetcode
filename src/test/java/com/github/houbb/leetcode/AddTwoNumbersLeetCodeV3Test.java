package com.github.houbb.leetcode;

import org.junit.Test;


/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class AddTwoNumbersLeetCodeV3Test {

    // [2,4,3]
    // [5.6.4]
    @Test
    public void runTest() {
        ListNode numOneNext = new ListNode(4, new ListNode(3));
        ListNode numOneNode = new ListNode(2, numOneNext);

        ListNode numTwoNext = new ListNode(6, new ListNode(4));
        ListNode numTwoNode = new ListNode(5, numTwoNext);

        final AddTwoNumbersLeetCodeVersion3 version2 = new AddTwoNumbersLeetCodeVersion3();
        ListNode resultNode = version2.addTwoNumbers(numOneNode, numTwoNode);
        System.out.println(resultNode.getIntegerList());
    }

}
