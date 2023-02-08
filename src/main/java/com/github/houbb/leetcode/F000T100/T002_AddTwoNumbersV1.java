package com.github.houbb.leetcode.F000T100;

import java.util.LinkedList;
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
public class T002_AddTwoNumbersV1 {

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
     * 注意：
     * （1）两个列表并不是一样长的，可能还有数字为空。
     * （2）末尾也可能产生进位
     *
     * 思路：
     * 直接遍历链表，使用一个位置保留进位。
     *
     * 列表的遍历一直是以最长的为准，走到最后。
     *
     * @param l1 列表1
     * @param l2 列表2
     * @return 结果
     * @since 1.0.0
     * @date 2020-6-9 12:08:44
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> oneList = getIntegerList(l1);
        List<Integer> twoList = getIntegerList(l2);

        //[5,5] 最后一位进1
        int size = oneList.size() > twoList.size() ? oneList.size() : twoList.size();
        // 借助第三条数组，存放进位
        int[] overflowFlags = new int[size+1];

        // 直接构建结果列表
        ListNode headNode = buildListNode(oneList, twoList, 0, overflowFlags);
        ListNode currentNode = headNode;
        for(int i = 1; i < size; i++) {
            currentNode.next = buildListNode(oneList, twoList, i, overflowFlags);
            currentNode = currentNode.next;
        }

        // 最后如果存在进位的话
        if(overflowFlags[size] == 1) {
            currentNode.next = new ListNode(1);
        }

        return headNode;
    }

    /**
     * 构建元素列表
     *
     * （1）为了避免 index == 0 时，判断
     * 将 index==0 时的信息直接保存在 0 位，当前进位保存在下一位。
     * @param oneList 第一个列表
     * @param twoList 第二个列表
     * @param index 下标
     * @param overflowFlags 越界标识
     * @return 结果
     * @since 0.0.1
     */
    private ListNode buildListNode(final List<Integer> oneList,
                                   final List<Integer> twoList,
                                   final int index,
                                   int[] overflowFlags) {
        int one = getIndexValue(oneList, index);
        int two = getIndexValue(twoList, index);

        int sum = one + two;
        int previousOverflow = overflowFlags[index];

        // 一般都是小于 10
        int value = sum + previousOverflow;

        if(value >= 10) {
            overflowFlags[index+1] = 1;
            // 保留个位
            value -= 10;
        }

        return new ListNode(value);
    }

    /**
     * 获取下标对应的值
     * @param list 列表
     * @param index 下标
     * @return 值
     * @since 1.0.0
     */
    private int getIndexValue(final List<Integer> list,
                              final int index) {
        if(index < list.size()) {
            return list.get(index);
        }

        return 0;
    }

    /**
     * 获取整数的链表
     * @param listNode 节点
     * @return 结果
     * @since 1.0.0
     */
    private List<Integer> getIntegerList(ListNode listNode) {
        // 使用 linkedList，避免扩容
        List<Integer> resultList = new LinkedList<>();
        ListNode oneNode = listNode;
        while (oneNode != null) {
            int value = oneNode.val;
            resultList.add(value);
            oneNode = oneNode.next;
        }
        return resultList;
    }

}
