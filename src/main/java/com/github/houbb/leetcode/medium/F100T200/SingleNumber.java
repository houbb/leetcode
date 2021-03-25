package com.github.houbb.leetcode.medium.F100T200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class SingleNumber {

    // 每一个元素都出现2次，除了唯一的元素。
    // 2 个元素特征？
    // 1 次的特征呢？
    // 计数？？？
    // 如何让出现两次的数字抵消呢？？

    // 如果不适用额外的空间，如何找到上一次的元素呢？
    // 如何记录元素出现的次数呢？

    // 两个相同的数的和，一定还是偶数？




    /**
     * Runtime: 8 ms, faster than 42.49% of Java online submissions for Single Number.
     * Memory Usage: 39.5 MB, less than 34.85% of Java online submissions for Single Number.
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int key : nums) {
            if (map.containsKey(key)) {
                map.remove(key);
            } else {
                map.put(key, 1);
            }
        }

        //O(1)
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            return entry.getKey();
        }

        // 不应该到达
        return -1;
    }

}
