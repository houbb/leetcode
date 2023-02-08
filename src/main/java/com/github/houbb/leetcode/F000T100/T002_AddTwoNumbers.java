package com.github.houbb.leetcode.F000T100;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author binbin.hou
 * @since 1.0.0
 * @date 2020-6-9 11:38:48
 */
public class T002_AddTwoNumbers {

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
     * 最基本思路
     *
     * l1 反转构建为数字
     * l2 反转构建为数字
     *
     * num = l1+l2
     *
     * 然后反转列表输出。
     *
     * 坑：这里限定了入参是一个单向链表
     *
     *
     * 效果：
     *
     * Runtime: 18 ms, faster than 5.29% of Java online submissions for Add Two Numbers.
     * Memory Usage: 40.4 MB, less than 16.38% of Java online submissions for Add Two Numbers.
     *
     * @param l1 列表1
     * @param l2 列表2
     * @return 结果
     * @since 1.0.0
     * @date 2020-6-9 12:08:44
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> numOneList = getIntegerList(l1);
        List<Integer> numTwoList = getIntegerList(l2);

        BigInteger numOne = buildBigInteger(numOneList);
        BigInteger numTwo = buildBigInteger(numTwoList);

        BigInteger sum = numOne.add(numTwo);
        return buildListNode(sum);
    }

    /**
     * 构建最后的结果
     * @param sum 和
     * @return 结果
     * @since 1.0.0
     */
    private ListNode buildListNode(final BigInteger sum) {
        String string = sum.toString();

        ListNode headNode = buildListNode(string, string.length()-1);
        ListNode currentNode = headNode;
        for(int i = string.length()-2; i >= 0; i--) {
            currentNode.next = buildListNode(string, i);
            currentNode = currentNode.next;
        }

        return headNode;
    }

    private ListNode buildListNode(String string, int index) {
        int integer = Integer.parseInt(string.charAt(index) + "");
        return new ListNode(integer);
    }

    /**
     * 获取整数的链表
     * @param listNode 节点
     * @return 结果
     * @since 1.0.0
     */
    public List<Integer> getIntegerList(ListNode listNode) {
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

    /**
     * 根据单个数字构建 BigInteger，不知道入参有多长
     * @param integers 数组
     * @return 结果
     * @since 1.0.0
     */
    private BigInteger buildBigInteger(final List<Integer> integers) {
        // 逆序遍历 LinkedList 应该有双向指针，理论上不慢。
        integers.iterator();
        ListIterator<Integer> iterator = integers.listIterator(integers.size());

        // 避免扩容
        StringBuilder stringBuilder = new StringBuilder(integers.size());
        while(iterator.hasPrevious()){
            int integer = iterator.previous();
            stringBuilder.append(integer);
        }

        return new BigInteger(stringBuilder.toString());
    }

}
