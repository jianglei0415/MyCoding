package string;

/**
 * @author jianglei
 * @date 2020/8/19 23:19
 * <p>
 * 题号：#5. 最长回文子串
 * <p>
 * 给定一个字符串 s，
 * 找到 s 中最长的回文子串。
 * 你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome_5 {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = round(s, i, i);
            int len2 = round(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int round(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s1 = "babad";
        String palindrome1 = longestPalindrome(s1);
        System.out.println(palindrome1);

        String s2 = "cbbd";
        String palindrome2 = longestPalindrome(s2);
        System.out.println(palindrome2);
    }
}
