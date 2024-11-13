package com.github.houbb.leetcode.datastruct.array;

public class T252_meetingRoot_V1_BF {

    public static boolean canAttendMeetings(int[][] intervals) {
        // 暴力
        final int len = intervals.length;
        for(int i = 0; i < len; i++) {
            // 和所有的其他对比
            for(int j = i+1; j < len; j++) {
                // 检查会议 intervals[i] 和 intervals[j] 是否重叠
                if (intervals[i][1] > intervals[j][0] && intervals[j][1] > intervals[i][0]) {
                    return false; // 找到重叠会议，返回 false
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Test case 1: " + canAttendMeetings(intervals1)); // 输出：false

        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println("Test case 2: " + canAttendMeetings(intervals2)); // 输出：true
    }


}
