package com.github.houbb.leetcode.F100T200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T179_LargestNumber {

    public String largestNumber(int[] nums) {
        //1. int 转 string
        List<String> stringList = new ArrayList<>(nums.length);
        for(int i : nums) {
            stringList.add(String.valueOf(i));
        }

        //2. 排序
        Collections.sort(stringList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;

                // reverse order here, so we can do append() later
                return s2.compareTo(s1);
            }
        });

        //3. 构建结果
        // An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if(stringList.get(0).charAt(0) == '0') {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(String s: stringList) {
            sb.append(s);
        }

        return sb.toString();
    }

}
