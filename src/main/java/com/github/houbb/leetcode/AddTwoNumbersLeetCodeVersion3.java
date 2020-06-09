package com.github.houbb.leetcode;

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
public class AddTwoNumbersLeetCodeVersion3 {

    /**
     * 进位标识
     * @since 0.0.1
     */
    private static volatile int overflowFlag = 0 ;

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
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Two Numbers.
     * Memory Usage: 39.7 MB, less than 44.45% of Java online submissions for Add Two Numbers.
     * Next challenges:
     *
     * @param l1 列表1
     * @param l2 列表2
     * @return 结果
     * @since 1.0.0
     * @date 2020-6-9 12:08:44
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 直接构建结果列表
        ListNode headNode = buildListNode(l1, l2);
        ListNode currentNode = headNode;

        ListNode l1Next = l1.next;
        ListNode l2Next = l2.next;
        while (l1Next != null || l2Next != null) {
            currentNode.next = buildListNode(l1Next, l2Next);
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
        if(overflowFlag == 1) {
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
     * @param l1 节点1
     * @param l2 节点2
     * @return 结果
     * @since 0.0.1
     */
    private ListNode buildListNode(ListNode l1, ListNode l2) {
        int valueOne = getValue(l1);
        int valueTwo = getValue(l2);

        int sum = valueOne+valueTwo + overflowFlag;

        if(sum >= 10) {
            sum -= 10;
            overflowFlag = 1;
        } else {
            overflowFlag = 0;
        }

        return new ListNode(sum);
    }

}
