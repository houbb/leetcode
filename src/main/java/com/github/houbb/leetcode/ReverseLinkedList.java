package com.github.houbb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class ReverseLinkedList {

    /**
     * 列表反转的思路
     * @param head 头结点
     * @return 结果
     */
    public ListNode reverseList(ListNode head) {
        List<Integer> integers = getIntegerList(head);

        return reverseBuildHead(integers);
    }

    /**
     * 获取整数的链表
     * @return 结果
     * @since 1.0.0
     */
    private static List<Integer> getIntegerList(ListNode listNode) {
        // 使用 linkedList，避免扩容
        List<Integer> resultList = new LinkedList<>();
        while (listNode != null) {
            int value = listNode.val;
            resultList.add(value);
            listNode = listNode.next;
        }
        return resultList;
    }

    /**
     * 构建头结点
     * @return 结果
     * @since 0.0.1
     */
    private static ListNode reverseBuildHead(List<Integer> integers) {
        if(integers.size() <= 0) {
            return null;
        }

        ListNode head = new ListNode(integers.get(integers.size()-1));

        ListNode temp = head;
        for(int i = integers.size()-2; i >= 0; i--) {
            temp.next = new ListNode(integers.get(i));
            temp = temp.next;
        }

        return head;
    }


}
