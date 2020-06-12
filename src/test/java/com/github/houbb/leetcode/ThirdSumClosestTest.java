package com.github.houbb.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class ThirdSumClosestTest {

    @Test
    public void basicTest() {
        ThirdSumClosest closest = new ThirdSumClosest();

        Assert.assertEquals(2, closest.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        Assert.assertEquals(3, closest.threeSumClosest(new int[]{1,1,1,1}, 0));
    }

    @Test
    public void optimizeTest() {
        ThirdSumClosestOptimize closest = new ThirdSumClosestOptimize();

        Assert.assertEquals(2, closest.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        Assert.assertEquals(3, closest.threeSumClosest(new int[]{1,1,1,1}, 0));
    }

}
