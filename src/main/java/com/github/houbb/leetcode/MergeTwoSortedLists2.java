package com.github.houbb.leetcode;

/**
 * 合并两个有序的数组
 * @author binbin.hou
 * @since 1.0.0
 * @date 2020-6-17 11:26:40
 * @since v2
 */
public class MergeTwoSortedLists2 {

    /**
     * 合并2个有序的数组
     *
     * 【思路】
     * 直接循环遍历，从左到右一遍即可。
     *
     * 优点：充分利用了有序性。
     *
     * 【效果】
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
     * Memory Usage: 38.8 MB, less than 88.76% of Java online submissions for Merge Two Sorted Lists.
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 结果
     * @since v1
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        // 临时变量
        ListNode newNode = new ListNode(0);

        // 新增的头指针
        ListNode head = newNode;

        // 循环处理
        while (l1 != null && l2 != null) {
            int valOne = l1.val;
            int valTwo = l2.val;

            // 插入小的元素节点
            if(valOne <= valTwo) {
                newNode.next = l1;
                l1 = l1.next;
            } else {
                newNode.next = l2;
                l2 = l2.next;
            }

            // 变换 newNode
            newNode = newNode.next;
        }

        // 如果长度不一样
        if(l1 != null) {
            newNode.next = l1;
        }
        if(l2 != null) {
            newNode.next = l2;
        }

        return head.next;
    }


}
