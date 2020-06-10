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

        Assert.assertFalse(matching.isMatchJdk("aa", "a"));
        Assert.assertTrue(matching.isMatchJdk("aa", "a*"));
        Assert.assertTrue(matching.isMatchJdk("ab", ".*"));
        Assert.assertTrue(matching.isMatchJdk("aab", "c*a*b"));
        Assert.assertFalse(matching.isMatchJdk("mississippi", "mis*is*p*."));
    }

    @Test
    public void recursiveTest() {
        RegularExpressionMatching matching = new RegularExpressionMatching();

        Assert.assertFalse(matching.isMatchRecursive("aa", "a"));
        Assert.assertTrue(matching.isMatchRecursive("aa", "a*"));
        Assert.assertTrue(matching.isMatchRecursive("ab", ".*"));
        Assert.assertTrue(matching.isMatchRecursive("aab", "c*a*b"));
        Assert.assertFalse(matching.isMatchRecursive("mississippi", "mis*is*p*."));
    }


}
