package com.github.houbb.leetcode.topics.editdistance;

import java.util.ArrayList;
import java.util.List;

public class T2542_twoEditWords_V2_BF_OPT {


    /**
     * 暴力算法
     * @param queries
     * @param dictionary
     * @return
     */
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list = new ArrayList<>();

        for(String query : queries) {
            if(isTwoEditWords(query, dictionary)) {
                list.add(query);
            }
        }
        return list;
    }

    private boolean isTwoEditWords(final String query,
                                   String[] dictionary) {
        for(String dict : dictionary) {
            if(isTwoEditWords(query, dict)) {
                return true;
            }
        }
        return false;
    }

    private boolean isTwoEditWords(String word, String dict) {
        if(word.length() != dict.length()) {
            return false;
        }

        int differCount = 0;
        char[] ss = word.toCharArray();
        char[] ts = dict.toCharArray();
        for(int i = 0; i < ss.length; i++) {
            if(ss[i] != ts[i]) {
                differCount++;
            }
            if(differCount > 2) {
                return false;
            }
        }

        return true;
    }

}
