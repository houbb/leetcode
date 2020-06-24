package com.github.houbb.leetcode;

/**
 * 要求：只能交换节点，不可直接修改值。
 *
 * @author binbin.hou
 * @since 1.0.0
 */
public class SwapNodesInPairs {

    /**
     *
     * 简单思路：
     *
     * 直接遍历交换即可。
     *
     * 【效果】
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
     * Memory Usage: 37 MB, less than 71.71% of Java online submissions for Swap Nodes in Pairs.
     *
     * @param head 头结点
     * @return 结果
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);

        // 当前移动指针
        ListNode current = dummy;

        //a->b->c
        //b->a->c
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;

            // a->c
            first.next = second.next;
            // b->a
            second.next = first;
            // []->b
            current.next = second;

            // 调整位置
            current = current.next.next;
        }

        // 获取结果
        return dummy.next;
    }

}
