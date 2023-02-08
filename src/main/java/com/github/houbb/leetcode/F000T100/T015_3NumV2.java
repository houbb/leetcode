package com.github.houbb.leetcode.F000T100;

import java.util.*;

/**
 * 优化思路：
 *
 * 1. 数组分为>=0，小于0两部分
 * 2. 数组排序
 * 3. 双指针法则
 * -1 -1 2 3
 *
 *
 * 指针肯定落在两边，而不会是一边。（否则不可能和为0 ）
 * @author binbin.hou
 * @since 1.0.0
 * @date 2020-6-12 09:10:38
 */
public class T015_3NumV2 {

    /**
     * 三个数字
     *
     * 1. 不能三个元素都是0
     * 2. 保证三个数 a+b+c=0
     *
     * 【效果】
     *
     * Runtime: 835 ms, faster than 5.01% of Java online submissions for 3Sum.
     * Memory Usage: 45.7 MB, less than 18.94% of Java online submissions for 3Sum.
     *
     * @param nums 入参
     * @return 结果
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) {
            return Collections.emptyList();
        }

        List<List<Integer>> results = new ArrayList<>(nums.length);
        List<Integer> numsLeft = new ArrayList<>(nums.length);
        List<Integer> numsRight = new ArrayList<>(nums.length);

        for (int val : nums) {
            if (val <= 0) {
                numsLeft.add(val);
            } else {
                numsRight.add(val);
            }
        }
        // 排序（避免无用处理）
        Collections.sort(numsLeft);
        Collections.sort(numsRight);

        // 循环左边列表即可（复杂度降低一半）
        // Q2: 如何去重？
        Set<String> resultSet = new HashSet<>();
        for(int i = 0; i < numsLeft.size()-1; i++) {
            for(int j = i+1; j < numsLeft.size(); j++) {
                int value = numsLeft.get(i)+numsLeft.get(j);

                // 添加3个0 的标识，如果前两个为0，直接跳过。
                if(value == 0 && j < numsLeft.size()-1) {
                    List<Integer> zeros = Arrays.asList(0, 0, 0);


                    if(!results.contains(zeros)) {
                        resultSet.add(zeros.toString());
                        results.add(zeros);
                    }
                } else {
                    int abs = Math.abs(value);

                    int index = Collections.binarySearch(numsRight, abs);
                    if(index >= 0) {
                        List<Integer> integers = new ArrayList<>(4);
                        integers.add(numsLeft.get(i));
                        integers.add(numsLeft.get(j));
                        integers.add(abs);

                        String string = integers.toString();
                        if(!resultSet.contains(string)) {
                            results.add(integers);
                            resultSet.add(string);
                        }
                    }
                }
            }
        }

        for(int i = 0; i < numsRight.size()-1; i++) {
            for(int j = i+1; j < numsRight.size(); j++) {
                int value = numsRight.get(i)+numsRight.get(j);

                int index = Collections.binarySearch(numsLeft, -value);
                if(index >= 0) {
                    List<Integer> integers = new ArrayList<>(4);
                    integers.add(numsRight.get(i));
                    integers.add(numsRight.get(j));
                    integers.add(-value);

                    String string = integers.toString();
                    if(!resultSet.contains(string)) {
                        results.add(integers);
                        resultSet.add(string);
                    }
                }
            }
        }

        return results;
    }

}
