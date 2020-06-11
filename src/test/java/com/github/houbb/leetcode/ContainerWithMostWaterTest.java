package com.github.houbb.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class ContainerWithMostWaterTest {

    @Test
    public void basicTest() {
        int[] heights = new int[]{1,8,6,2,5,4,8,3,7};

        ContainerWithMostWater water = new ContainerWithMostWater();
        Assert.assertEquals(49, water.maxAreaV2(heights));
    }

    /**
     * 双指针法
     */
    @Test
    public void bestTest() {
        ContainerWithMostWater water = new ContainerWithMostWater();

        int[] heights = new int[]{1,8,6,2,5,4,8,3,7};
        Assert.assertEquals(49, water.maxArea(heights));

        int[] heights2 = new int[]{1,1};
        Assert.assertEquals(1, water.maxArea(heights2));

        int[] heights3 = new int[]{1, 2, 1};
        Assert.assertEquals(2, water.maxArea(heights3));
    }

    /**
     * 排序分组
     */
    @Test
    @Deprecated
    public void sortTest() {
        ContainerWithMostWater water = new ContainerWithMostWater();

        int[] heights = new int[]{1,8,6,2,5,4,8,3,7};
        Assert.assertEquals(49, water.maxAreaV3(heights));

        int[] heights2 = new int[]{1,1};
        Assert.assertEquals(1, water.maxAreaV3(heights2));

        int[] heights3 = new int[]{1, 2, 1};
        Assert.assertEquals(2, water.maxAreaV3(heights3));
    }

    @Test
    public void list() {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(2, 2);
        map.put(3, 2);
        map.put(1, 2);
        map.put(5, 2);
        map.put(4, 2);

        System.out.println(map.keySet());
    }

}
