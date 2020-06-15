package com.github.houbb.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class FourSumTest {

    @Test
    public void basicTest() {
        FourSum fourSum = new FourSum();

        int[] nums = new int[]{
                1, 0, -1, 0, -2, 2
        };
        Assert.assertEquals("[[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]", fourSum.fourSum(nums, 0).toString());

        int[] nums2 = new int[]{
                0,0,0,0
        };
        Assert.assertEquals("[[0, 0, 0, 0]]", fourSum.fourSum(nums2, 0).toString());
    }

    @Test
    public void dupTest() {
        FourSum fourSum = new FourSum();

        int[] nums = new int[]{
                -3,-2,-1,0,0,1,2,3
        };
        Assert.assertEquals("[[-3, -2, 2, 3], [-3, -1, 1, 3], [-3, 0, 0, 3], [-3, 0, 1, 2], [-2, -1, 0, 3], [-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]", fourSum.fourSum(nums, 0).toString());
    }

    @Test
    public void bestTest() {
        FourSumBest best = new FourSumBest();

        int[] nums = new int[]{
                1,0,-1,0,-2,2
        };
        Assert.assertEquals("[[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]", best.fourSum(nums, 0).toString());
    }

}
