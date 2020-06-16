package com.github.houbb.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p> project: leetcode-ValidParenthesesTest </p>
 * <p> create on 2020/6/16 22:59 </p>
 *
 * @author binbin.hou
 * @since v1
 */
public class ValidParenthesesTest {

    @Test
    public void basicTest() {
        ValidParentheses validParentheses = new ValidParentheses();

        Assert.assertTrue(validParentheses.isValid("()"));
        Assert.assertTrue(validParentheses.isValid("()[]{}"));
        Assert.assertFalse(validParentheses.isValid("(]"));
        Assert.assertFalse(validParentheses.isValid("([)]"));
        Assert.assertTrue(validParentheses.isValid("{[]}"));
    }

    @Test
    public void optimizeTest() {
        ValidParenthesesOptimize validParentheses = new ValidParenthesesOptimize();

        Assert.assertTrue(validParentheses.isValid("()"));
        Assert.assertTrue(validParentheses.isValid("()[]{}"));
        Assert.assertFalse(validParentheses.isValid("(]"));
        Assert.assertFalse(validParentheses.isValid("([)]"));
        Assert.assertTrue(validParentheses.isValid("{[]}"));
    }

}
