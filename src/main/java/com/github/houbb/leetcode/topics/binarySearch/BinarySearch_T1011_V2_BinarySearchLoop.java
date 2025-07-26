package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T1011_V2_BinarySearchLoop {

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

        while (left <= right) {
            int mid = Math.toIntExact(left + (right - left) / 2);

            int totalDays = calcTotalDays(weights, days, mid);
            // 满足条件的最小值 继续向左边去
            if(totalDays <= days) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return Math.toIntExact(left);
    }

    private int calcTotalDays(int[] weights, int days, int weightLimit) {
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
        }

        // 剩余的
        if(tempWeight > 0) {
            totalDays++;
        }

        return Math.toIntExact(totalDays);
    }

    // 测试极端的场景
    public static void main(String[] args) {
        BinarySearch_T1011_V2_BinarySearchLoop loop = new BinarySearch_T1011_V2_BinarySearchLoop();
        int[] weights= new int[]{1,1,1,1000};
        int days = 2;
        System.out.println(loop.shipWithinDays(weights, days));
    }


}
