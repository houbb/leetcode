package com.github.houbb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    /**
     * 获取整数的链表
     * @return 结果
     * @since 1.0.0
     */
    public List<Integer> getIntegerList() {
        // 使用 linkedList，避免扩容
        List<Integer> resultList = new LinkedList<>();
        ListNode oneNode = this;
        while (oneNode != null) {
            int value = oneNode.val;
            resultList.add(value);
            oneNode = oneNode.next;
        }
        return resultList;
    }
}
