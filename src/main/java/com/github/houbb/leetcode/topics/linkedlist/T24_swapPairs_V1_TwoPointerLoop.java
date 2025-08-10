package com.github.houbb.leetcode.topics.linkedlist;

public class T24_swapPairs_V1_TwoPointerLoop {

    public static void main(String[] args) {
        ListNode head = InnerListUtils.buildListNode(new int[]{1,2,3,4});
        head = swapPairs(head);
        System.out.println(InnerListUtils.getList(head));
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;

            // 执行交换
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // 移动 prev 到已处理块的尾（first）
            prev = first;
        }

        return dummy.next;
    }



}
