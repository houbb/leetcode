package com.github.houbb.leetcode.topics.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC207_v3_AndReverse_Opt {


    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1,0}
        };
        System.out.println(canFinish(2, nums));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] preMap = new int[numCourses];
        Map<Integer, Set<Integer>> reverseMap = new HashMap<>();
        Set<Integer> zeroSet = new HashSet<>();

        // 初始化
        for(int[] ints : prerequisites) {
            int cur = ints[0];
            int pre = ints[1];

            // 我依赖了谁
            preMap[cur]++;

            // 谁依赖了我
            Set<Integer> reverseSet = reverseMap.getOrDefault(pre, new HashSet<>());
            reverseSet.add(cur);
            reverseMap.put(pre, reverseSet);
        }

        // zero
        for(int i = 0; i < numCourses; i++) {
            if(preMap[i] == 0) {
                zeroSet.add(i);
            }
        }

        // 迭代处理
        int count = 0;
        while(!zeroSet.isEmpty()) {
            Set<Integer> tempZeroSet = new HashSet<>();

            for(Integer num : zeroSet) {
                count++;

                // 移除的时候其实不用全表扫描 只看被影响的就行

                // 直接找受影响的课程（避免全表扫描）
                if (reverseMap.containsKey(num)) {
                    for (Integer course : reverseMap.get(num)) {
                        preMap[course]--;
                        if (preMap[course] == 0) {
                            tempZeroSet.add(course);
                        }
                    }
                }
            }

            zeroSet = tempZeroSet;
        }

        return count == numCourses;
    }


}
