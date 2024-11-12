package com.github.houbb.leetcode.datastruct.array;

import java.util.Arrays;
import java.util.Comparator;

public class T252_meetingRoom_V2_Sort {

    public static boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        // 双重循环检查每一对会议是否重叠
        for (int i = 1; i < n; i++) {
            // 本次开始 上一次还没有结束
            if(intervals[i][0] < intervals[i-1][1]) {
                return false;
            }
        }

        // 没有重叠会议
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Test case 1: " + canAttendMeetings(intervals1)); // 输出：false

        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println("Test case 2: " + canAttendMeetings(intervals2)); // 输出：true
    }

}
