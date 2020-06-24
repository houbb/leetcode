package com.github.houbb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    /**
     * 获取整数的链表
     * @return 结果
     * @since 1.0.0
     */
    public List<Integer> getIntegerList() {
        // 使用 linkedList，避免扩容
        List<Integer> resultList = new LinkedList<>();
        ListNode oneNode = this;
        while (oneNode != null) {
            int value = oneNode.val;
            resultList.add(value);
            oneNode = oneNode.next;
        }
        return resultList;
    }

    /**
     * 构建头结点
     * @return 结果
     * @since 0.0.1
     */
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
     * 构建头结点
     * @return 结果
     * @since 0.0.1
     */
    public static ListNode buildHead(List<Integer> integers) {
        ListNode head = new ListNode(integers.get(0));

        ListNode temp = head;
        for(int i = 1; i < integers.size(); i++) {
            temp.next = new ListNode(integers.get(i));
            temp = temp.next;
        }

        return head;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val+"->");
            head = head.next;
        }
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
