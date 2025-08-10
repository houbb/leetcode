package com.github.houbb.leetcode.topics.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class T146_lurCache_V2_LinkedListOpt {

    class LRUCache {

        class Node {
            int key;
            int value;
            Node pre;
            Node next;

            public Node(int k, int v) {
                key = k;
                value = v;
            }
        }

        private final Node[] map;
        private final Node head, tail;
        private int size;
        private final int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new Node[10001];
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            this.size = 0;
        }

        public int get(int key) {
            Node node = map[key];
            if (node == null) {
                return -1;
            }
            removeNode(node);
            addToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = map[key];
            if (node != null) {
                node.value = value;
                removeNode(node);
                addToHead(node);
            } else {
                if (size == capacity) {
                    //移除最后一个元素
                    Node tailpre = tail.pre;
                    removeNode(tailpre);
                    map[tailpre.key] = null;
                    size--;
                }
                //放入元素
                Node newnode = new Node(key, value);
                addToHead(newnode);
                map[key] = newnode;
                size++;
            }
        }

        private void removeNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        private void addToHead(Node node) {
            node.next = head.next;
            node.next.pre = node;
            node.pre = head;
            head.next = node;
        }
    }



}
