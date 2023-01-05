package com.github.houbb.leetcode.F100T200;

import java.util.*;

public class T126_WordLadderIIV_OTHER {

    public static void main(String[] args) {
        System.out.println(new T126_WordLadderIIV_OTHER().findLadders("cet", "ism", Arrays.asList("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim")));
    }

    Map<String, List<String>> map;

    List<List<String>> results;

    public List<List<String>> findLadders(String start, String end, List<String> dict) {
        dict = new ArrayList<>(dict);

        results = new ArrayList<>();
        if (dict.size() == 0) {
            return results;
        }

        int min = Integer.MAX_VALUE;

        Queue<String> queue = new ArrayDeque<String>();
        queue.add(start);

        map = new HashMap<>();

        Map<String, Integer> ladder = new HashMap<String, Integer>();
        for (String string : dict) {
            ladder.put(string, Integer.MAX_VALUE);
        }

        ladder.put(start, 0);

        dict.add(end);
        //BFS: Dijisktra search
        while (!queue.isEmpty()) {

            String word = queue.poll();

            int step = ladder.get(word) + 1;//'step' indicates how many steps are needed to travel to one word.

            if (step > min) {
                break;
            }

            for (int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    builder.setCharAt(i, ch);
                    String new_word = builder.toString();
                    if (ladder.containsKey(new_word)) {

                        if (step > ladder.get(new_word))//Check if it is the shortest path to one word.
                        {
                            continue;
                        } else if (step < ladder.get(new_word)) {
                            queue.add(new_word);
                            ladder.put(new_word, step);
                        } else {
                            ;// It is a KEY line. If one word already appeared in one ladder,
                        }
                        // Do not insert the same word inside the queue twice. Otherwise it gets TLE.

                        if (map.containsKey(new_word)) //Build adjacent Graph
                        {
                            map.get(new_word).add(word);
                        } else {
                            List<String> list = new LinkedList<String>();
                            list.add(word);
                            map.put(new_word, list);
                            //It is possible to write three lines in one:
                            //map.put(new_word,new LinkedList<String>(Arrays.asList(new String[]{word})));
                            //Which one is better?
                        }

                        if (new_word.equals(end)) {
                            min = step;
                        }
                    }//End if dict contains new_word
                }//End:Iteration from 'a' to 'z'
            }//End:Iteration from the first to the last
        }//End While


        //BackTracking
        LinkedList<String> result = new LinkedList<>();
        backTrace(end, start, result);

        return results;
    }

    private void backTrace(String word, String start, List<String> list) {
        if (word.equals(start)) {
            list.add(0, start);
            results.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }

        list.add(0, word);
        if (map.get(word) != null) {
            for (String s : map.get(word)) {
                backTrace(s, start, list);
            }
        }
        list.remove(0);
    }

}
