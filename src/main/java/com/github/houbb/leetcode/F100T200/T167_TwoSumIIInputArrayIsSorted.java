package com.github.houbb.leetcode.F100T200;

public class T167_TwoSumIIInputArrayIsSorted {

    /**
     * 双指针
     *
     * 19 / 21
     *
     * @param numbers 数组
     * @param target 结果
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        // 永远有一个解
        int[] result = new int[2];

        for(int i = 0; i < numbers.length-1; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                int temp = numbers[i] + numbers[j];

                if(temp == target) {
                    result[0] = i+1;
                    result[1] = j+1;
                    return result;
                }
            }
        }

        return result;
    }


}
