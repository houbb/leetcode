package com.github.houbb.leetcode;

/**
 * 优化
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class ReverseNodesInKGroupOptimize {

    /**
     * 效果
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Nodes in k-Group.
     * Memory Usage: 39.9 MB, less than 28.23% of Java online submissions for Reverse Nodes in k-Group.
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k; i++) {
                end = end.next;

                if(end == null) {
                    return dummy.next;
                }
            }

            // 需要反转的链表
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;

            // 插入反转信息：反转之后，start 实际位于末尾
            pre.next = reverse(start);
            start.next = next;

            // 更新指针位置
            pre = start;
            end = pre;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

}
