package com.github.houbb.leetcode.F100T200;

import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        //問：如果 s 爲空呢？
        // 如果 wordDict 爲空呢？

        if(s == null || s.length() == 0) {
            return false;
        }
        if(wordDict == null || wordDict.size() == 0) {
            return false;
        }


        // 真正的處理邏輯
        // 這一題的本質是什麽呢？
        // 思路是什麽呢？

        // 反過來思考：利用 wordDict 中的基本元素，可以拼接出來 s
        // 如何拼接呢？選擇什麽元素拼接呢？


        // 選擇一個，判斷剩下的能否組成？
        // 這是一個 dp 問題？
        // 回溯問題？


        return true;
    }

}
