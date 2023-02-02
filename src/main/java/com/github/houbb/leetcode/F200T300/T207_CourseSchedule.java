package com.github.houbb.leetcode.F200T300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T207_CourseSchedule {

    public static void main(String[] args) {
        T207_CourseSchedule courseSchedule = new T207_CourseSchedule();

        int[][] prerequisites = {
                {1,4},
                {2,4},
                {3,1},
                {3,2}
        };
        boolean result = courseSchedule.canFinish(5, prerequisites);
        System.out.println(result);
    }

    /**
     * 思路：BFS
     *
     *
     * Kahn算法采用入度方法，其算法过程如下：
     *
     * 1. 选择入度为0的节点，输出到结果序列中；
     *
     * 2. 删除该节点以及该节点的边；
     *
     * 重复执行步骤1和2，直到所有节点输出到结果序列中，完成拓扑排序；如果最后还存在入度不为0的节点，说明有向图中存在环，无法进行拓扑排序。
     *
     *
     * 【思路】
     * 存储课程的列表，保障可以加兼容 T210
     *
     *
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> resultList = new ArrayList<>();
        // 定义两个数据，一个存放对应的下标和剩余的入度数。
        Map<Integer, Integer> inCountMap = new HashMap<>();
        // 一个对应出度映射，删除一个节点时，哪些节点的入度可以-1
        Map<Integer, List<Integer>> outListMap = new HashMap<>();

        // 出度和入度的初始化
        for(int i = 0; i < prerequisites.length; i++) {
            int[] nums = prerequisites[i];

            // [1,0]  学习课程 1 之前，你需要完成课程 0 。这是可能的。
            int pre = nums[1];  // 准备课程
            int cur = nums[0];  // 当前课程

            // 1. 计算当前课程的入度
            Integer curInCount = inCountMap.getOrDefault(cur, 0);
            curInCount++;
            inCountMap.put(cur, curInCount);

            Integer preInCount = inCountMap.getOrDefault(pre, 0);
            inCountMap.put(pre, preInCount);

            //2. 删除一个 pre 节点，哪些节点的入度可以 -1
            List<Integer> outList = outListMap.getOrDefault(pre, new ArrayList<>());
            outList.add(cur);
            outListMap.put(pre, outList);
        }

        // 入度数为0的数组
        List<Integer> inZeroList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : inCountMap.entrySet()) {
            if(entry.getValue().equals(0)) {
                inZeroList.add(entry.getKey());
            }
        }

        // 当入度为0的列表存在时，循环处理
        while (inZeroList.size() > 0) {
            // 随意取出一个入度为0的元素，放在结果列表
            int zero = inZeroList.remove(0);
            resultList.add(zero);

            // 满足后直接返回，区别不大。忽略

            // 对应的所有入度列表-1，如果有节点入度变成0，加到零入度列表中
            List<Integer> outs = outListMap.getOrDefault(zero, new ArrayList<>());
            for(Integer out : outs) {
                Integer integer = inCountMap.get(out);
                integer--;
                inCountMap.put(out, integer);

                // 入度为0，加入0入度列表
                if(integer == 0) {
                    inZeroList.add(out);
                }
            }
        }


        // 如果看
        // 如果删除一个节点，如何把对应的入度更新呢？
        // 满足结果，或者说所有的需求都已经满足了
        return resultList.size() >= numCourses
                || resultList.size() >= inCountMap.keySet().size();
    }

}
