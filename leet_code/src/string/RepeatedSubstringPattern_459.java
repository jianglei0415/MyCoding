package string;

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
        for (int i = 1; i * 2 <= s.length(); i++) {
            boolean flag = true;
            if (s.length() % i == 0) {
                for (int j = i; j < s.length() - 1; j++) {
                    if (s.charAt(i) != s.charAt(j - i)) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
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
