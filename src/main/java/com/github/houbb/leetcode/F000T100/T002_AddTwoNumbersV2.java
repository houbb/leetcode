package com.github.houbb.leetcode.F000T100;

import java.util.ArrayList;
import java.util.List;

/**
 * 官方的解法
 *
 * 核心：
 * 5+7=12 会产生进位，但是最多只有一次进位
 * 因为：9+9+1=19
 *
 * 核心流程：
 *
 * @author binbin.hou
 * @since 1.0.0
 * @date 2020-6-9 11:38:48
 */
public class T002_AddTwoNumbersV2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     *
     * TODO: 要学会避免前两次的列表循环。
     *
     * 注意：
     * （1）两个列表并不是一样长的，可能还有数字为空。
     * （2）末尾也可能产生进位
     *
     * 思路：
     * 直接遍历链表，使用一个位置保留进位。
     *
     * 列表的遍历一直是以最长的为准，走到最后。
     *
     *
     * 效果：
     *
     * Runtime: 3 ms, faster than 19.95% of Java online submissions for Add Two Numbers.
     * Memory Usage: 39.4 MB, less than 81.33% of Java online submissions for Add Two Numbers.
     *
     * @param l1 列表1
     * @param l2 列表2
     * @return 结果
     * @since 1.0.0
     * @date 2020-6-9 12:08:44
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 借助第三条数组，存放进位
        // 这里有个问题，无法知道具体的数组大小。所以扩容比较难避免。
        List<Integer> overflowFlags = new ArrayList<>();
        // 初始化
        overflowFlags.add(0);

        // 直接构建结果列表
        ListNode headNode = buildListNode(l1.val, l2.val, 0, overflowFlags);
        ListNode currentNode = headNode;

        ListNode l1Next = l1.next;
        ListNode l2Next = l2.next;
        while (l1Next != null || l2Next != null) {
            int count = overflowFlags.size()-1;

            // 处理对应的值
            int numOne = getValue(l1Next);
            int numTwo = getValue(l2Next);

            currentNode.next = buildListNode(numOne, numTwo, count, overflowFlags);
            currentNode = currentNode.next;

            // 往后遍历
            if(l1Next != null) {
                l1Next = l1Next.next;
            }
            if(l2Next != null) {
                l2Next = l2Next.next;
            }
        }

        // 最后如果存在进位的话
        if(overflowFlags.get(overflowFlags.size()-1) == 1) {
            currentNode.next = new ListNode(1);
        }

        return headNode;
    }

    /**
     * 获取下一个元素值
     *
     * 默认返回 0
     * @param listNode 当前节点
     * @return 下一个节点的值
     * @since 1.0.0
     */
    private int getValue(ListNode listNode) {
        if(listNode == null) {
            return 0;
        }

        return listNode.val;
    }

    /**
     * 构建元素列表
     *
     * （1）为了避免 index == 0 时，判断
     * 将 index==0 时的信息直接保存在 0 位，当前进位保存在下一位。
     * @param index 下标
     * @param overflowFlags 越界标识
     * @return 结果
     * @since 0.0.1
     */
    private ListNode buildListNode(final int one,
                                   final int two,
                                   final int index,
                                   List<Integer> overflowFlags) {
        int sum = one + two;
        int previousOverflow = overflowFlags.get(index);

        // 一般都是小于 10
        int value = sum + previousOverflow;

        if(value >= 10) {
            overflowFlags.add(index+1, 1);
            // 保留个位
            value -= 10;
        } else {
            overflowFlags.add(index+1, 0);
        }

        return new ListNode(value);
    }

}
