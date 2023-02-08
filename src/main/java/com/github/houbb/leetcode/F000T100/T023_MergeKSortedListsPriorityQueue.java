package com.github.houbb.leetcode.F000T100;

import com.github.houbb.leetcode.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 合并 k 个有序的链表
 *
 * <p> project: leetcode-MergeKSortedLists </p>
 * <p> create on 2020/6/17 23:17 </p>
 *
 * @author binbin.hou
 * @since 2020-6-17 23:17:53
 */
public class T023_MergeKSortedListsPriorityQueue {

    /**
     * 简单思路
     *
     * 1. 结束优先级队列
     *
     * 【效果】
     *
     * Runtime: 4 ms, faster than 81.55% of Java online submissions for Merge k Sorted Lists.
     * Memory Usage: 41.1 MB, less than 74.81% of Java online submissions for Merge k Sorted Lists.
     *
     * @param lists 列表
     * @return 结果
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(null == lists || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        // 循环添加元素
        for(ListNode listNode : lists) {
            if(listNode != null) {
                queue.offer(listNode);
            }
        }

        // 依次弹出
        return buildHead(queue);
    }

    /**
     * 构建头节点
     * @param queue 列表
     * @return 结果
     * @since v2
     */
    private ListNode buildHead(Queue<ListNode> queue) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            // 这里类似于将 queue 层层剥开放入 queue 中
            if(tail.next != null) {
                queue.add(tail.next);
            }
        }

        return dummy.next;
    }

}
