package com.github.houbb.leetcode.topics.linkedlist;

public class T24_swapPairs_V1_TwoPointerRecursive {

    public static void main(String[] args) {
        T24_swapPairs_V1_TwoPointerRecursive recursive = new T24_swapPairs_V1_TwoPointerRecursive();
        ListNode head = InnerListUtils.buildListNode(new int[]{1,2,3,4});
        head = recursive.swapPairs(head);
        System.out.println(InnerListUtils.getList(head));
    }

    public ListNode swapPairs(ListNode head) {
        // 递归终止条件：没有节点 或 只剩一个节点
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;

        // 递归交换后续链表
        first.next = swapPairs(second.next);

        // 当前两个节点交换
        second.next = first;

        // 返回新头
        return second;
    }


}
