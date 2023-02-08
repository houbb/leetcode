package com.github.houbb.leetcode.F000T100;

import com.github.houbb.leetcode.ListNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 合并 k 个有序的链表
 *
 * <p> project: leetcode-MergeKSortedLists </p>
 * <p> create on 2020/6/17 23:17 </p>
 *
 * @author binbin.hou
 * @since 2020-6-17 23:17:53
 */
public class T023_MergeKSortedLists {

    /**
     * 简单思路
     *
     * 1. 全部获取
     * 2. 排序
     * 3. 构建
     *
     * 【效果】
     *
     * Runtime: 103 ms, faster than 15.12% of Java online submissions for Merge k Sorted Lists.
     * Memory Usage: 40.6 MB, less than 94.79% of Java online submissions for Merge k Sorted Lists.
     *
     * 复杂度：
     * 1. 数据收集 O(N)
     * 2. 稳定排序 O(NlgN)
     * 3. 遍历 O(N)
     *
     * @param lists 列表
     * @return 结果
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(null == lists || lists.length == 0) {
            return null;
        }

        // 查找操作比较少
        List<Integer> integerList = new LinkedList<>();

        for(ListNode listNode : lists) {
            integerList.addAll(getIntegerList(listNode));
        }

        // 排序
        Collections.sort(integerList);

        // 构建结果
        return buildHead(integerList);
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
