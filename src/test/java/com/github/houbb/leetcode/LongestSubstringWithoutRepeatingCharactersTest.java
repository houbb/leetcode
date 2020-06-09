package com.github.houbb.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    public void basicTest() {
        LongestSubstringWithoutRepeatingCharacters characters = new LongestSubstringWithoutRepeatingCharacters();

        Assert.assertEquals(4, characters.lengthOfLongestSubstring("jbpnbwwd"));
        Assert.assertEquals(2, characters.lengthOfLongestSubstring("cdd"));
        Assert.assertEquals(1, characters.lengthOfLongestSubstring(" "));
        Assert.assertEquals(1, characters.lengthOfLongestSubstring("bbbbb"));
        Assert.assertEquals(3, characters.lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(3, characters.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    public void slideWindowOptimizeTest() {
        LongestSubstringWithoutRepeatingCharacters characters = new LongestSubstringWithoutRepeatingCharacters();

        Assert.assertEquals(4, characters.lengthOfLongestSubstringSlidWindowOptimize("jbpnbwwd"));
        Assert.assertEquals(2, characters.lengthOfLongestSubstringSlidWindowOptimize("cdd"));
        Assert.assertEquals(1, characters.lengthOfLongestSubstringSlidWindowOptimize(" "));
        Assert.assertEquals(1, characters.lengthOfLongestSubstringSlidWindowOptimize("bbbbb"));
        Assert.assertEquals(3, characters.lengthOfLongestSubstringSlidWindowOptimize("abcabcbb"));
        Assert.assertEquals(3, characters.lengthOfLongestSubstringSlidWindowOptimize("pwwkew"));
    }

    @Test
    public void tableOptimizeTest() {
        LongestSubstringWithoutRepeatingCharacters characters = new LongestSubstringWithoutRepeatingCharacters();

        Assert.assertEquals(4, characters.tableOptimize("jbpnbwwd"));
        Assert.assertEquals(2, characters.tableOptimize("cdd"));
        Assert.assertEquals(1, characters.tableOptimize(" "));
        Assert.assertEquals(1, characters.tableOptimize("bbbbb"));
        Assert.assertEquals(3, characters.tableOptimize("abcabcbb"));
        Assert.assertEquals(3, characters.tableOptimize("pwwkew"));
    }

}
