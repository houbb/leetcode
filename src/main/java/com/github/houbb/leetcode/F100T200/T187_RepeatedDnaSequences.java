package com.github.houbb.leetcode.F100T200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T187_RepeatedDnaSequences {

    /**
     * 思路：
     *
     * 1. 以 10 作为步长，截取 substr
     *
     * 2. 如果一个 substr 出现多次，则放在结果中
     *
     * 当然，也可以使用 hashmap 等替代
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeat = new HashSet<>();

        for(int i = 0; i < s.length()-9; i++) {
            String subStr = s.substring(i, i+10);

            // false，说明存在多次。
            if(!seen.add(subStr)) {
                repeat.add(subStr);
            }
        }

        return new ArrayList<>(repeat);
    }

}
