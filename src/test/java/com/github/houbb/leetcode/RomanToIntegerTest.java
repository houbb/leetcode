package com.github.houbb.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class RomanToIntegerTest {

    @Test
    public void test() {
        RomanToInteger roman = new RomanToInteger();

        Assert.assertEquals(3, roman.romanToInt("III"));
        Assert.assertEquals(4, roman.romanToInt("IV"));
        Assert.assertEquals(9, roman.romanToInt("IX"));
        Assert.assertEquals(58, roman.romanToInt("LVIII"));
        Assert.assertEquals(1994, roman.romanToInt("MCMXCIV"));
    }

}
