package string;

import java.util.Arrays;

/**
 * @author jianglei
 * @date 2020/8/24 8:41
 * <p>
 * 题号：#459. 重复的子字符串
 * <p>
 * 给定一个非空的字符串，
 * 判断它是否可以由它的一个子串重复多次构成。
 * 给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * <p>
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 * <p>
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class RepeatedSubstringPattern_459 {
    public static boolean repeatedSubstringPattern(String s) {
        return kmp(s);
    }

    private static boolean kmp(String s) {
        int n = s.length();
        int[] fail = new int[n];
        Arrays.fill(fail, -1);
        for (int i = 1; i < n; i++) {
            int j = fail[i - 1];
            while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                j = fail[j];
            }
            if (s.charAt(j + 1) == s.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        return fail[n - 1] != -1 && n % (n - fail[n - 1] - 1) == 0;
    }


    public static void main(String[] args) {
        String s_1 = "abab";
        boolean b1 = repeatedSubstringPattern(s_1);
        System.out.println(b1);

        String s_2 = "aba";
        boolean b2 = repeatedSubstringPattern(s_2);
        System.out.println(b2);

        String s_3 = "abcabcabcabc";
        boolean b3 = repeatedSubstringPattern(s_3);
        System.out.println(b3);
    }
}
