package com.github.houbb.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class ReverseIntegerTest {

    @Test
    public void reverseTest() {
        ReverseInteger reverseInteger = new ReverseInteger();

        Assert.assertEquals(9646324351, reverseInteger.reverseBasic(1534236469));
    }

}
