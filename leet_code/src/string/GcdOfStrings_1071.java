package string;

/**
 * @author jianglei
 * @date 2020/3/12 11:52
 * <p>
 * 题号：#1071. 字符串的最大公因子
 * <p>
 * 对于字符串 S 和 T，
 * 只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，
 * 我们才认定 “T 能除尽 S”。
 * 返回最长字符串 X，
 * 要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * <p>
 * 示例 1：
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * <p>
 * 示例 2：
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * <p>
 * 示例 3：
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 * <p>
 * 提示：
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 */
public class GcdOfStrings_1071 {
    private static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        String str11 = "ABCABC";
        String str21 = "ABC";
        String s1 = gcdOfStrings(str11, str21);
        System.out.println(s1);

        String str12 = "ABABAB";
        String str22 = "ABAB";
        String s2 = gcdOfStrings(str12, str22);
        System.out.println(s2);

        String str13 = "LEET";
        String str23 = "CODE";
        String s3 = gcdOfStrings(str13, str23);
        System.out.println(s3);
    }
}
