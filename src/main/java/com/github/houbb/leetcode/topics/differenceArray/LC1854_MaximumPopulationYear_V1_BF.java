package com.github.houbb.leetcode.topics.differenceArray;

public class LC1854_MaximumPopulationYear_V1_BF {

    public int maximumPopulation(int[][] logs) {
        int maxCount = 0;
        int maxYear = 0;

        for(int year = 1950; year <= 2050; year++) {
            int aliveCount = 0;
            // 判断一个人是否活着
            for(int i = 0; i < logs.length; i++) {
                int[] person = logs[i];

                // 在这一年 or 之前出生
                // 在这一年之后死亡
                if(person[0] <= year
                        && person[1] > year) {
                    aliveCount++;
                }
            }

            // 更新
            if(aliveCount > maxCount) {
                maxYear = year;
                maxCount = aliveCount;
            }
        }
        return maxYear;
    }

}
