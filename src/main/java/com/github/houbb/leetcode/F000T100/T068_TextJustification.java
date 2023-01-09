package com.github.houbb.leetcode.F000T100;

import java.util.ArrayList;
import java.util.List;

public class T068_TextJustification {

    public static void main(String[] args) {
//        System.out.println("everything else we do".length());

        T068_TextJustification textJustification = new T068_TextJustification();
        String[] words1 = new String[]{
                "Listen","to","many,","speak","to","a","few."
        };
        System.out.println(textJustification.fullJustify(words1, 6));

//        String[] words2 = new String[]{
//                "ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"
//        };
//        System.out.println(textJustification.fullJustify(words2, 16));
    }

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

            // 是否为最后一个，决定了格式化的格式
            boolean isLastLineFlag = false;

            // 需要区分开是刚好满足，还是需要加入一个再满足。
            if(tempLen == maxWidth
                    || (tempLen + word.length() >= maxWidth)) {
                String string = buildString(tempList, false, maxWidth);
                if(string.length() > 0) {
                    resultList.add(string);
                }

                tempList = new ArrayList<>();
                // 放入当前元素
                tempList.add(word);
            } else if(tempLen + word.length() == maxWidth-1) {
                tempList.add(word);

                // 最后一个行
                if(i == words.length-1) {
                    isLastLineFlag = true;
                }
                String string = buildString(tempList, isLastLineFlag, maxWidth);
                if(string.length() > 0) {
                    resultList.add(string);
                }

                tempList = new ArrayList<>();
            } else {
                tempList.add(word);
            }
        }

        // 如果列表不为空，则为最后一行
        if(tempList.size() >= 1) {
            String string = buildString(tempList, true, maxWidth);
            if(string.length() > 0) {
                resultList.add(string);
            }
        }


        return resultList;
    }

    /**
     *   "Science  is  what we",
     *   "understand      well",
     *   "enough to explain to",
     *   "a  computer.  Art is",
     *   "everything  else  we",
     *   "do                  "
     *
     * @param tempList 临时链表
     * @param isLastLineFlag 是否为最后一行
     * @return 结果
     */
    private String buildString(List<String> tempList,
                               boolean isLastLineFlag,
                               int maxWidth) {
        String string = "";
        // 如果不是最后一个，则居中。把多余的空格，放在第一个后面。
        // 放在第一个字符串的中间
        if(!isLastLineFlag) {
            // 不是最后一个，但是列表为1，左对齐
            if(tempList.size() == 1) {
                return tempList.get(0) + repeat(" ", maxWidth - tempList.get(0).length());
            }

            // 计算平均的空格数
            int rawStringLen = join(tempList, "").length();

            // 如果没有均分，则全部空余放在左边
            int remainBlankTime = (maxWidth - rawStringLen) % (tempList.size()-1);
            // 均分
            int avgBlankTime = (maxWidth - rawStringLen) / (tempList.size()-1);;

            // 没有均分，从左到右均摊。
            if(remainBlankTime != 0) {
                // 没有均分，
                StringBuilder stringBuilder = new StringBuilder();
                for(int i = 0; i < tempList.size()-1; i++) {
                    String word = tempList.get(i);

                    stringBuilder.append(word)
                            .append(repeat(" ", avgBlankTime))
                            .append(remainBlankTime-- > 0 ? " " : "");  // 均摊多余的空格
                }

                stringBuilder.append(tempList.get(tempList.size()-1));
                string = stringBuilder.toString();
            } else {
                string = join(tempList, repeat(" ", avgBlankTime));
            }
        } else {
            string = join(tempList, " ");
            int remainBlankWidth = maxWidth - string.length();
            // 右边用空格填充
            if(remainBlankWidth > 0) {
                string += repeat(" ", remainBlankWidth);
            }
        }

        return string;
    }

    private String repeat(String unit, int times) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < times; i++) {
            stringBuilder.append(unit);
        }

        return stringBuilder.toString();
    }

    private String join(List<String> tempList,
                        String splitter) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < tempList.size()-1; i++) {
            stringBuilder.append(tempList.get(i))
                    .append(splitter);
        }

        if(tempList.size() > 1) {
            stringBuilder.append(tempList.get(tempList.size()-1));
        }


        return stringBuilder.toString();
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
