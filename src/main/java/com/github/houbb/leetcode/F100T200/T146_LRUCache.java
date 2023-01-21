package com.github.houbb.leetcode.F100T200;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * LRU:
 *
 * 先进来的放到尾端，后进来放到头部，如果内存不够应该是从尾部删除吧，如果get队列中有的数据元素，则会把它移动到头部，每次put都要判断缓存大小是否达到指定的大小，如果达到了，则移除尾部元素
 *
 */
public class T146_LRUCache {

    public static void main(String[] args) {
        T146_LRUCache lRUCache = new T146_LRUCache(2);
        lRUCache.put(2, 1); // cache is {1=1, 2=2}
        lRUCache.put(1, 1); // cache is {1=1, 2=2}
        lRUCache.put(2, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.put(4, 1); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(1); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    }

    /**
     * 通过 hashmap 存放数据
     */
    private Map<Integer, Integer> dataMap;

    /**
     * 链表。
     *
     * 1. 新的数据放在 head
     * 2. 每次插入判断是否达到最大的 size，如果达到，则直接 remove 尾巴的元素。
     *
     */
    private List<Integer> freqList;

    private int capacity = 0;

    public T146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.dataMap = new HashMap<>(capacity);
        this.freqList = new LinkedList<>();
    }

    public int get(int key) {
        // 不存在返回-1
        Integer value =  dataMap.get(key);

        // 判断是否存在这个 key
        if(dataMap.containsKey(key)) {
            // GET 的时候，也需要更新频率，首先要把以前的值移除掉。
            // 这里 jdk 的设计，导致无法区分 int 导致是一个 object，还是一个 index。T_T
            this.freqList.remove((Integer) key);
            this.freqList.add(0, key);

            System.out.println("GET freq="+freqList);
        } else {
            value = -1;
        }

        System.out.println("GET KEY="+key +", value=" + value);
        return value;
    }

    public void put(int key, int value) {
        // 首先判断数据是不是满了，而且不包含的时候才淘汰
        if(dataMap.size() >= capacity
            && !dataMap.containsKey(key)) {
            // 准备移除数据，最后一个
            int lastIndex = this.freqList.size()-1;

            // 把对应的数据都删除。
            Integer lastKey = this.freqList.get(lastIndex);
            this.dataMap.remove(lastKey);

            this.freqList.remove(lastIndex);
            System.out.println("EVICT key="+key+", value="+value+", data="+dataMap+", freq="+ freqList);
        }

        // 放入数据
        this.dataMap.put(key, value);

        // 移除
        this.freqList.remove((Integer)key);
        this.freqList.add(0, key);

        System.out.println("PUT key="+key+", value="+value+", data="+dataMap+", freq="+ freqList);
    }


}
