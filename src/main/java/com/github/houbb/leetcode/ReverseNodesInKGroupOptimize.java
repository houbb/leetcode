package com.github.houbb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 优化
 * @author binbin.hou
 * @since 1.0.0
 */
public class ReverseNodesInKGroupOptimize {

    /**
     * 思路：
     *
     * 反转意味着什么？
     * <pre>
     * list: 1->2->3->4->5
     * k=2
     *
     * result: 2->1->4->3->5
     * </pre>
     *
     * 和交换的联系？
     *
     * 【思路】
     * 减少 current 重复的移动。
     * @param head 节点
     * @param k 多个元素
     * @return 结果
     * @since v1
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 列表不变
        if(k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode current = dummy;

        while (current != null) {
            List<ListNode> listNodes = new ArrayList<>(k);

            ListNode previous = current;
            // 代替 current 移动
            for(int i = 0; i < k; i++) {
                ListNode numNode = current.next;
                // 节点不够，直接返回
                if(numNode == null) {
                    return dummy.next;
                }

                // 放入节点
                listNodes.add(numNode);

                // 位置调整
                current = current.next;
            }

            // 逆序处理
            //a->b->c->d
            //c->b->a->d
            listNodes.get(0).next = current.next;
            for(int i = 1; i < k; i++) {
                listNodes.get(i).next = listNodes.get(i-1);
            }
            previous.next = listNodes.get(k-1);
        }

        return dummy.next;
    }

}
