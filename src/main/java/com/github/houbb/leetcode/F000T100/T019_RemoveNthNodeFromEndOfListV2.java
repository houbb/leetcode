package com.github.houbb.leetcode.F000T100;

import com.github.houbb.leetcode.ListNode;

/**
 * <p> project: leetcode-RemoveNthNodeFromEndOfList </p>
 * <p> create on 2020/6/16 21:57 </p>
 *
 * @author binbin.hou
 * @since 2020-6-16 21:57:05
 */
public class T019_RemoveNthNodeFromEndOfListV2 {

    /**
     * 移除倒数的元素
     *
     * @param head 头结点
     * @param n 位数
     * @return 结果
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLen(head);

        // 创建 dummy 节点
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        for (int i = 1; i < len - n + 1; ++i) {
            cur = cur.next;
        }

        // 删除 cur 节点
        cur.next = cur.next.next;

        return dummy.next;
    }

    /**
     * 获取长度
     * @param head 头结点
     * @return 结果
     */
    private int getLen(ListNode head) {
        int i = 0;

        while (head != null) {
            head = head.next;
            i++;
        }

        return i;
    }

}
