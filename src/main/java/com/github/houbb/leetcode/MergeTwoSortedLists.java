package com.github.houbb.leetcode;

import javax.xml.soap.Node;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 合并两个有序的数组
 * @author binbin.hou
 * @since 1.0.0
 * @date 2020-6-17 11:26:40
 */
public class MergeTwoSortedLists {

    /**
     * 合并2个有序的数组
     *
     * 【思路1】
     * 直接遍历2个列表，然后合并为1个数组，然后重新构建结果
     *
     * 【效果】
     * Runtime: 4 ms, faster than 22.43% of Java online submissions for Merge Two Sorted Lists.
     * Memory Usage: 39.6 MB, less than 19.99% of Java online submissions for Merge Two Sorted Lists.
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 结果
     * @since v1
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> numsOne = getIntegerList(l1);
        List<Integer> numsTwo = getIntegerList(l2);

        numsOne.addAll(numsTwo);
        Collections.sort(numsOne);

        // 构建结果
        return buildHead(numsOne);
    }

    private List<Integer> getIntegerList(ListNode oneNode) {
        // 使用 linkedList，避免扩容
        List<Integer> resultList = new LinkedList<>();
        while (oneNode != null) {
            int value = oneNode.val;
            resultList.add(value);
            oneNode = oneNode.next;
        }
        return resultList;
    }

    private ListNode buildHead(List<Integer> integers) {
        if(integers.size() == 0) {
            return null;
        }

        ListNode head = new ListNode(integers.get(0));

        ListNode temp = head;
        for(int i = 1; i < integers.size(); i++) {
            temp.next = new ListNode(integers.get(i));
            temp = temp.next;
        }

        return head;
    }

}
