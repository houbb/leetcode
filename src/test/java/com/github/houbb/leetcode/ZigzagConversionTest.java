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
        Assert.assertEquals("PAHNAPLSIIGYIR", conversion.convertBasic("PAYPALISHIRING", 3));
        Assert.assertEquals("PINALSIGYAHRPI", conversion.convertBasic("PAYPALISHIRING", 4));
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
        Assert.assertEquals("PAHNAPLSIIGYIR", conversion.convert2("PAYPALISHIRING", 3));
        Assert.assertEquals("PINALSIGYAHRPI", conversion.convert2("PAYPALISHIRING", 4));
        Assert.assertEquals("ABDC", conversion.convert2("ABCD", 3));
    }

    @Test
    public void v3Test() {
        ZigzagConversion conversion = new ZigzagConversion();
        Assert.assertEquals("PAHNAPLSIIGYIR", conversion.convert3("PAYPALISHIRING", 3));
        Assert.assertEquals("PINALSIGYAHRPI", conversion.convert3("PAYPALISHIRING", 4));
        Assert.assertEquals("ABDC", conversion.convert3("ABCD", 3));
    }

    @Test
    public void bestTest() {
        ZigzagConversion conversion = new ZigzagConversion();
        Assert.assertEquals("PAHNAPLSIIGYIR", conversion.convert("PAYPALISHIRING", 3));
        Assert.assertEquals("PINALSIGYAHRPI", conversion.convert("PAYPALISHIRING", 4));
        Assert.assertEquals("ABDC", conversion.convert("ABCD", 3));
    }

}
