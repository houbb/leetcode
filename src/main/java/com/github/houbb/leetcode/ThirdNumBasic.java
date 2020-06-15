package com.github.houbb.leetcode;

import java.util.*;

/**
 * @author binbin.hou
 * @since 1.0.0
 * @date 2020-6-12 09:10:38
 */
@Deprecated
public class ThirdNumBasic {

    /**
     * 三个数字
     *
     * 1. 不能三个元素都是0
     * 2. 保证三个数 a+b+c=0
     * @param nums 入参
     * @return 结果
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) {
            return Collections.emptyList();
        }

        List<List<Integer>> results = new ArrayList<>();
        Set<String> stringSet = new HashSet<>();

        for(int i = 0; i < nums.length-2; i+=3) {
            for(int j = i+1; j < nums.length-1; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    if((nums[i] + nums[j]+nums[k]) == 0) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        // 排序保证结果不重复
                        Collections.sort(list);
                        String string = list.toString();
                        if(stringSet.contains(string)) {
                            continue;
                        }
                        stringSet.add(string);

                        results.add(list);
                    }
                }
            }
        }

        return results;
    }

}
