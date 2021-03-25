package com.github.houbb.leetcode.medium.F100T200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class SingleNumberBetter {

    // 每一个元素都出现2次，除了唯一的元素。
    // 2 个元素特征？
    // 1 次的特征呢？
    // 计数？？？
    // 如何让出现两次的数字抵消呢？？

    // 如果不适用额外的空间，如何找到上一次的元素呢？
    // 如何记录元素出现的次数呢？

    // 两个相同的数的和，一定还是偶数？




    /**
     * Runtime: 5 ms, faster than 54.71% of Java online submissions for Single Number.
     * Memory Usage: 39 MB, less than 83.31% of Java online submissions for Single Number.
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;

        // 能否進一步優化？
        // hash 的優勢在於 O(1) 訪問。
        // two pointer?
        Set<Integer> set = new HashSet<>(nums.length);
        for (int key : nums) {
            if (set.contains(key)) {
                result -= key;
            } else {
                result += key;
                set.add(key);
            }
        }

        return result;
    }

}
