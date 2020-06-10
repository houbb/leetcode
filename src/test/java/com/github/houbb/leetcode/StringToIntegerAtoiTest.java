package com.github.houbb.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class StringToIntegerAtoiTest {

    @Test
    public void basicTest() {
        StringToIntegerAtoi atoi = new StringToIntegerAtoi();

        Assert.assertEquals(42, atoi.myAtoi("42"));
        Assert.assertEquals(0, atoi.myAtoi("+"));
        Assert.assertEquals(0, atoi.myAtoi("-"));
        Assert.assertEquals(-42, atoi.myAtoi("   -42"));
        Assert.assertEquals(4193, atoi.myAtoi("4193 with words"));
        Assert.assertEquals(0, atoi.myAtoi("words and 987"));
        Assert.assertEquals(-2147483648, atoi.myAtoi("-91283472332"));
        Assert.assertEquals(12345678, atoi.myAtoi("0000000000012345678"));
        Assert.assertEquals(2147483647, atoi.myAtoi("20000000000000000000"));
    }

    @Test
    public void optimizeTest() {
        StringToIntegerAtoiOptimize atoi = new StringToIntegerAtoiOptimize();

        Assert.assertEquals(42, atoi.myAtoi("42"));
        Assert.assertEquals(0, atoi.myAtoi("+"));
        Assert.assertEquals(0, atoi.myAtoi("-"));
        Assert.assertEquals(-42, atoi.myAtoi("   -42"));
        Assert.assertEquals(4193, atoi.myAtoi("4193 with words"));
        Assert.assertEquals(0, atoi.myAtoi("words and 987"));
        Assert.assertEquals(-2147483648, atoi.myAtoi("-91283472332"));
        Assert.assertEquals(12345678, atoi.myAtoi("0000000000012345678"));
        Assert.assertEquals(2147483647, atoi.myAtoi("20000000000000000000"));
    }

}
