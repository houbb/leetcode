package com.github.houbb.leetcode;

import org.junit.Test;
import com.github.houbb.leetcode.AddTwoNumbers.ListNode;
/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class AddTwoNumbersTest {

    @Test
    public void runTest() {
        ListNode numOneNext = new ListNode(4, new ListNode(3));
        ListNode numOneNode = new ListNode(2, numOneNext);

        ListNode numTwoNext = new ListNode(6, new ListNode(4));
        ListNode numTwoNode = new ListNode(5, numTwoNext);

        final AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode resultNode = addTwoNumbers.addTwoNumbers(numOneNode, numTwoNode);
        System.out.println(addTwoNumbers.getIntegerList(resultNode));
    }

}
