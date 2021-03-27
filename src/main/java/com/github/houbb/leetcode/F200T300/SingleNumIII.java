package com.github.houbb.leetcode.F200T300;

import java.util.HashMap;
import java.util.Map;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class SingleNumIII {

    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        // 獲取結果
        int[] results = new int[2];
        int size = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                results[size++] = entry.getKey();
            }
        }
        return results;
    }

}
