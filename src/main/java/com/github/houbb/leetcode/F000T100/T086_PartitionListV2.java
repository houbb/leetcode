package com.github.houbb.leetcode.F000T100;

import com.github.houbb.leetcode.ListNode;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T086_PartitionListV2 {

    public static void main(String[] args) {
        int[] nums = {1,4,3,2,5,2};
        ListNode listNode = ListNode.buildHead(nums);

        T086_PartitionListV2 better = new T086_PartitionListV2();
        ListNode result = better.partition(listNode, 3);

        ListNode.print(result);
    }
    /**
     * 【優化思路】
     *
     * 我们之所以慢，是因为没有利用好已有的节点。
     *
     * 我们将 list 改成两个节点链表即可。
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }

        // 根据 x 拆分为2
        ListNode lowerDummy = new ListNode(-1);
        ListNode lower = lowerDummy;
        ListNode highDummy = new ListNode(-1);
        ListNode high = highDummy;

        while (head != null) {
            int val  = head.val;
            if(val < x) {
                lower.next = head;
                lower = head;
            } else {
                high.next = head;
                high = head;
            }

            head = head.next;
        }

        // 将低的结尾=》高的开头
        lower.next = highDummy.next;
        high.next = null;

        // 重新构建 head
        return lowerDummy.next;
    }

}
