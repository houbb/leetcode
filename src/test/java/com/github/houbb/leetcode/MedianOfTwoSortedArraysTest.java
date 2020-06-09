package com.github.houbb.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class MedianOfTwoSortedArraysTest {

    @Test
    public void basicTest() {
        MedianOfTwoSortedArrays arrays = new MedianOfTwoSortedArrays();

        int[] numsOne = new int[]{1,2};
        int[] numsTwo = new int[]{3,4};

        System.out.println(arrays.findMedianSortedArrays(numsOne, numsTwo));
    }

    @Test
    public void leetCodeTest() {
        MedianOfTwoSortedArrays arrays = new MedianOfTwoSortedArrays();

        int[] numsOne = new int[]{1,2};
        int[] numsTwo = new int[]{3,4};

        System.out.println(arrays.findMedianLeetCode(numsOne, numsTwo));
    }

}
