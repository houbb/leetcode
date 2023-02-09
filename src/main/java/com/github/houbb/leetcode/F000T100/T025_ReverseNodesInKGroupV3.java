package com.github.houbb.leetcode.F000T100;

import com.github.houbb.leetcode.ListNode;

/**
 * 优化
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class T025_ReverseNodesInKGroupV3 {

    /**
     * 效果
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Nodes in k-Group.
     * Memory Usage: 39.9 MB, less than 28.23% of Java online submissions for Reverse Nodes in k-Group.
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head), prev = dummy;

        while (true) {
            // 检查剩余节点是否有k个，不足则返回
            ListNode last = prev;
            for (int i = 0; i < k; i++) {
                last = last.next;
                if (last == null) {
                    return dummy.next;
                }
            }

            // 翻转k个节点
            ListNode curr = prev.next, next;
            for (int i = 0; i < k - 1; i++) {
                next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = curr;
        }
    }

}
