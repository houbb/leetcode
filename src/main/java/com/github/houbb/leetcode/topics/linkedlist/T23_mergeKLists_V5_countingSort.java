package com.github.houbb.leetcode.topics.linkedlist;

public class T23_mergeKLists_V5_countingSort {

    private final int[] array = new int[20001];
    // 额外空间
    public ListNode mergeKLists(ListNode[] lists) {
        // 排序
        if (lists == null || lists.length == 0) return null;

        // 伟大的计数排序 10^-4~10^4
        int[] nums = array;
        int min = 20002;
        int max = -1;
        for(ListNode listNode : lists) {
            while (listNode != null) {
                int ix = listNode.val + 10000; // 至少为0
                nums[ix]++;
                listNode = listNode.next;

                min = Math.min(ix, min);
                max = Math.max(ix, max);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        // 输出
        for(int i = min; i < max; i++) {
            int count = nums[i];
            int val = i - 10000;
            while (count > 0) {
                ListNode newNode = new ListNode(val);
                cur.next = newNode;
                cur = newNode;
                count--;
            }
        }

        return dummy.next;
    }

}
