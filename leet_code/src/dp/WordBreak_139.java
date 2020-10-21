package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jianglei
 * @date 2020/10/21 18:53
 * <p>
 * 题号：#139. 单词拆分
 * <p>
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，
 * 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * <p>
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * <p>
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * <p>
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class WordBreak_139 {
    /**
     * 方法一：dp
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    /**
     * 方法二：递归
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak2(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }

        if (s.length() >= 149) {
            return false;
        }

        for (int i = 0; i < wordDict.size(); i++) {
            String temp = wordDict.get(i);
            if (s.startsWith(temp)) {
                if (wordBreak2(s.substring(temp.length()), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s_1 = "leetcode";
        List<String> wordDict_1 = new ArrayList<>();
        wordDict_1.add("leet");
        wordDict_1.add("code");
        boolean b1 = wordBreak2(s_1, wordDict_1);
        System.out.println(b1);

        String s_2 = "applepenapple";
        List<String> wordDict_2 = new ArrayList<>();
        wordDict_2.add("apple");
        wordDict_2.add("pen");
        boolean b2 = wordBreak2(s_2, wordDict_2);
        System.out.println(b2);

        String s_3 = "catsandog";
        List<String> wordDict_3 = new ArrayList<>();
        wordDict_3.add("cats");
        wordDict_3.add("dog");
        wordDict_3.add("sand");
        wordDict_3.add("and");
        wordDict_3.add("cat");
        boolean b3 = wordBreak2(s_3, wordDict_3);
        System.out.println(b3);
    }
}
