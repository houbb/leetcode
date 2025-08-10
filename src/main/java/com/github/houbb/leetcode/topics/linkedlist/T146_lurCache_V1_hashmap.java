package com.github.houbb.leetcode.topics.linkedlist;

import java.util.*;

public class T146_lurCache_V1_hashmap {

    class LRUCache {

        private Map<Integer, Integer> valueMap = new HashMap<>();

        private Map<Integer, Long> lastUseMap = new HashMap<>();

        private int capacity = 0;

        // 替代时间戳
        private long counter = 0;

        public LRUCache(int capacity) {
            this.capacity = capacity;
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
            // 更新使用时间
            lastUseMap.put(key, ++counter);
        }

        private void evictKey() {
            // 找到最少被使用的 Key?
            long time = Long.MAX_VALUE;
            Integer key = -1;
            for(Map.Entry<Integer, Long> entry : lastUseMap.entrySet()) {
                if(entry.getValue() < time) {
                    key = entry.getKey();
                    time = entry.getValue();
                }
            }

            lastUseMap.remove(key);
            valueMap.remove(key);
        }
    }



}
