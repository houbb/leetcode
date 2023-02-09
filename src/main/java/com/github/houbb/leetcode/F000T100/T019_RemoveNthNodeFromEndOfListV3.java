package com.github.houbb.leetcode.F000T100;

import com.github.houbb.leetcode.ListNode;

/**
 * <p> project: leetcode-RemoveNthNodeFromEndOfList </p>
 * <p> create on 2020/6/16 21:57 </p>
 *
 * @author binbin.hou
 * @since 2020-6-16 21:57:05
 */
public class T019_RemoveNthNodeFromEndOfListV3 {

    /**
     * 移除倒数的元素
     *
     * @param head 头结点
     * @param n 位数
     * @return 结果
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建 dummy 节点
        ListNode dummy = new ListNode(0, head);

        // i 先走 n 步
        ListNode i = head;
        ListNode j = dummy;
        for(int k = 0; k < n; k++) {
            i = i.next;
        }

        // 二者同时开始走
        while (i != null) {
            j = j.next;
            i = i.next;
        }

        // 删除当前节点
        j.next = j.next.next;

        // 返回
        return dummy.next;
    }

}
