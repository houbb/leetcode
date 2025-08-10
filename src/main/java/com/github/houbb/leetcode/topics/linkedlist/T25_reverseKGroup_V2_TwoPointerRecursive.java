package com.github.houbb.leetcode.topics.linkedlist;

public class T25_reverseKGroup_V2_TwoPointerRecursive {

    public static void main(String[] args) {
        T25_reverseKGroup_V2_TwoPointerRecursive extraList = new T25_reverseKGroup_V2_TwoPointerRecursive();
        ListNode head = InnerListUtils.buildListNode(new int[]{1,2,3,4,5});
        head = extraList.reverseKGroup(head, 3);
        System.out.println(InnerListUtils.getList(head));
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        // 1. 找到第 k 个节点
        ListNode kth = getKthNode(head, k);
        if (kth == null) {
            // 不足 k 个，直接返回当前 head
            return head;
        }

        // 2. 记录下一组的头节点
        ListNode nextGroupHead = kth.next;

        // 3. 反转当前区间 [head, kth]
        reverse(head, kth);

        // 4. head 现在是反转后的尾节点，递归反转后续节点
        head.next = reverseKGroup(nextGroupHead, k);

        // 5. kth 是反转后当前段的新头，返回它
        return kth;
    }

    // 反转链表从 start 到 end，包含两端节点
    private void reverse(ListNode start, ListNode end) {
        ListNode prev = end.next;
        ListNode curr = start;
        while (prev != end) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
    }

    // 获取从 node 开始第 k 个节点（包括 node 自身）
    private ListNode getKthNode(ListNode node, int k) {
        while (node != null && k > 1) {
            node = node.next;
            k--;
        }
        return node;
    }

}
