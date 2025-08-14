package com.github.houbb.leetcode.topics.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC207_v1_Hash {


    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1,0}
        };
        System.out.println(canFinish(2, nums));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> preMap = new HashMap<>();
        Set<Integer> zeroSet = new HashSet<>();

        // 初始化
        for(int[] ints : prerequisites) {
            int cur = ints[0];
            int pre = ints[1];

            Set<Integer> set = preMap.getOrDefault(cur, new HashSet<>());
            set.add(pre);
            preMap.put(cur, set);
        }

        // zero
        for(int i = 0; i < numCourses; i++) {
            if(!preMap.containsKey(i)) {
                zeroSet.add(i);
            }
        }

        // 迭代处理
        while(!zeroSet.isEmpty()) {
            Set<Integer> tempZeroSet = new HashSet<>();

            for(Integer num : zeroSet) {
                // 移除元素
                for(Map.Entry<Integer, Set<Integer>> entry : preMap.entrySet()) {
                    Integer key = entry.getKey();
                    Set<Integer> set = entry.getValue();
                    set.remove(num);

                    if(set.isEmpty()) {
                        tempZeroSet.add(key);
                    }
                }
            }

            // 统一删除，避免修改问题
            if(!tempZeroSet.isEmpty()) {
                for(Integer num : tempZeroSet) {
                    preMap.remove(num);
                }
            }

            zeroSet = tempZeroSet;
        }

        return preMap.isEmpty();
    }


}
