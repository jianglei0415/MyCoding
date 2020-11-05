package bfs;

import java.util.*;

/**
 * @author jianglei
 * @date 2020/11/5 19:16
 * <p>
 * 题号：#127. 单词接龙
 * <p>
 * 给定两个单词（beginWord 和 endWord）和一个字典，
 * 找到从 beginWord 到 endWord 的最短转换序列的长度。
 * 转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * <p>
 * 说明:
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * <p>
 * 示例 1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出: 5
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * <p>
 * 示例 2:
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 输出: 0
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class LadderLength_127 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                String currWord = queue.poll();
                if (changeWordEveryOneLetter(currWord, endWord, queue, visited, wordSet)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    private static boolean changeWordEveryOneLetter(String currWord, String endWord, Queue<String> queue, Set<String> visited, Set<String> wordSet) {
        char[] charArray = currWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            char originChar = charArray[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == originChar) {
                    continue;
                }
                charArray[i] = j;
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }

                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            charArray[i] = originChar;
        }
        return false;
    }

    public static void main(String[] args) {
        String beginWord_1 = "hit";
        String endWord_1 = "cog";
        List<String> wordList_1 = new ArrayList<>();
        wordList_1.add("hot");
        wordList_1.add("dot");
        wordList_1.add("dog");
        wordList_1.add("lot");
        wordList_1.add("log");
        wordList_1.add("cog");
        int i1 = ladderLength(beginWord_1, endWord_1, wordList_1);
        System.out.println(i1);

        String beginWord_2 = "hit";
        String endWord_2 = "cog";
        List<String> wordList_2 = new ArrayList<>();
        wordList_2.add("hot");
        wordList_2.add("dot");
        wordList_2.add("dog");
        wordList_2.add("lot");
        wordList_2.add("log");
        int i2 = ladderLength(beginWord_2, endWord_2, wordList_2);
        System.out.println(i2);
    }
}
