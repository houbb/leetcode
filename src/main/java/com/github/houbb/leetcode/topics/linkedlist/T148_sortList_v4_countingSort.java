package com.github.houbb.leetcode.topics.linkedlist;

public class T148_sortList_v4_countingSort {

    public ListNode sortList(ListNode head) {
        if (head == null) return null;

        // 找到最小值和最大值
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        ListNode cur = head;
        while (cur != null) {
            min = Math.min(min, cur.val);
            max = Math.max(max, cur.val);
            cur = cur.next;
        }

        // 统计计数
        int[] count = new int[max - min + 1];
        cur = head;
        while (cur != null) {
            count[cur.val - min]++;
            cur = cur.next;
        }

        // 根据计数重写链表值
        cur = head;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                cur.val = i + min;
                cur = cur.next;
                count[i]--;
            }
        }

        return head;
    }



}
