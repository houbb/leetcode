package com.github.houbb.leetcode.datastruct.array;

import java.util.HashSet;
import java.util.Set;

public class T136_SingleNumber_V2_HashSet {

    public int singleNumber(int[] nums) {
        // 需要存储对应的历史数据
        // 如果不是位运算这种技巧 那么使用 HashMap 最方便

        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)) {
                set.remove(num);
            }else {
                set.add(num);
            }
        }

        for(Integer num : set) {
            return num;
        }
        return 0;
    }

}
