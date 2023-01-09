package com.github.houbb.leetcode.F000T100;

import java.util.ArrayList;
import java.util.List;

public class T068_TextJustification {

    /**
     * 思路：
     *
     * 1. 从左到右遍历
     *
     * 1.1 每个单词，每新增一个单词至少新增一个 ' '
     * 1.2 如果长度已经 <= maxWidth，且如果加入下一个，则超过。则直接 tempList 构建。不够的通过 ' ' 填充，第1、2之间填充所有剩余的 ' '
     *
     * 1.3 最后剩余的单词，‘ ’ 放在最后面
     * @param words 单词
     * @param maxWidth 最大宽度
     * @return 结果
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> resultList = new ArrayList<>();

        List<String> tempList = new ArrayList<>();

        //greedy
        for(int i = 0; i < words.length; i++) {
            String word = words[i];

            // 终止条件 已经为16，或者加下一个单词，> 16
            int tempLen = calcTotalLength(tempList);
            if(tempLen == 16
                || (tempLen + word.length() > 16)) {
                // 是否为最后一个，决定了格式化的格式
                boolean isLastLineFlag = i == word.length()-1;

                String string = buildString(tempList, isLastLineFlag);
                resultList.add(string);

                tempList = new ArrayList<>();
            } else {
                // 加入 tempList
                tempList.add(word);
            }
        }


        return resultList;
    }

    private String buildString(List<String> tempList, boolean isLastLineFlag) {
        // 如果不是最后一个，则居中。把多余的空格，放在第一个后面。
        if(!isLastLineFlag) {

            return "";
        } else {
            return "";
        }
    }

    /**
     * 计算总长度
     *
     * 1、至少的长度为，单词本身的长度 + tempList.size()-1 的空格
     *
     * @param tempList 临时列表
     * @return 结果
     */
    private int calcTotalLength(List<String> tempList) {
        //1. 临时列表
        int total = 0;

        for(String word : tempList) {
            total += word.length();
        }

        //额外的空字符串
        if(tempList.size() > 1) {
            total += tempList.size()-1;
        }

        // 添加上额外的空字符串
        return total;
    }

}
