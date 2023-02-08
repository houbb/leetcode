package com.github.houbb.leetcode.F000T100;

import com.github.houbb.leetcode.ListNode;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T092_ReverseLinkedListII {

    /**
     * 列表反转的思路
     *
     * 1->2->3->4->5
     *
     * 如果反轉 [2,4]
     *
     * 1->
     * （結尾）2<-3<-4（開始）
     * ->5
     *
     * 可以拆分爲3個部分：
     *
     * 正向_S + 反向 + 正向_E
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
     * Memory Usage: 36.9 MB, less than 28.17% of Java online submissions for Reverse Linked List II.
     *
     * @param head 头结点
     * @return 结果
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 正向開始
        ListNode headStart = head;
        ListNode headEnd = head;
        ListNode reverseEnd = head;
        ListNode reverseStart = head;

        int i = 0;
        ListNode newHead = null;
        while (head != null) {
            i++;

            // 等於 left-1 的時候，保留 end
            if(i == left-1) {
                headEnd = head;
            }

            ListNode next = head.next;
            // 執行反轉
            if(left <= i && right >= i) {
                // 反轉的結尾元素
                if(left == i) {
                    reverseEnd = head;
                }
                // 反轉的開頭。
                if(right == i) {
                    reverseStart = head;
                }

                // 当前节点指向上一个节点
                head.next = newHead;
                // 上一个节点更新为当前节点
                newHead = head;
            }

            // 終止循環
            if(i > right) {
                break;
            }

            // 当前节点继续向后
            head = next;
        }

        // 此時的 head 就是結尾。
        // 拼接結果
        ListNode headResult = null;
        // 如果 left > 1
        if(left > 1) {
            // 正向開始
            headResult = headStart;
            headEnd.next = reverseStart;
        } else {
            headResult = reverseStart;
        }
        reverseEnd.next = head;

        return headResult;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.buildHead(new int[]{1,2,3,4,5});

        ListNode result = new T092_ReverseLinkedListII().reverseBetween(listNode, 2, 4);

        ListNode.print(result);
    }

}
