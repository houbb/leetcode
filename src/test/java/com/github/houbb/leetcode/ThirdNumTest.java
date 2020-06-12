package com.github.houbb.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class ThirdNumTest {

    @Test
    public void basicTest() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        ThirdNumBasic thirdNumBasic = new ThirdNumBasic();

        List<List<Integer>> lists = thirdNumBasic.threeSum(nums);
        Assert.assertEquals("[[-1, 0, 1], [-1, 2, -1]]", lists.toString());

        int[] nums2 = new int[]{0,0,0,0};
        List<List<Integer>> lists2 = thirdNumBasic.threeSum(nums2);
        Assert.assertEquals("[[0, 0, 0]]", lists2.toString());
    }

    @Test
    public void optimizeTest() {
        ThirdNumOptimize optimize = new ThirdNumOptimize();

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = optimize.threeSum(nums);
        Assert.assertEquals("[[-1, -1, 2], [-1, 0, 1]]", lists.toString());

        int[] nums2 = new int[]{0,0,0,0};
        List<List<Integer>> lists2 = optimize.threeSum(nums2);
        Assert.assertEquals("[[0, 0, 0]]", lists2.toString());

        int[] nums3 = new int[]{0,0,0};
        List<List<Integer>> lists3 = optimize.threeSum(nums3);
        Assert.assertEquals("[[0, 0, 0]]", lists3.toString());

        int[] nums4 = new int[]{1,1,-2};
        List<List<Integer>> lists4 = optimize.threeSum(nums4);
        Assert.assertEquals("[[1, 1, -2]]", lists4.toString());

        int[] nums5 = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        List<List<Integer>> lists5 = optimize.threeSum(nums4);
        Assert.assertEquals("[[1, 1, -2]]", lists4.toString());
    }

    @Test
    public void sortedAndTwoPointerTest() {
        ThirdNumSortedAndTwoPointer optimize = new ThirdNumSortedAndTwoPointer();

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = optimize.threeSum(nums);
        Assert.assertEquals("[[-1, -1, 2], [-1, 0, 1]]", lists.toString());

        int[] nums2 = new int[]{0,0,0,0};
        List<List<Integer>> lists2 = optimize.threeSum(nums2);
        Assert.assertEquals("[[0, 0, 0]]", lists2.toString());

        int[] nums3 = new int[]{0,0,0};
        List<List<Integer>> lists3 = optimize.threeSum(nums3);
        Assert.assertEquals("[[0, 0, 0]]", lists3.toString());

        int[] nums4 = new int[]{1,1,-2};
        List<List<Integer>> lists4 = optimize.threeSum(nums4);
        Assert.assertEquals("[[-2, 1, 1]]", lists4.toString());

        int[] nums5 = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        List<List<Integer>> lists5 = optimize.threeSum(nums5);
        Assert.assertEquals("[[-5, 1, 4], [-4, 0, 4], [-4, 1, 3], [-2, -2, 4], [-2, 1, 1], [0, 0, 0]]", lists5.toString());

        int[] nums6 = new int[]{-2,0,1,1,2};
        List<List<Integer>> lists6 = optimize.threeSum(nums6);
        Assert.assertEquals("[[-2, 0, 2], [-2, 1, 1]]", lists6.toString());
    }

}
