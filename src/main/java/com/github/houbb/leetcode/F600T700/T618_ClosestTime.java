package com.github.houbb.leetcode.F600T700;

import java.util.*;

public class T618_ClosestTime {

    public static void main(String[] args) {
        T618_ClosestTime closestTime = new T618_ClosestTime();
        System.out.println(closestTime.nextClosestTime("19:34"));
        System.out.println(closestTime.nextClosestTime("23:59"));
    }

    public String nextClosestTime(String time) {
        // 字符集合
        char chars[] = time.toCharArray();
        Set<Character> characters = new HashSet<>();
        for(char c : chars) {
            characters.add(c);
        }

        // 遍历
        int timeNum = toMin(time);
        for(int i = timeNum+1; i <= 1440; i++) {
            String tempTimeStr = toStr(i);
            if(isValid(characters, tempTimeStr)) {
                return tempTimeStr;
            }
        }

        // 没找到
        for(int i = 0; i < 1440; i++) {
            String tempTimeStr = toStr(i);
            if(isValid(characters, tempTimeStr)) {
                return tempTimeStr;
            }
        }

        return "";
    }

    private int toMin(String str) {
        String hourStr = str.substring(0, 2);
        String minStr = str.substring(3, 5);
        return Integer.parseInt(hourStr) * 60 + Integer.parseInt(minStr);
    }

    private String toStr(int minNum) {
        int hour = minNum / 60;
        int min = minNum % 60;
        return String.format("%2d:%2d", hour, min);
    }

    private boolean isValid(Set<Character> characters, String timeStr) {
        // 必须包含所有的时间字符
        char[] chars = timeStr.toCharArray();
        for(char c : chars) {
            if(c == ':') {
                continue;
            }

            if(!characters.contains(c)) {
                return false;
            }
        }
        return true;
    }

}
