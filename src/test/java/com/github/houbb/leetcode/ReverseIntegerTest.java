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
        Assert.assertEquals(321, reverseInteger.reverseBasic(123));
    }

}
