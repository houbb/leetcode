package com.github.houbb.leetcode.topics.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class T146_lurCache_V2_LinkedList {

    class LRUCache {

        // 节点
        class Node {
            int key;
            Node prev, next;
            Node(int key) { this.key = key; }
        }

        private Map<Integer, Integer> valueMap = new HashMap<>();
        private int capacity = 0;

        private Map<Integer, Node> nodeMap = new HashMap<>();
        private Node tail = new Node(-1);
        private Node head = new Node(-1);

        public LRUCache(int capacity) {
            this.capacity = capacity;

            // 双向
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if(!valueMap.containsKey(key)) {
                return -1;
            }

            updateUsage(key);

            return valueMap.get(key);
        }

        public void put(int key, int value) {
            // 大小限制
            if(!valueMap.containsKey(key)
                    && valueMap.size() >= capacity) {
                // 驱除最老的一个
                evictKey();
            }

            // 更新使用频率
            updateUsage(key);

            // 更新
            valueMap.put(key, value);
        }

        private void updateUsage(int key) {
            Node node = nodeMap.get(key);
            if(node == null) {
                node = new Node(key);
                nodeMap.put(key, node);
            } else {
                // 先删除这个节点
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            // 节点放在表头 head->[]->tail
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        private void evictKey() {
            Node oldest = tail.prev;
            if (oldest == head) return; // 空链表
            removeNode(oldest);
            int key = oldest.key;

            nodeMap.remove(key);
            valueMap.remove(key);
        }

        private void removeNode(final Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }



}
