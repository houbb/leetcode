package com.github.houbb.leetcode.F100T200;

import java.util.*;

public class T126_WordLadderII {

    public static void main(String[] args) {
        //[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
        //[[hit, hot, dot, dog, log, cog], [hit, hot, dot, dog, cog], [hit, hot, dot, lot, log, cog], [hit, hot, lot, log, cog]]

//        System.out.println(new T126_WordLadderII().findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
//        System.out.println(new T126_WordLadderII().findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
//        System.out.println(new T126_WordLadderII().findLadders("hot", "dog", Arrays.asList("hot","dog","dot")));
        System.out.println(new T126_WordLadderII().findLadders("qa", "sq", Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye")));
    }

    /**
     * 最小路径大小
     */
    private int minPathSize = Integer.MAX_VALUE;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> resultList = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        tempList.add(beginWord);

        // 对数据提前处理？
        //map 构建几毫秒，耗时不多。不过应该可以优化。
        Map<String, List<String>> changeWordMap = buildWordChangeMap(beginWord, wordList);

        this.backtrack(resultList, beginWord, endWord, changeWordMap, tempList, 0);

        // 最短路径，而不是所有路径？
        return filterList(resultList);
    }

    public List<List<String>> filterList(List<List<String>>  allList) {
        if(allList.size() <= 0) {
            return allList;
        }

        // 过滤
        List<List<String>> resultList = new ArrayList<>();
        for(List<String> paths : allList) {
            if(paths.size() <= minPathSize) {
                resultList.add(paths);
            }
        }

        return resultList;
    }


    /**
     * 终止条件
     *
     * @param resultList 结果
     * @param beginWord 开始词
     * @param endWord 终止词
     * @param changeWordMap 变更为1的字典映射
     * @param tempList 存放临时的路径
     */
    private void backtrack(List<List<String>> resultList,
                           String beginWord,
                           String endWord,
                           Map<String, List<String>> changeWordMap,
                           List<String> tempList,
                           int index) {
        System.out.println("backtracking beginWord" + beginWord + ":" + tempList);

        List<String> beginWordChangeOneList = changeWordMap.get(beginWord);
        if(beginWordChangeOneList == null
            || tempList.size() > minPathSize) {
            // 什么时候中断呢？
            return;
        } else if(beginWord.equals(endWord)) {
            // 更新大小
            if(tempList.size() < minPathSize) {
                minPathSize = tempList.size();
            }
            // 过滤掉不是最小的
            // 什么时候符合结果？
            resultList.add(new ArrayList<>(tempList));

            // 但是这样，还是可能会导致添加的元素长度过长
            // 比如第一次长度为10， 后续越来越少，只有最小的其实才符合。

        } else {
            // 更新开始信息
            // 在所有的剩余集合中，选择信息
            for(int i = 0; i < beginWordChangeOneList.size(); i++) {
                String newBeginWord = beginWordChangeOneList.get(i);
                // 这里有一个问题，其实单词不应该被重复使用，否则会死循环。
                if(tempList.contains(newBeginWord)) {
                    continue;
                }

                tempList.add(newBeginWord);

                // 什么时候回溯？
                backtrack(resultList, newBeginWord, endWord, changeWordMap, tempList, index+1);
                // backtrack
                tempList.remove(tempList.size()-1);
            }
        }
    }

    /**
     * 构建1个变换量的词库映射
     *
     * wordlist 不超过 500 个。
     * 如何找到变化为1的单词呢？
     *
     * 其实也就是2个单词不同的字母只有1个。
     *
     *
     *
     * 【发现测试用例7，并不需要保证次序】
     * PS: 这里这种处理存在一个问题，那就是必须在后边的才行。
     * 从而保证一个顺序：beginWord -> s1 -> s2 -> ... -> sk
     *
     * @param beginWord 开始词
     * @param wordList 单词列表
     * @return 结果
     */
    private Map<String, List<String>> buildWordChangeMap(String beginWord, List<String> wordList) {
        Map<String, List<String>> resultMap = new HashMap<>();

        // 开始词
        resultMap.put(beginWord, getMappingList(beginWord,  wordList));

        // 2 次迭代
        for(int i = 0; i < wordList.size(); i++) {
            String s = wordList.get(i);
            List<String> tempList = getMappingList(s, wordList);
            resultMap.put(s, tempList);
        }

        return resultMap;
    }

    private List<String> getMappingList(String word, List<String> wordList) {
        List<String> tempList = new ArrayList<>();

        for(int i = 0; i < wordList.size(); i++) {
            String t = wordList.get(i);

            // 差距为1的单词
            if(isDifferOne(word, t)) {
                tempList.add(t);
            }
        }

        return tempList;
    }

    /**
     * 两个字符的差距是否为 1
     * @param s 原始
     * @param t 目标
     * @return 结果
     */
    private boolean isDifferOne(String s, String t) {
        int differCount = 0;
        for(int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if(sc != tc) {
                differCount++;
            }
        }

        return differCount == 1;
    }


}
