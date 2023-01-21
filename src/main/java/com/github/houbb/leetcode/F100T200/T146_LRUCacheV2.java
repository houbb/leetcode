package com.github.houbb.leetcode.F100T200;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU:
 *
 * 先进来的放到尾端，后进来放到头部，如果内存不够应该是从尾部删除吧，如果get队列中有的数据元素，则会把它移动到头部，每次put都要判断缓存大小是否达到指定的大小，如果达到了，则移除尾部元素
 *
 */
public class T146_LRUCacheV2 {

    /**
     * 双向链表节点
     */
    private class DoubleNode {
        int key;
        int value;

        DoubleNode prev;
        DoubleNode next;

        public DoubleNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // head 之后，after 之前
    private void add(DoubleNode node){
        DoubleNode after = head.next;

        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }

    // 移除当前节点 A<=>B<=>C  变成 A<=>C
    private void remove(DoubleNode node){
        DoubleNode before = node.prev;
        DoubleNode after = node.next;
        before.next = after;
        after.prev = before;
    }

    /**
     * 通过 hashmap 存放数据
     */
    private Map<Integer, DoubleNode> dataMap;

    /**
     * 最大容量
     */
    private int capacity;

    /**
     * 头尾节点
     */
    private DoubleNode head, tail;

    public T146_LRUCacheV2(int capacity) {
        this.capacity = capacity;
        this.dataMap = new HashMap<>();

        // 初始化首尾
        this.head = new DoubleNode(0,0);
        this.tail = new DoubleNode(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleNode node = dataMap.get(key);
        if(node == null) {
            return -1;
        }

        //更新 node 信息
        remove(node);
        add(node);

        return node.value;
    }

    public void put(int key, int value) {
        //是否存在
        DoubleNode node = dataMap.get(key);
        if(node == null) {
            DoubleNode newNode = new DoubleNode(key, value);
            dataMap.put(key, newNode);

            // 不存在，则初始化插入
            this.add(newNode);
        } else {
            // 如果存在，则更新对应的 value
            node.value = value;

            //更新 node 信息
            remove(node);
            add(node);
        }

        // 如果超过大小，则移除 tail 元素
        if(dataMap.size() > this.capacity) {
            DoubleNode lastNode = this.tail.prev;
            this.remove(lastNode);

            this.dataMap.remove(lastNode.key);
        }
    }


}
