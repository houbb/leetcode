package com.github.houbb.leetcode.F000T100;

import com.github.houbb.leetcode.ListNode;

public class T083_RemoveDuplicatesFromSortedListV2 {


    /**
     * 删除重复节点
     * <p>
     * 1. 直接遍历，记录一下 preValue，如果值和 preValue 相同，直接继续 next
     * <p>
     * 这个复杂度为 2*O(n)
     * <p>
     * 有没有办法，一次遍历就可以的呢？
     *
     * @param head 头结点
     * @return 结果
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        // 头结点
        ListNode newHead = head;
        ListNode nextNode = newHead.next;
        while (nextNode != null) {
            // 值重复
            if (newHead.val == nextNode.val) {
                newHead.next = nextNode.next;
            } else {
                newHead = newHead.next;
            }
            nextNode = nextNode.next;
        }

        return head;
    }

}
