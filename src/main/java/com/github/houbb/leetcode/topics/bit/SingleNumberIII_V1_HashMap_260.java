package com.github.houbb.leetcode.topics.bit;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberIII_V1_HashMap_260 {

    public int[] singleNumber(int[] nums) {
        // 需要存储对应的历史数据
        // 如果不是位运算这种技巧 那么使用 HashMap 最方便

        int[] result = new int[2];
        int count = 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums){
            countMap.put(num, countMap.getOrDefault(num, 0) +1);
        }

        // 找到 values 为1 的数据
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if(entry.getValue() == 1) {
                result[count++] = entry.getKey();
            }
        }

        return result;
    }

}
