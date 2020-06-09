package com.github.houbb.leetcode;

import com.github.houbb.leetcode.AddTwoNumbersLeetCodeVersion2.ListNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class AddTwoNumbersLeetCodeV2Test {

    // [2,4,3]
    // [5.6.4]
    @Test
    public void runTest() {
        ListNode numOneNext = new ListNode(4, new ListNode(3));
        ListNode numOneNode = new ListNode(2, numOneNext);

        ListNode numTwoNext = new ListNode(6, new ListNode(4));
        ListNode numTwoNode = new ListNode(5, numTwoNext);

        final AddTwoNumbersLeetCodeVersion2 version2 = new AddTwoNumbersLeetCodeVersion2();
        ListNode resultNode = version2.addTwoNumbers(numOneNode, numTwoNode);
        System.out.println(getIntegerList(resultNode));
    }

    /**
     * 获取整数的链表
     * @param listNode 节点
     * @return 结果
     * @since 1.0.0
     */
    private static List<Integer> getIntegerList(ListNode listNode) {
        // 使用 linkedList，避免扩容
        List<Integer> resultList = new LinkedList<>();
        ListNode oneNode = listNode;
        while (oneNode != null) {
            int value = oneNode.val;
            resultList.add(value);
            oneNode = oneNode.next;
        }
        return resultList;
    }
}
