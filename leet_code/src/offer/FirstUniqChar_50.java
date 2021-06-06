package offer;

/**
 * @author jianglei
 * @date 2021/6/6 16:40
 * <p>
 * 题号：#剑指 Offer 50. 第一个只出现一次的字符
 * <p>
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例:
 * s = "abaccdeff"
 * 返回 "b"
 * <p>
 * s = ""
 * 返回 " "
 * <p>
 * 限制：
 * 0 <= s 的长度 <= 50000
 */
public class FirstUniqChar_50 {
    public static char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }

        int[] temp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            temp[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (temp[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        char c1 = firstUniqChar("abaccdeff");
        System.out.println(c1);

        char c2 = firstUniqChar("");
        System.out.println(c2);

        char c3 = firstUniqChar("leetcode");
        System.out.println(c3);

        char c4 = firstUniqChar("cc");
        System.out.println(c4);
    }
}
