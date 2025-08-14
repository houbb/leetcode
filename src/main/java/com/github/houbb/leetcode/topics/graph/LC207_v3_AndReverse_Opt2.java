package com.github.houbb.leetcode.topics.graph;

import java.util.*;

public class LC207_v3_AndReverse_Opt2 {


    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1,0}
        };
        System.out.println(canFinish(2, nums));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] preMap = new int[numCourses];
        Map<Integer, Set<Integer>> reverseMap = new HashMap<>();
        Queue<Integer> zeroSet = new LinkedList<>();

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
                zeroSet.offer(i);
            }
        }

        // 迭代处理
        int count = 0;
        while(!zeroSet.isEmpty()) {
            // 出队列
            int num = zeroSet.poll();
            count++;

            // 直接找受影响的课程（避免全表扫描）
            if (reverseMap.containsKey(num)) {
                for (Integer course : reverseMap.get(num)) {
                    preMap[course]--;
                    if (preMap[course] == 0) {
                        // 入队列
                        zeroSet.offer(course);
                    }
                }
            }
        }

        return count == numCourses;
    }


}
