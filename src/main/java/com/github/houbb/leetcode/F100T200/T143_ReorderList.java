package com.github.houbb.leetcode.F100T200;

import com.github.houbb.leetcode.ListNode;
import com.github.houbb.leetcode.util.ListNodes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author d
 * @since 1.0.0
 */
public class T143_ReorderList {

    public static void main(String[] args) {
        T143_ReorderList reorderList = new T143_ReorderList();

        ListNode head = ListNodes.buildHead(new int[]{1, 2, 3, 4, 5, 6, 7});
        reorderList.reorderList(head);
        ListNodes.showList(head);
    }


    /**
     * 重排序
     *
     * 1. 奇数个
     *
     * 首位对称，会剩下最后一个。
     *
     * 2. 偶数个
     *
     * 首位对称
     *
     * 【思路】
     * 1. 一次迭代，保留所有 head 节点
     * 2. 第二次迭代，构建出最后的结果。
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        // 获取所有节点
        List<ListNode> nodeList = new ArrayList<>();
        ListNode pointer = head;
        while (pointer != null) {
            nodeList.add(pointer);
            pointer = pointer.next;
        }

        //fast return
        if(nodeList.size() <= 1) {
            return;
        }

        //2. 构建新的节点（从后往前构建，这个直接 head.next = xxx 搞定）
        ListNode lastNode = null;
        // 奇数个
        int mid = nodeList.size() / 2;
        if(nodeList.size() % 2 == 1) {
            ListNode midNode = nodeList.get(mid);
            midNode.next = null;
            lastNode = midNode;

            // 从中间偏右开始处理
            mid++;
        }

        ListNode rightNode = lastNode;
        ListNode leftNode = null;

        // 从中间偏右开始，倒右边倒数第二个结束
        // 最后一个单独处理，因为对称的是第一个元素
        for(int i = mid; i < nodeList.size()-1; i++) {
            // 右边
            rightNode = nodeList.get(i);
            rightNode.next = lastNode;

            // 对称的左边
            leftNode = nodeList.get(nodeList.size()-1-i);
            leftNode.next = rightNode;

            // 更新 lastNode
            lastNode = leftNode;
        }

        // 处理最后一个元素
        rightNode = nodeList.get(nodeList.size()-1);
        rightNode.next = lastNode;

        // 头结点，指向最后的右边节点
        head.next = rightNode;
    }


}
