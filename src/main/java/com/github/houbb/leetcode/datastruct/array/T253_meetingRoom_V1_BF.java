package com.github.houbb.leetcode.datastruct.array;

import java.util.Map;

public class T253_meetingRoom_V1_BF {

    public static int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;

        int res = 1;
        // 双重循环检查每一对会议是否重叠
        for (int i = 0; i < n; i++) {
            int maxCount = 1;
            for (int j = i + 1; j < n; j++) {
                // 检查会议 intervals[i] 和 intervals[j] 是否重叠
                if (intervals[i][1] > intervals[j][0] && intervals[j][1] > intervals[i][0]) {
                    maxCount++;
                }
            }

            // 取最大值
            res = Math.max(res, maxCount);
        }

        return res;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(minMeetingRooms(intervals1)); // Expected output: 2

        // Test Case 2
        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println(minMeetingRooms(intervals2)); // Expected output: 1
    }

}
