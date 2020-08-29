package string;

import java.util.Arrays;

/**
 * @author jianglei
 * @date 2020/8/29 15:49
 * <p>
 * 题号：#214. 最短回文串
 * <p>
 * 给定一个字符串 s，
 * 你可以通过在字符串前面添加字符将其转换为回文串。
 * 找到并返回可以用这种方式转换的最短回文串。
 * <p>
 * 示例 1:
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 * <p>
 * 示例 2:
 * 输入: "abcd"
 * 输出: "dcbabcd"
 */
public class ShortestPalindrome_214 {
    public static String shortestPalindrome(String s) {
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

        int best = -1;
        for (int i = n - 1; i >= 0; i--) {
            while (best != -1 && s.charAt(best + 1) != s.charAt(i)) {
                best = fail[best];
            }
            if (s.charAt(best + 1) == s.charAt(i)) {
                ++best;
            }
        }

        String add = (best == n - 1 ? "" : s.substring(best + 1));
        StringBuffer result = new StringBuffer(add).reverse();
        result.append(s);
        return result.toString();
    }

    public static void main(String[] args) {
        String s_1 = "aacecaaa";
        String s1 = shortestPalindrome(s_1);
        System.out.println(s1);

        String s_2 = "abcd";
        String s2 = shortestPalindrome(s_2);
        System.out.println(s2);
    }
}
