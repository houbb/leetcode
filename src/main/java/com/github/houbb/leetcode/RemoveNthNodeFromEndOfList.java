package com.github.houbb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> project: leetcode-RemoveNthNodeFromEndOfList </p>
 * <p> create on 2020/6/16 21:57 </p>
 *
 * @author binbin.hou
 * @since 2020-6-16 21:57:05
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * 移除倒数的元素
     *
     * 简单思路：
     *
     * 给定的元素只能从前往后遍历？
     *
     *
     * 【性能】
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
     * Memory Usage: 37.9 MB, less than 30.88% of Java online submissions for Remove Nth Node From End of List.
     *
     *
     *
     * 个人认为这种接法是由于题目中的给出的2种解法的。
     *
     * leetcode 的2个解法实际上都是：length + (length-n) 次移动，这是不合理的。
     *
     * 如果 length=100，想移除倒数第一个元素，那么是遍历2次。
     *
     * 个人借助数组，则只需要 length+O(1) 的查找。
     *
     *
     * 思路2：
     * 构建双向链表，添加一个尾巴节点。
     *
     * @param head 头结点
     * @param n 位数
     * @return 结果
     * @since v1
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = buildNodeList(head);

        if(list.size() <= 1) {
            return null;
        }

        // 考虑头尾的问题
        // 如果是移除头结点
        if(n == list.size()) {
            // 第二个元素当做头结点
            return list.get(1);
        }

        // 删除固定的节点
        ListNode pre = list.get(list.size()-n-1);
        pre.next = n >= list.size() ? null : pre.next.next;
        return list.get(0);
    }

    /**
     * 构建一个完整的数组
     * @param head 头结点
     * @return 结果
     * @since v1
     */
    private List<ListNode> buildNodeList(ListNode head) {
        List<ListNode> list = new ArrayList<>();

        list.add(head);
        while (head.next != null) {
            ListNode next = head.next;
            list.add(next);
            head = head.next;
        }

        return list;
    }

}
