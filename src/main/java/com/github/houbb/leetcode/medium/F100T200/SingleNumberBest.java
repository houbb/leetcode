package com.github.houbb.leetcode.medium.F100T200;

import java.util.HashSet;
import java.util.Set;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class SingleNumberBest {

    // 每一个元素都出现2次，除了唯一的元素。
    // 2 个元素特征？
    // 1 次的特征呢？
    // 计数？？？
    // 如何让出现两次的数字抵消呢？？

    // 如果不适用额外的空间，如何找到上一次的元素呢？
    // 如何记录元素出现的次数呢？

    // 两个相同的数的和，一定还是偶数？




    /**
     * Runtime: 1 ms, faster than 95.67% of Java online submissions for Single Number.
     * Memory Usage: 39.3 MB, less than 48.69% of Java online submissions for Single Number.
     *
     * 位运算：其实这一题如果能想到 bit operator，那么就是可以想到的。也很正常。
     *
     * a ^= a;
     *
     * 一个数，异或本身为0。
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int result = 0;

        for (int key : nums) {
            result ^= key;
        }

        return result;
    }


    // 這個更加殘忍，可以減少一次運算

    /**
     * Runtime: 1 ms, faster than 95.67% of Java online submissions for Single Number.
     * Memory Usage: 38.9 MB, less than 90.73% of Java online submissions for Single Number.
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }

}
