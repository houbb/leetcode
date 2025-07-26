package com.github.houbb.leetcode.topics.binarySearch;

public class BinarySearch_T1011_V2_BinarySearchLoopOpt {

    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int max = 0;
        int sum = 0;
        for(int x : weights){
            max = Math.max(max,x);
            sum += x;
        }
        // 比较均匀时
        int avgRight = ((n + days - 1)/days) * max;
        int left = max;
        // 取二者最小值
        int right = Math.min(avgRight, sum);

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


    public static void main(String[] args) {
        BinarySearch_T1011_V2_BinarySearchLoopOpt loop = new BinarySearch_T1011_V2_BinarySearchLoopOpt();
        int[] weights= new int[]{1, 1, 1, 1000};
        int days = 2;
        int n = weights.length;
        int max = 0;
        for(int x : weights){
            max = Math.max(max,x);
        }
        int left = max,right = ((n + days - 1)/days) * max;
        System.out.println(right);
    }

}
