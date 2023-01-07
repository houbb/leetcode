package com.github.houbb.leetcode.util;

import com.github.houbb.leetcode.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author d
 * @since 1.0.0
 */
public class ListNodes {

    public static ListNode buildHead(int[] nums) {
        ListNode head = new ListNode(nums[0]);

        ListNode temp = head;
        for(int i = 1; i < nums.length; i++) {
            temp.next = new ListNode(nums[i]);
            temp = temp.next;
        }

        return head;
    }

    /**
     * 获取整数的链表
     * @return 结果
     * @since 1.0.0
     */
    public static List<Integer> getIntegerList(ListNode listNode) {
        // 使用 linkedList，避免扩容
        List<Integer> resultList = new LinkedList<>();
        while (listNode != null) {
            int value = listNode.val;
            resultList.add(value);
            listNode = listNode.next;
        }
        return resultList;
    }

    public static void showList(ListNode listNode) {
        System.out.println(getIntegerList(listNode));
    }

}
