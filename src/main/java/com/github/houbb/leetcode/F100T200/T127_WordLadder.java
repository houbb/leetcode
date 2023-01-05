package com.github.houbb.leetcode.F100T200;

import java.util.*;

public class T127_WordLadder {

    public static void main(String[] args) {
//        System.out.println(new T126_WordLadderII().findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
//        System.out.println(new T126_WordLadderII().findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
//        System.out.println(new T126_WordLadderII().findLadders("hot", "dog", Arrays.asList("hot","dog","dot")));
        System.out.println(new T127_WordLadder().ladderLength("be", "ko", Arrays.asList("ce","mo","ko","me","co")));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //fast-return
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) {
            return 0;
        }

        // 存放 BFS 元素,初始为开始词
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        // 已经访问过得元素
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // 变化的结果
        int result = 1;

        // 遍历整个队列
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                // 获取队列中的第一个元素
                String word = queue.poll();
                // 如果和终止词相同，则迭代结束，直接返回结果。
                if(word.equals(endWord)) {
                    return result;
                }

                for(int j = 0; j < word.length(); j++){
                    for(int k = 'a'; k <= 'z'; k++){
                        // 穷举 a-z 变化 word 单词的每一位，
                        char[] arr = word.toCharArray();
                        arr[j] = (char) k;

                        String str = new String(arr);

                        // 如果单词中有这个词
                        // 而且已经没有处理过，则加入进来。
                        if(wordSet.contains(str)
                                && !visited.contains(str)){
                            // 更新 queue 中元素
                            queue.add(str);
                            // 更新访问过的元素
                            visited.add(str);
                        }
                    }
                }
            }
            ++result;
        }

        // 无匹配
        return 0;
    }

}
