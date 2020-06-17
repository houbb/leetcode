package com.github.houbb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 动态规划
 *
 * 符合的序列：(a)b
 *
 * @author binbin.hou
 * @since 1.0.0
 * @date 2020-6-17 17:51:48
 */
public class GenerateParenthesesDp {

    // 存放缓存信息
    List<List<String>> cache = new ArrayList<>();

    /**
     *
     * 思路：
     *
     * 1. 所以都符合这种格式：(a)b
     * 2. 生成一个 a，在生成对应的 b;  拼接就是结果。
     *
     *
     * @param n 数字
     * @return 结果
     * @since v1
     */
    public List<String> generateParenthesis(int n) {
        // 直接返回
        if(cache.size() > n && cache.get(n) != null) {
            return cache.get(n);
        }

        // 初始化第一个元素列表为 [""]
        cache.add(Collections.singletonList(""));

        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = cache.get(j);
                List<String> str2 = cache.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        // 枚举右括号的位置
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            cache.add(cur);
        }

        return cache.get(n);
    }

}
