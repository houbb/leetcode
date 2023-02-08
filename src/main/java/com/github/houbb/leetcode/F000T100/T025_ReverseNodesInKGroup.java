package com.github.houbb.leetcode.F000T100;

import com.github.houbb.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class T025_ReverseNodesInKGroup {

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
     * 【效果】
     * Runtime: 2 ms, faster than 8.84% of Java online submissions for Reverse Nodes in k-Group.
     * Memory Usage: 39.1 MB, less than 99.17% of Java online submissions for Reverse Nodes in k-Group.
     *
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

            // 代替 current 移动
            ListNode temp = current;
            for(int i = 0; i < k; i++) {
                ListNode numNode = temp.next;
                // 节点不够，直接返回
                if(numNode == null) {
                    return dummy.next;
                }

                // 放入节点
                listNodes.add(numNode);

                // 位置调整
                temp = temp.next;
            }

            // 逆序处理
            //a->b->c->d
            //c->b->a->d
            listNodes.get(0).next = temp.next;
            for(int i = 1; i < k; i++) {
                listNodes.get(i).next = listNodes.get(i-1);
            }
            current.next = listNodes.get(k-1);

            // 直接指向 temp（位置调整了 k 次）
            for(int i = 0; i < k; i++) {
                current = current.next;
            }
        }

        return dummy.next;
    }

}
