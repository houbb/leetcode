package com.github.houbb.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class IntegerToRomanTest {

    @Test
    public void test() {
        IntegerToRoman roman = new IntegerToRoman();

//        Assert.assertEquals("III", roman.intToRoman(3));
//        Assert.assertEquals("IV", roman.intToRoman(4));
//        Assert.assertEquals("IX", roman.intToRoman(9));
        Assert.assertEquals("LVIII", roman.intToRoman(58));
        Assert.assertEquals("MCMXCIV", roman.intToRoman(1994));
    }

    @Test
    public void allCacheTest() {
        IntegerToRoman roman = new IntegerToRoman();

        String template = "CACHE.put(%d, \"%s\");";
        for(int i = 1; i <= 3999; i++) {
            System.out.println(String.format(template, i, roman.intToRoman(i)));
        }
    }
}
