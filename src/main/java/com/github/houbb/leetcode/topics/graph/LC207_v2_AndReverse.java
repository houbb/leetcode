package com.github.houbb.leetcode.topics.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC207_v2_AndReverse {


    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1,0}
        };
        System.out.println(canFinish(2, nums));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> preMap = new HashMap<>();
        Map<Integer, Set<Integer>> reverseMap = new HashMap<>();
        Set<Integer> zeroSet = new HashSet<>();

        // 初始化
        for(int[] ints : prerequisites) {
            int cur = ints[0];
            int pre = ints[1];

            // 我依赖了谁
            Set<Integer> set = preMap.getOrDefault(cur, new HashSet<>());
            set.add(pre);
            preMap.put(cur, set);

            // 谁依赖了我
            Set<Integer> reverseSet = reverseMap.getOrDefault(pre, new HashSet<>());
            reverseSet.add(cur);
            reverseMap.put(pre, reverseSet);
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
                // 移除的时候其实不用全表扫描 只看被影响的就行

                // 直接找受影响的课程（避免全表扫描）
                if (reverseMap.containsKey(num)) {
                    for (Integer course : reverseMap.get(num)) {
                        Set<Integer> set = preMap.get(course);
                        if (set != null) {
                            set.remove(num);
                            if (set.isEmpty()) {
                                tempZeroSet.add(course);
                            }
                        }
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
