package com.github.houbb.leetcode;

/**
 * 合并 k 个有序的链表
 *
 * 两个两个合并，一直持续到最后。
 * <p> project: leetcode-MergeKSortedLists </p>
 * <p> create on 2020/6/17 23:17 </p>
 *
 * @author binbin.hou
 * @since 2020-6-17 23:17:53
 */
public class MergeKSortedListsOneByOne {

    /**
     * 简单思路
     *
     *
     * 【效果】
     *
     * Runtime: 106 ms, faster than 14.46% of Java online submissions for Merge k Sorted Lists.
     * Memory Usage: 41 MB, less than 75.98% of Java online submissions for Merge k Sorted Lists.
     *
     * @param lists 列表
     * @return 结果
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(null == lists || lists.length == 0) {
            return null;
        }

        //
        ListNode result = lists[0];

        // 从第二个开始遍历
        for(int i = 1; i < lists.length; i++) {
            ListNode node = lists[i];
            result = mergeTwoLists(result, node);
        }

        return result;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
