package com.github.houbb.leetcode.F100T200;

import java.util.*;

public class T126_WordLadderIIV3 {

    public static void main(String[] args) {
        System.out.println(new T126_WordLadderIIV3().findLadders("cet", "ism", Arrays.asList("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim")));
    }

    /**
     * 最小路径大小
     */
    private int minPathSize = 0;

    /**
     * BFS 中的链接信息
     */
    private Map<String, List<String>> map = new HashMap<>();

    /**
     * 依然超时
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // dfs 首先获取最小路径
        minPathSize = ladderLength(beginWord, endWord, wordList);

        //11 个
        System.out.println("MIN: " + minPathSize);

        List<List<String>> resultList = new ArrayList<>();
        // 快速失败
        if(minPathSize <= 0) {
            return resultList;
        }

        List<String> tempList = new ArrayList<>();
        tempList.add(beginWord);

        // 对数据提前处理？
        //map 构建几毫秒，耗时不多。不过应该可以优化。
        Map<String, List<String>> changeWordMap = buildWordChangeMap(beginWord, wordList);

        System.out.println(changeWordMap);

        this.backtrack(resultList, beginWord, endWord, changeWordMap, tempList, 0);

        // 最短路径，而不是所有路径？
        return resultList;
    }

    /**
     * 127 中的，获取最小路径
     * @param beginWord 开始
     * @param endWord 结束
     * @param wordList 单词字典
     * @return 结果
     */
    private int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) {
            return 0;
        }

        return bfs(beginSet, endSet, wordSet, 1);
    }

    private int bfs(Set<String> beginSet, Set<String> endSet, Set<String> wordSet, int result){
        if(beginSet.isEmpty() || endSet.isEmpty()) {
            return 0;
        }

        result++;

        // 从字典中，移除了开始的集合？
        wordSet.removeAll(beginSet);

        Set<String> nextSet = new HashSet<>();

        // 遍历开始的 set
        for(String str : beginSet){

            // 这里核心算法应该是类似的。
            char[] chs = str.toCharArray();
            for(int i = 0; i < chs.length; i++){
                char c = chs[i];
                for(char j = 'a'; j <= 'z'; j++){
                    chs[i] = j;

                    // a-z 的变化开始词的每一个字符，如果字典中不存在，则跳过。
                    // 如果和终止词相同，则结束。

                    String tmp = new String(chs);
                    if(!wordSet.contains(tmp)) {
                        continue;
                    }
                    if(endSet.contains(tmp)) {
                        return result;
                    }
                    nextSet.add(tmp);
                }
                chs[i] = c;
            }
        }
        // 这里是优化的原因吗?
        // 其实最初的 endSet 中只有一个元素，那就是 endword 终止词
        // 这里会进行对比，入参时交换了  endSet 和 nextSet 的顺序？？
        // serch 中，最大的计算量在于对 benginSet 的 a-z 穷举变化，所以数量越小越好。

        return nextSet.size() > endSet.size() ? bfs(endSet, nextSet, wordSet, result) : bfs(nextSet, endSet, wordSet, result);
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
        List<String> beginWordChangeOneList = changeWordMap.get(beginWord);
        if(beginWordChangeOneList == null
            || tempList.size() > minPathSize) {
            // 什么时候中断呢？beginWordChangeOneList 说明无法进行下去
            // 长度的剪枝已经处理了，那么，为什么还是这么慢呢？

            return;
        } else if(beginWord.equals(endWord)) {
            // 符合条件
            resultList.add(new ArrayList<>(tempList));
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

                //输出
//                logTime(tempList.toString());

                // 什么时候回溯？
                backtrack(resultList, newBeginWord, endWord, changeWordMap, tempList, index+1);
                // backtrack
                tempList.remove(tempList.size()-1);
            }
        }
    }

    private void logTime(String text) {
        System.out.println(System.currentTimeMillis() + ": " + text);
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
