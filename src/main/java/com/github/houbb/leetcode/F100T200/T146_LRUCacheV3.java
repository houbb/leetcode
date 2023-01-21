package com.github.houbb.leetcode.F100T200;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU:
 *
 * 先进来的放到尾端，后进来放到头部，如果内存不够应该是从尾部删除吧，如果get队列中有的数据元素，则会把它移动到头部，每次put都要判断缓存大小是否达到指定的大小，如果达到了，则移除尾部元素
 *
 */
public class T146_LRUCacheV3 {


    /**
     * 通过 hashmap 存放数据
     */
    private Map<Integer, Integer> dataMap;

    public T146_LRUCacheV3(final int capacity) {
        this.dataMap = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                // 大于指定容量，则移除最旧的元素
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return dataMap.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        dataMap.put(key, value);
    }


}
