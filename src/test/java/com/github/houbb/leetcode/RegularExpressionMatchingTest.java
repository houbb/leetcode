package com.github.houbb.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p> project: leetcode-RegularExpressionMatchingTest </p>
 * <p> create on 2020/6/10 20:48 </p>
 *
 * @author binbin.hou
 * @since v1
 */
public class RegularExpressionMatchingTest {

    @Test
    public void basicTest() {
        RegularExpressionMatching matching = new RegularExpressionMatching();

        Assert.assertFalse(matching.isMatch("aa", "a"));
        Assert.assertTrue(matching.isMatch("aa", "a*"));
        Assert.assertTrue(matching.isMatch("ab", ".*"));
        Assert.assertTrue(matching.isMatch("aab", "c*a*b"));
        Assert.assertFalse(matching.isMatch("mississippi", "mis*is*p*."));
    }

}
