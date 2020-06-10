package com.github.houbb.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class ZigzagConversionTest {

    @Test
    public void basicTest() {
        ZigzagConversion conversion = new ZigzagConversion();
        Assert.assertEquals("PAHNAPLSIIGYIR", conversion.convert("PAYPALISHIRING", 3));
        Assert.assertEquals("PINALSIGYAHRPI", conversion.convert("PAYPALISHIRING", 4));
    }

    @Test
    public void basicOptimizeTest() {
        ZigzagConversion conversion = new ZigzagConversion();
        Assert.assertEquals("PAHNAPLSIIGYIR", conversion.convertOptimize("PAYPALISHIRING", 3));
        Assert.assertEquals("PINALSIGYAHRPI", conversion.convertOptimize("PAYPALISHIRING", 4));
    }

    @Test
    public void bufferTest() {
        ZigzagConversion conversion = new ZigzagConversion();
        Assert.assertEquals("PAHNAPLSIIGYIR", conversion.convertWithBuffer("PAYPALISHIRING", 3));
        Assert.assertEquals("PINALSIGYAHRPI", conversion.convertWithBuffer("PAYPALISHIRING", 4));
        Assert.assertEquals("ABDC", conversion.convertWithBuffer("ABCD", 3));
    }

}
