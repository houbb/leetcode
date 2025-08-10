package com.github.houbb.leetcode.topics.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class T138_copyRandomList_v1_hashMap {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    private Map<Node, Node> buildMap(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();

        // 遍历一遍，把所有的 node 构建完成。暂时不设置 next + random
        while (head != null) {
            Node newNode = new Node(head.val);
            nodeMap.put(head, newNode);
            head = head.next;
        }
        return nodeMap;
    }
    /**
     * 深度拷贝
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        //1. 用 map 存储每一个属性
        Map<Node, Node> nodeMap = buildMap(head);

        //2. 再次遍历一遍，构建属性
        Node dummy = new Node(0);
        Node pre = dummy;

        while (head != null) {
            Node newNode = nodeMap.get(head);
            // 设置 next + random
            newNode.next = nodeMap.get(head.next);
            newNode.random = nodeMap.get(head.random);

            // 更新 pre
            pre.next = newNode;
            pre = newNode;

            // 移动
            head = head.next;
        }

        return dummy.next;
    }

}
