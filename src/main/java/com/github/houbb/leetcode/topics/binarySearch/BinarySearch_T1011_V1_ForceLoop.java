package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T1011_V1_ForceLoop {

    public int shipWithinDays(int[] weights, int days) {
        // 最小
        long left = 0;
        // 最大
        long right = 0;

        for(int weight : weights) {
            left = Math.max(weight, left);

            // 会不会越界？
            right += weight;
        }

        // force
        for(long weightLimit = left; weightLimit <= right; weightLimit++) {
            // 计算的是天数？

            long totalDays = 0;
            long tempWeight = 0;
            for(int weight : weights) {
                // 超出+1 清空
                if(tempWeight + weight > weightLimit) {
                    totalDays++;
                    tempWeight = 0;

                    // 快速失败
                    if(totalDays > days) {
                        break;
                    }
                }

                // 继续增加
                tempWeight += weight;

                // 快速失败
            }

            // 剩余的
            if(tempWeight > 0) {
                totalDays++;
            }

            // 满足
            if(totalDays <= days) {
                return Math.toIntExact(weightLimit);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch_T1011_V1_ForceLoop loop = new BinarySearch_T1011_V1_ForceLoop();
        int[] weights= new int[]{1, 1, 1, 500};
        int days = 2;
        System.out.println(loop.shipWithinDays(weights, days));
    }

}
