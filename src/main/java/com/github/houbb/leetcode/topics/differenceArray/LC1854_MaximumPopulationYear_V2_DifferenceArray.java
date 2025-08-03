package com.github.houbb.leetcode.topics.differenceArray;

public class LC1854_MaximumPopulationYear_V2_DifferenceArray {

    public int maximumPopulation(int[][] logs) {
        // 差异101年
        int[] differArray = new int[101];
        for(int[] ints : logs) {
            differArray[ints[0]-1950]++; //birth
            differArray[ints[1]-1950]--; //death
        }

        int maxCount = 0;
        int maxYear = 0;
        int currentNum = 0;
        for(int year = 0; year < 101; year++) {
            // 当前的人数
            currentNum += differArray[year];

            if(currentNum > maxCount) {
                maxYear = year+1950;
                maxCount = currentNum;
            }
        }
        return maxYear;
    }

}
